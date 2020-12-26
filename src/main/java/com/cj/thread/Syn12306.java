package com.cj.thread;

/**
 * @ClassName Syn12306
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/21 021 15:42
 * @Version 1.0
 **/
public class Syn12306 implements Runnable {

	private int ticketNum = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			test();
		}
	}

	// 同步方法，synchronized加于方法上，性能低
	private synchronized void test() {
		if (this.ticketNum == 0) {
			this.flag = false;
			return;
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "==>" + this.ticketNum--);
	}

	public static void main(String[] args) {
		Syn12306 syn12306 = new Syn12306();
		new Thread(syn12306, "Mack").start();
		new Thread(syn12306, "Mary").start();
		new Thread(syn12306, "Jack").start();

	}
}
