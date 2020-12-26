package com.cj.thread;

/**
 * @ClassName ThreadTest01
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/20 020 14:39
 * @Version 1.0
 **/
public class ThreadTest01 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "coding...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		ThreadTest01 threadTest01 = new ThreadTest01();
		// 其他代码之前调用start方法，会开启一个新线程，告知cpu调度器可以调用了
		// 然后继续下面代码（不保证立即执行）（两条线）
		// 会有两条线同时进行的效果
		threadTest01.start();
//		threadTest01.run();// 普通方法的调用（一条线）

		for (int i = 0; i < 10; i++) {
			System.out.println(i + "listening...");
			Thread.sleep(1000);
		}

		// 若在其他代码之后调用start方法，也会开启一个新的线程，
		// 但在此之前，其他代码已经先执行了，将没有两条线同时进行的效果
//		threadTest01.start();
	}
}
