package com.cykj.myuitl;

public class ObjectFactory {

    //获取地址下的类对象
    public static Object newInstance(Class clazz) {
        Object object = null;
        try {
            object = clazz.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return object;
    }
}
