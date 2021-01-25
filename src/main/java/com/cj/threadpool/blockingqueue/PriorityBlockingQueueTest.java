package com.cj.threadpool.blockingqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @ClassName PriorityBlockingQueueTest
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/23 023 18:33
 * @Version 1.0
 **/
public class PriorityBlockingQueueTest {
	public static void main(String[] args) throws InterruptedException {
		PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
		Task t1 = new Task(5, "five");
		Task t2 = new Task(3, "four");
		Task t3 = new Task(7, "seven");
		queue.add(t1);
		queue.add(t2);
		queue.add(t3);
		System.out.println(queue);
		System.out.println(queue.take().id);
		System.out.println(queue);
	}
}

class Task implements Comparable<Task> {
	public int id;
	public String name;

	public Task(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Task{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}

	@Override
	public int compareTo(Task o) {
		return this.id > o.id ? 1 : (this.id < o.id ? -1 : 0);
	}
}
