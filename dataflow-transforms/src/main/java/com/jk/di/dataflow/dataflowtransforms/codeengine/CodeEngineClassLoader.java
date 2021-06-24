package com.jk.di.dataflow.dataflowtransforms.codeengine;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @author chao
 * @description
 * @create 2021-06-02 22:06
 */
public class CodeEngineClassLoader extends URLClassLoader {

    private final URL pluginLocation;

    static {
        ClassLoader.registerAsParallelCapable();
    }

    private CodeEngineClassLoader(URL pluginLocation, URL[] urls, String name) {
        super(urls);
        this.pluginLocation = pluginLocation;
        instantiateClass(name);
    }

    public String location() {
        return pluginLocation.toString();
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            Class<?> klass = findLoadedClass(name);
            if (!this.pluginLocation.getFile().contains(name) && klass == null) {
                klass = getSystemClassLoader().loadClass(name);
            }
            if (klass == null) {
                throw new ClassNotFoundException(name);
            }
            if (resolve) {
                resolveClass(klass);
            }
            return klass;
        }
    }

    public static CodeEngineClassLoader newInstance(URL url, String name) {
        CodeEngineClassLoader pcl =
                AccessController.doPrivileged(
                        (PrivilegedAction<CodeEngineClassLoader>)
                                () -> new CodeEngineClassLoader(url, new URL[] {url}, name));
        return pcl;
    }

    public void instantiateClass(String name) {
        try {
           // byte[] raw = IOUtils.toByteArray(pluginLocation);
            byte[] raw = IOUtils.toByteArray(new FileInputStream(new File("/Users/happygiraffe/Downloads/Sid_2985_f0a72ef72985defd29854ecf2985903129852155508b8611.class")));
            defineClass(name, raw, 0, raw.length);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

