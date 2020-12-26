package com.mthc.class01.test2;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T04Synchronized
 * @Description TODO 面试题：模拟银行账户，对业务写方法加锁，对业务读方法不加锁，这样行不行？
 *                   不加会出现脏读的问题，但如果需求不严格要求，即允许脏读的情况出现，那么可以不加。
 * @Author CJ
 * @Date 2020/11/17 017 20:38
 * @Version 1.0
 **/
public class T04Synchronized {
	private String name;
	private double balance;

	public synchronized void set(String name, double balance) {
		this.name = name;
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.balance = balance;
	}

	public double get(String name) {
		return balance;
	}

	public static void main(String[] args) {
		T04Synchronized t = new T04Synchronized();
		new Thread(() -> t.set("zs", 100)).start();
		System.out.println(t.get("zs"));

		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(t.get("zs"));
	}
}
