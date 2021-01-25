package com.cj.threadpool.blockingqueue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @ClassName SynchronousQueueTest
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/23 023 18:52
 * @Version 1.0
 **/
public class SynchronousQueueTest {
	public static void main(String[] args) {
		SynchronousQueue<String> queue = new SynchronousQueue<>();
		SProducer producer = new SProducer(queue);
		SConsumer consumer1 = new SConsumer(queue);
		SConsumer consumer2 = new SConsumer(queue);
		new Thread(producer).start();
		new Thread(consumer1).start();
		new Thread(consumer2).start();
	}
}

class SProducer implements Runnable {
	protected BlockingQueue<String> blockingQueue;

	public SProducer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = UUID.randomUUID().toString();
				System.out.println("put:" + data);
				blockingQueue.put(data);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class SConsumer implements Runnable {
	private BlockingQueue<String> blockingQueue;

	public SConsumer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = blockingQueue.take();
				System.out.println(Thread.currentThread().getName() + " take:" + data);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


