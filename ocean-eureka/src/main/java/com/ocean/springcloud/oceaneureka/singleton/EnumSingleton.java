package com.ocean.springcloud.oceaneureka.singleton;

/**
 * @author 季超
 * @create 2018-11-27 10:43
 * @desc
 **/
public class EnumSingleton{
    private EnumSingleton(){}
    public static EnumSingleton getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private static enum Singleton{
        INSTANCE;

        private EnumSingleton singleton;
        //JVM会保证此方法绝对只调用一次
        private Singleton(){
            singleton = new EnumSingleton();
        }
        public EnumSingleton getInstance(){
            return singleton;
        }
    }
}
