package com.cj.threadpool.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RecursiveActionTest
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/23 023 14:52
 * @Version 1.0
 **/
public class RecursiveActionTest {
	public static void main(String[] args) throws InterruptedException {
		PrintTask printTask = new PrintTask(0, 300);
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		forkJoinPool.submit(printTask);
		// 线程阻塞，等待所有任务完成
		forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);
		forkJoinPool.shutdown();
	}
}

class PrintTask extends RecursiveAction {
	private static final int THRESHOLD = 50; // 最多打印50个数
	private int start;
	private int end;

	public PrintTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if (end - start < THRESHOLD) {
			for (int i = start; i < end; i++) {
				System.out.println(Thread.currentThread().getName() + "==》" + i);
			}
		} else {
			int middle = start + (end - start) / 2;
			PrintTask left = new PrintTask(start, middle);
			PrintTask right = new PrintTask(middle, end);
			// 并行执行两个”小任务“
			left.fork();
			right.fork();
		}
	}
}
