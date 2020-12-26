package com.mthc.class01.test2;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T06Synchronized
 * @Description TODO 一个同步方法可以调用另一个同步方法，一个线程已经拥有某个对象的锁，再次申请该锁的时候仍然会得到该锁，
 *                   也就是说synchronized获得的锁式可重入的。（可重入锁）
 *                   继承中可能发生的情形，子类调用父类的同步方法
 * @Author CJ
 * @Date 2020/11/17 017 22:20
 * @Version 1.0
 **/
public class T06Synchronized {
	public static void main(String[] args) {
		new Son().m();
	}
}

class Farther {
	public synchronized void m() {
		System.out.println("farther start...");
		try {
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("farther end...");
	}
}

class Son extends Farther {
	@Override
	public synchronized void m() {
		System.out.println("son start...");
		super.m();
		System.out.println("son end...");
	}
}
