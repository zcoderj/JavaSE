package com.cj.thread;

/**
 * @ClassName ThreadLocalTest
 * @Description TODO ThreadLocal ==> 每个线程有自己的本地存储区域，相互不影响
 * @Author CJ
 * @Date 2020/6/22 022 14:10
 * @Version 1.0
 **/
public class ThreadLocalTest01 {

	//	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
	// 更改初始值
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 100);

	public static void main(String[] args) {
		// 获取值
		System.out.println(Thread.currentThread().getName() + "==>" + threadLocal.get());
		// 设置值
		threadLocal.set(120);
		System.out.println(Thread.currentThread().getName() + "==>" + threadLocal.get());

		// start之前，MyRun初始化的线程是main，故在MyRun初始化方法中的ThreadLocal是main
		new Thread(new MyRun()).start();

	}

	static class MyRun implements Runnable {

		public MyRun() {
			threadLocal.set(140);
			// main
			System.out.println(Thread.currentThread().getName() + "==>" + threadLocal.get());
		}

		@Override
		public void run() {
			threadLocal.set(130);
			System.out.println(Thread.currentThread().getName() + "==>" + threadLocal.get());
		}
	}
}

