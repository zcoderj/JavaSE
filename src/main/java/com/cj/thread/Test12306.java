package com.cj.thread;

/**
 * @ClassName Test12306
 * @Description TODO 不安全
 * @Author CJ
 * @Date 2020/6/21 021 10:54
 * @Version 1.0
 **/
public class Test12306 implements Runnable {

	private int ticketNum = 100;

	@Override
	public void run() {
		while (true) {
			if (this.ticketNum <= 0) {
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "==>" + ticketNum--);
		}
	}

	public static void main(String[] args) {
		Test12306 test12306 = new Test12306();
		new Thread(test12306, "Mack").start();
		new Thread(test12306, "Mary").start();
		new Thread(test12306, "Jack").start();
	}
}
