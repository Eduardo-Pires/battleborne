/*
package com.atlassoftware.pootrabalhofinal.entities;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBeanFactory {
    private Object bean;

    ProxyBeanFactory(Object bean) {
        this.bean = bean;
    }

    public Object forInterface(String interfaceType) throws ClassNotFoundException{
        Class<?> class1 = Class.forName(interfaceType);
        Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{class1}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                for (Method beanMethod : bean.getClass().getMethods()) {
                    return beanMethod.invoke(bean, args);
                }
                return null;
            }
        });
    }
}
*/