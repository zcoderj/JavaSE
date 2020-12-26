package com.mthc.class02;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T02VolatileReference
 * @Description TODO volatile 修饰引用类型（包括数组）时，只能保证引用本省的可见性，并不能保证内部字段的可见性
 * @Author CJ
 * @Date 2020/11/21 021 08:25
 * @Version 1.0
 **/
public class T02VolatileReference {

	boolean running = true;
	volatile static T02VolatileReference T = new T02VolatileReference();

	public void m() {
		System.out.println("m start...");
		while (running) {
		}
		System.out.println("m end...");
	}

	public static void main(String[] args) {
		new Thread(T::m, "t").start();

		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		T.running = false;
	}
}
