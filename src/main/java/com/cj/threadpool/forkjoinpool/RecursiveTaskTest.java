package com.cj.threadpool.forkjoinpool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @ClassName RecursiveTaskTest
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/23 023 15:03
 * @Version 1.0
 **/
public class RecursiveTaskTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		int[] array = new int[100];
		Random random = new Random();
		int total = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
			total += array[i];
		}
		System.out.println("总和：" + total);
		SumTask sumTask = new SumTask(array, 0, array.length);
		// 创建一个通用池，这是jdk1.8提供的功能
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
//		ForkJoinTask<Integer> future = forkJoinPool.submit(sumTask);
		Future<Integer> future = forkJoinPool.submit(sumTask);
		System.out.println("多线程执行结果：" + future.get());
		forkJoinPool.shutdown();
	}
}

class SumTask extends RecursiveTask<Integer> {
	private static final int THRESHOLD = 20; //每个小任务 最多只累加20个数
	private int array[];
	private int start;
	private int end;

	// 累加
	public SumTask(int[] array, int start, int end) {
		super();
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		if (end - start < THRESHOLD) {
			for (int i = start; i < end; i++) {
				System.out.println(Thread.currentThread().getName() + " =>" + array[i]);
				sum += array[i];
			}
			return sum;
		} else {
			int middle = start + (end - start) / 2;
			SumTask left = new SumTask(array, start, middle);
			SumTask right = new SumTask(array, middle, end);
			// 并行执行两个小任务
			left.fork();
			right.fork();
			// 将两个小任务的结果合并
			return left.join() + right.join();
		}
	}
}
