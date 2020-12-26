package com.cj.thread;

import java.util.concurrent.*;

/**
 * @ClassName CreateThread1
 * @Description TODO 创建线程四种方式
 * @Author CJ
 * @Date 2020/10/16 016 16:16
 * @Version 1.0
 **/
public class CreateThread {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
//		new MyThread1().start();
//
//		new Thread(new MyThread2()).start();
//		new Thread(() -> System.out.println("MyThread2.1...")).start();
		// 共享资源
//		MyThread2 myThread2 = new MyThread2();
//		new Thread(myThread2).start();
//		new Thread(myThread2).start();

//		FutureTask<String> task = new FutureTask<>(new MyThread3());
//		new Thread(task).start();
//		System.out.println(task.get());

//		// 共享数据
//		MyThread3 myThread3 = new MyThread3();
//		FutureTask<String> task = new FutureTask<>(myThread3);
//		new Thread(task).start();
//		System.out.println(task.get());
//		FutureTask<String> task2 = new FutureTask<>(myThread3);
//		new Thread(task2).start();
//		System.out.println(task2.get());

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		// Runnable
//		executorService.execute(() -> System.out.println("Executors1..."));
		// Callable
//		Future<String> future = executorService.submit(() -> "Executors2...");
//		System.out.println(future.get());
//
		// 多次执行时不同线程
//		Future<String> future1 = executorService.submit(() -> {
//			Thread.currentThread().getName()
//		});
//		Future<String> future2 = executorService.submit(() -> {
//			Thread.currentThread().getName()
//		});
//		System.out.println(future1.get());
//		System.out.println(future2.get());
//
		// 共享资源
//		Future<String> future1 = executorService.submit(myThread3);
//		System.out.println(future1.get());
//		Future<String> future2 = executorService.submit(myThread3);
//		System.out.println(future2.get());

		executorService.shutdown();
	}
}

class MyThread1 extends Thread {
	@Override
	public void run() {
		System.out.println("MyThread1...");
	}
}

class MyThread2 implements Runnable {
	private int num = 0;

	@Override
	public void run() {
		System.out.println("MyThread2..." + ++num);
	}
}

class MyThread3 implements Callable<String> {

	public int num = 0;

	@Override
	public String call() throws Exception {
		return "MyThread3..." + ++num;
	}
}