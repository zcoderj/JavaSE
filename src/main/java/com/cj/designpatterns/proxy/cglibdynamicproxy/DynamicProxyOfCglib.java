package com.cj.designpatterns.proxy.cglibdynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName DynamicProxyOfCglib
 * @Description TODO 使用cglib实现动态代理不需要接口
 * @Author CJ
 * @Date 2020/9/12 012 13:04
 * @Version 1.0
 **/
public class DynamicProxyOfCglib {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Tank.class);
		enhancer.setCallback(new TimeMethodInterceptor());
		Tank tank = (Tank) enhancer.create();
		tank.move();
	}
}

class TimeMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println(o.getClass().getSuperclass().getName());
		System.out.println("before...");
		Object result = methodProxy.invokeSuper(o, objects);
		System.out.println("after...");
		return result;
	}
}

class Tank {
	public void move() {
		System.out.println("tank moving...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
