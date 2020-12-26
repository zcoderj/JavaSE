package com.mthc.class01.test2;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T03Synchronized
 * @Description TODO 同步方法和非同步方式是否可以同时调用？ 可！
 * @Author CJ
 * @Date 2020/11/17 017 20:32
 * @Version 1.0
 **/
public class T03Synchronized {

	public synchronized void m1() {
		System.out.println("m1 start...");
		try {
			TimeUnit.MILLISECONDS.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m1 end...");
	}

	public void m2() {
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m2 run...");
	}

	public static void main(String[] args) {
		T03Synchronized t = new T03Synchronized();
		new Thread(t::m1).start();
		new Thread(t::m2).start();
	}
}
