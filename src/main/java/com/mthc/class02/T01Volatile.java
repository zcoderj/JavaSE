package com.mthc.class02;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T01Volatile
 * @Description TODO volatile关键字，使一个变量在多个线程间可见
 *                   例如，A B线程都用到了一个变量，java默认是在线程中保留一份该变量的copy，这样若另外一个线程改变了该变量，则A线程未必知道
 *                   而使用volatile关键字，会让所有线程都读到该变量的修改值
 *
 *                   在以下代码中，running是存在于堆内存的t对象中
 *                   当线程t1开始运行时，会把running值从内存中读取到t1线程的工作区，在运行过程中直接使用这个copy，
 *                   并不会每次都去读取堆内存，这样，当主线程修改running的值后，t1线程感知不到，也就不会停止运行
 *                   使用volatile，将会强制所有线程都去堆内存中读取running的值
 *
 *                   另外，volatile并不能保证多个线程共同修改running变量是所带来的不一致问题，
 *                   也就是说volatile并不能代替synchronized
 * @Author CJ
 * @Date 2020/11/21 021 08:25
 * @Version 1.0
 **/
public class T01Volatile {

	// 有无volatile，此程序的运行结果将大不相同
	/*volatile*/ boolean running = true;

	public void m() {
		System.out.println("m start...");
		while (running) {
		}
		System.out.println("m end...");
	}

	public static void main(String[] args) {
		T01Volatile t = new T01Volatile();
		new Thread(t::m, "t1").start();

		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t.running = false;
	}
}
