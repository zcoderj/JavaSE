package com.mthc.class02;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName T04VolatileNotSync
 * @Description TODO volatile并不能保证多个线程共同修改一个变量是所带来的不一致问题，
 *                   也就是说volatile并不能代替synchronized
 *                   synchronized可以保证可见性和原子性，而voaltile只能保证可见性
 * @Author CJ
 * @Date 2020/11/21 021 09:07
 * @Version 1.0
 **/
public class T04VolatileNotSync {

	/*volatile*/ int count = 0;
	synchronized void m() {
		for (int i = 0; i < 1000; i++) {
			count++;
		}
	}

	public static void main(String[] args) {
		T04VolatileNotSync t = new T04VolatileNotSync();
		List<Thread> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new Thread(t::m, "thread-" + i));
		}

		list.forEach(thread -> thread.start());

		list.forEach(thread -> {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		System.out.println(t.count);
	}

}
