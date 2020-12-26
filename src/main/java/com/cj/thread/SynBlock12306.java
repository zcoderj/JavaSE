package com.cj.thread;

/**
 * @ClassName SynBlock12306
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/21 021 15:57
 * @Version 1.0
 **/
public class SynBlock12306 implements Runnable {

	private int ticketNum = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			test();
		}
	}

	private void test() {
		if (this.ticketNum == 0) {
			this.flag = false;
			return;
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 同步块，Double Checking，synchronized加于关键代码上，提升性能
		synchronized (this) {
			if (this.ticketNum == 0) {
				this.flag = false;
				return;
			}
			System.out.println(Thread.currentThread().getName() + "==>" + this.ticketNum--);
		}
	}

	public static void main(String[] args) {
		SynBlock12306 synBlock12306 = new SynBlock12306();
		new Thread(synBlock12306, "Mack").start();
		new Thread(synBlock12306, "Mary").start();
		new Thread(synBlock12306, "Jack").start();
	}
}
