package com.ocean.springcloud.oceannetty.ab;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author 季超
 * @create 2018-11-13 16:08
 * @desc
 **/
public class RoutingBeanProxyFactory {

    static Object createProxy(Class targetClass, Map<String, Object> beans){
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(targetClass);
        proxyFactory.addAdvice(new VersionRoutingMethodInterceptor(targetClass,beans));
        return proxyFactory.getProxy();
    }
    static class VersionRoutingMethodInterceptor implements MethodInterceptor{
        private String classSwitch;
        private Object beanSwitchOn;
        private Object beanOfSwitchOff;

        public VersionRoutingMethodInterceptor(Class targetClass,Map<String,Object> beans){
            //将接口名称的第一个字母转换成小写
            String interfaceName = StringUtils.uncapitalize(targetClass.getSimpleName());
            if (targetClass.isAnnotationPresent(RoutingSwitch.class)){
                this.classSwitch = ((RoutingSwitch)targetClass.getAnnotation(RoutingSwitch.class)).value();
            }
            this.beanSwitchOn = beans.get(this.buildBeanName(interfaceName,true));
            this.beanOfSwitchOff = beans.get(this.buildBeanName(interfaceName,false));
        }

        private String buildBeanName(String interfaceName, boolean isSwitchOn) {
            return interfaceName+"Impl"+(isSwitchOn ? "V1":"V1");
        }

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            Method method = invocation.getMethod();
            String switchName = this.classSwitch;
            if (method.isAnnotationPresent(RoutingSwitch.class)){
                switchName = method.getAnnotation(RoutingSwitch.class).value();
            }
            if (StringUtils.isBlank(switchName)){
                throw new IllegalStateException("RoutinSwitch value is blank,method:"+method.getName());
            }
            return invocation.getMethod().invoke(getTargetBean(switchName),invocation.getArguments());
        }

        private Object getTargetBean(String switchName) {
            boolean switchOn;
            if ("A".equals(switchName)){
                switchOn = false;
            }else if ("B".equals(switchName)){
                switchOn = true;
            }else{
                switchOn = true;
            }
            return switchOn ? beanSwitchOn:beanOfSwitchOff;
        }
    }


}
