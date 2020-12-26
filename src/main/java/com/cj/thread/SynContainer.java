package com.cj.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName SynContainer
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/22 022 10:09
 * @Version 1.0
 **/
public class SynContainer {

	public static void main(String[] args) {

//		test1();
//		test2();
		test3();
	}

	// 未使用同步块
	private static void test1() {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			new Thread(() -> list.add(Thread.currentThread().getName())).start();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list.size()); // size < 10000
	}

	// 使用同步块
	private static void test2() {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			new Thread(() -> {
				synchronized (list) {
					list.add(Thread.currentThread().getName());
				}
			}).start();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list.size()); //size = 10000
	}

	// 使用并发容器
	private static void test3() {
		List<String> list = new CopyOnWriteArrayList<>();
		for (int i = 0; i < 10000; i++) {
			new Thread(() -> list.add(Thread.currentThread().getName())).start();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list.size()); // size = 10000
	}
}
