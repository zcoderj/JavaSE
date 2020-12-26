package com.mthc.class01.test2;

/**
 * @ClassName T02Synchronized
 * @Description TODO
 * @Author CJ
 * @Date 2020/11/17 017 20:27
 * @Version 1.0
 **/
public class T02Synchronized implements Runnable {

	private int count = 100;

	@Override
	// 不加 synchronized 将出问题
	// 问题一，可能读不到其他线程对count的修改结果
	// 问题二，一个线程修改了count之后，若是在它输出之前，又有其他线程修改了count，那么输出的将与自己操作之后应有的结果不一致
	// 此处对方法加了synchronized之后，便无需对count加volatile了，因为synchronized即保证了原子性，也保证了可见性
	public synchronized void run() {
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}

	public static void main(String[] args) {
		T02Synchronized t = new T02Synchronized();
		for (int i = 0; i < 100; i++) {
			new Thread(t, "thread" + i).start();
		}
	}
}
