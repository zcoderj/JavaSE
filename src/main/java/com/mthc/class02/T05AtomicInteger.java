package com.mthc.class02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName T05AtomicInteger
 * @Description TODO 解决同样的问题的更高效的方法，使用AtomXXX类 （使用的是CAS【Compare and Set/Swap】保证线程安全）
 *                   AtomXXX类本身方法都是原子性的，但不能保证多个方法连续调用是原子性的
 * @Author CJ
 * @Date 2020/11/21 021 09:33
 * @Version 1.0
 **/
public class T05AtomicInteger {
	/*volatile*/ //int count1 = 0;

	AtomicInteger count = new AtomicInteger(0);

	/*synchronized*/ void m() {
		for (int i = 0; i < 10000; i++)
			//if count1.get() < 1000
			count.incrementAndGet(); //count1++
	}

	public static void main(String[] args) {
		T05AtomicInteger t = new T05AtomicInteger();

		List<Thread> threads = new ArrayList<Thread>();

		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(t::m, "thread-" + i));
		}

		threads.forEach((o) -> o.start());

		threads.forEach((o) -> {
			try {
				o.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		System.out.println(t.count);
	}
}
