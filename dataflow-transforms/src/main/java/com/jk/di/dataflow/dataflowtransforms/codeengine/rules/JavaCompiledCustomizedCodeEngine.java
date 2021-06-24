package com.jk.di.dataflow.dataflowtransforms.codeengine.rules;

import com.jk.di.dataflow.dataflowtransforms.codeengine.CodeEngineClassLoader;
import com.jk.di.dataflow.dataflowtransforms.codeengine.CustomizedCodeEngineException;
import com.jk.di.dataflow.dataflowtransforms.utils.JsonConvert;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chao
 * @description
 * @create 2021-06-02 22:10
 */
public class JavaCompiledCustomizedCodeEngine implements CustomizedCodeEngine {

    private static final String DP_CODE_ENGINE_LIB_PATH = "/Users/happygiraffe/Desktop/code/code-engine-libs";
    private static final String DP_DEPENDENCIES_PATH = "/Users/happygiraffe/Desktop/code/connector-plugins";
    private final Object engine;
    private final Method method;
    private final boolean isListReturnType;
    private final List<ParameterConverter> parameterConverters;

    public JavaCompiledCustomizedCodeEngine(URL url, String className)
            throws CustomizedCodeEngineException {
        try {
            addDpCodeEngineJarUrls(DP_CODE_ENGINE_LIB_PATH);
            addDpCodeEngineJarUrls(DP_CODE_ENGINE_LIB_PATH);
            addDpCodeEngineJarUrls(DP_DEPENDENCIES_PATH);
            engine = CodeEngineClassLoader.newInstance(url, className).loadClass(className).newInstance();
            Optional<Method> processMethod =
                    Stream.of(engine.getClass().getDeclaredMethods())
                            .filter(m -> Objects.equals("process", m.getName()))
                            .findFirst();
            if (!processMethod.isPresent()) {
                throw new IllegalArgumentException("Must declare a method with name 'process'.");
            } else {
                method = processMethod.get();
            }
            parameterConverters =
                    Arrays.stream(method.getParameterTypes())
                            .map(
                                    clz -> {
                                        if (clz == Map.class) {
                                            return (ParameterConverter)
                                                    (data, meta) -> {
                                                        try {
                                                            return JsonConvert.toMap(data);
                                                        } catch (JSONException e) {
                                                            throw new RuntimeException(e);
                                                        }
                                                    };
                                        } else if (Objects.equals(
                                                clz.getCanonicalName(), Object.class.getCanonicalName())) {
                                            try {
                                                Class jsonConvertClass =
                                                        clz.getClassLoader().loadClass(JsonConvert.class.getCanonicalName());
                                                Object jsonConvert = jsonConvertClass.newInstance();
                                                Method getObjectMethod =
                                                        jsonConvertClass.getDeclaredMethod(
                                                                "getObject", Object.class, Class.class);
                                                return (ParameterConverter)
                                                        (data, meta) -> {
                                                            try {
                                                                return getObjectMethod.invoke(
                                                                        jsonConvert, JsonConvert.getJsonString(meta), clz);
                                                            } catch (Exception e) {
                                                                throw new RuntimeException(e);
                                                            }
                                                        };
                                            } catch (Exception e) {
                                                throw new RuntimeException(e);
                                            }
                                        } else {
                                            throw new IllegalArgumentException("Unknown parameter class " + clz);
                                        }
                                    })
                            .collect(Collectors.toList());
            isListReturnType = method.getReturnType() == List.class;
        } catch (Exception e) {
            throw new CustomizedCodeEngineException(e);
        }
    }

    private Object[] convertToParameters(JSONObject data, Object meta) {
        return parameterConverters.stream().map(c -> c.convert(data, meta)).toArray(Object[]::new);
    }

    @Override
    public List<JSONObject> process(JSONObject data, Object meta)
            throws CustomizedCodeEngineException {
        try {
            List<JSONObject> list = new ArrayList<>();
            if (isListReturnType) {
                List<?> resultList = (List<?>) method.invoke(engine, convertToParameters(data, meta));
                if (Objects.isNull(resultList) || resultList.size() == 0) {
                    list.add(null);
                } else {
                    for (Object obj : resultList) {
                        list.add(new JSONObject((Map) obj));
                    }
                }
            } else {
                Map resultMap = (Map) method.invoke(engine, convertToParameters(data, meta));
                if (Objects.isNull(resultMap) || resultMap.size() == 0) {
                    list.add(null);
                } else {
                    list.add(new JSONObject(resultMap));
                }
            }
            return list;
        } catch (Exception e) {
            throw new CustomizedCodeEngineException(e);
        }
    }

    private void addDpCodeEngineJarUrls(String path) {
        File libFile = new File(path);
        if (libFile.exists() && libFile.isDirectory()) {
            File[] jarFiles = libFile.listFiles(file -> file.getName().endsWith(".jar"));
            if (jarFiles != null && jarFiles.length > 0) {
                URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
                List<String> urlPaths =
                        Arrays.stream(urlClassLoader.getURLs()).map(URL::getPath).collect(Collectors.toList());
                Class urlClass = URLClassLoader.class;
                try {
                    Method method = urlClass.getDeclaredMethod("addURL", URL.class);
                    method.setAccessible(true);
                    Arrays.stream(jarFiles)
                            .forEach(
                                    jarFile -> {
                                        try {
                                            if (!urlPaths.contains(jarFile.toURI().toURL().getPath())) {
                                                method.invoke(urlClassLoader, jarFile.toURI().toURL());
                                            }
                                        } catch (Exception ignore) {
                                        }
                                    });
                } catch (NoSuchMethodException ignore) {
                }
            }
        }
    }
}
