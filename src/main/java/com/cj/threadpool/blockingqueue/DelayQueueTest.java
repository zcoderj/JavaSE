package com.cj.threadpool.blockingqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName DelayQueueTest
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/23 023 17:48
 * @Version 1.0
 **/
public class DelayQueueTest {
	public static void main(String[] args) {
		DelayQueue<DelayTask> queue = new DelayQueue<>();
		queue.add(new DelayTask("1", 1000L, TimeUnit.MILLISECONDS));
		queue.add(new DelayTask("2", 2000L, TimeUnit.MILLISECONDS));
		queue.add(new DelayTask("3", 3000L, TimeUnit.MILLISECONDS));
		while (!queue.isEmpty()) {
			try {
				DelayTask task = queue.take();
				System.out.println(task.name + ":" + System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class DelayTask implements Delayed {
	public String name;
	public Long delayTime;
	public TimeUnit delayTimeUnit;
	public Long executeTime;

	public DelayTask(String name, Long delayTime, TimeUnit delayTimeUnit) {
		this.name = name;
		this.delayTime = delayTime;
		this.delayTimeUnit = delayTimeUnit;
		this.executeTime = System.currentTimeMillis() + delayTimeUnit.toMillis(delayTime);
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(executeTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}

	@Override
	public int compareTo(Delayed o) {
		if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
			return 1;
		} else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
			return -1;
		}
		return 0;
	}
}
