package com.cj.thread;

/**
 * @ClassName ThreadLocalTest02
 * @Description TODO InheritableThreadLocal ==> 继承上下文环境的数据，即子线程初始时有一份和父线程一样的数据
 * @Author CJ
 * @Date 2020/6/22 022 14:26
 * @Version 1.0
 **/
public class ThreadLocalTest02 {

	private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();

	public static void main(String[] args) {
		threadLocal.set(100);
		System.out.println(Thread.currentThread().getName() + "==>" + threadLocal.get());

		new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + "==>" + threadLocal.get());
			threadLocal.set(120);
			System.out.println(Thread.currentThread().getName() + "==>" + threadLocal.get());
		}).start();
	}
}
