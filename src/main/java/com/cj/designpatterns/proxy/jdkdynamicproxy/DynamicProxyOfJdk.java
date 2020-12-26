package com.cj.designpatterns.proxy.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.Instant;

/**
 * @ClassName DynamicProxyOfJdk
 * @Description TODO 使用jdk的动态代理，局限：被代理类必须实现于某个接口
 * @Author CJ
 * @Date 2020/9/12 012 11:03
 * @Version 1.0
 **/
public class DynamicProxyOfJdk {

	public static void main(String[] args) {
		Tank tank = new Tank();
		// 保存生成的代理类
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		Movable movable = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
				new Class[]{Movable.class},
				new TimeProxy(tank));
		movable.move();
	}
}

class TimeProxy implements InvocationHandler {

	Movable movable;

	public TimeProxy(Movable movable) {
		this.movable = movable;
	}

	public long before() {
		return Instant.now().toEpochMilli();
	}

	public long after() {
		return Instant.now().toEpochMilli();
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long start = before();
		Object o = method.invoke(movable, args);
		long end = after();
		System.out.println(end - start);
		return o;
	}
}

class Tank implements Movable {

	@Override
	public void move() {
		System.out.println("tank moving...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

interface Movable {

	void move();
}