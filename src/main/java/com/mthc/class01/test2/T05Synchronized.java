package com.mthc.class01.test2;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T05Synchronized
 * @Description TODO 一个同步方法可以调用另一个同步方法，一个线程已经拥有某个对象的锁，再次申请该锁的时候仍然会得到该锁，
 *                   也就是说synchronized获得的锁式可重入的。（可重入锁）
 * @Author CJ
 * @Date 2020/11/17 017 22:10
 * @Version 1.0
 **/
public class T05Synchronized {

	public synchronized void m1() {
		System.out.println("m1 start...");
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		m2();
		System.out.println("m1 end...");
	}

	public synchronized void m2() {
		System.out.println("m2...");
	}

	public static void main(String[] args) {
		new T05Synchronized().m1();
	}
}
