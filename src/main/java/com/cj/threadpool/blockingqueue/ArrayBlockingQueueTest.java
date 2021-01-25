package com.cj.threadpool.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName ArrayBlockingQueueTest
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/23 023 17:18
 * @Version 1.0
 **/
public class ArrayBlockingQueueTest {
	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);
		Producer producer = new Producer(blockingQueue);
		Consumer consumer = new Consumer(blockingQueue);
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}

class Producer implements Runnable {
	private BlockingQueue<Integer> blockingQueue;
	private static int element;

	public Producer(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			while (element < 10) {
				blockingQueue.put(element);
				Thread.sleep(50);
				System.out.println("生产者生产了元素：" + element);
				element++;
			}
		} catch (InterruptedException e) {
			System.out.println("生产者在等待空闲空间时被打断了。");
			e.printStackTrace();
		}
		System.out.println("生产者已经终止了生产过程。");
	}
}

class Consumer implements Runnable {
	private BlockingQueue<Integer> blockingQueue;

	public Consumer(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(200);
				System.out.println("消费者消费了元素：" + blockingQueue.take());
			}
		} catch (InterruptedException e) {
			System.out.println("消费者在等待新产品时被打断了。");
			e.printStackTrace();
		}
	}
}
