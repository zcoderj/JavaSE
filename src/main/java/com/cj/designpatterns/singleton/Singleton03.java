package com.cj.designpatterns.singleton;

/**
 * @ClassName Singleton01
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/7 007 09:57
 * @Version 1.0
 *
 * lazy loading
 * 懒汉式
 * 虽然达到了按需初始化的目的，但却带来了线程不安全的问题
 **/
public class Singleton03 {
	private static Singleton03 INSTANCE;

	private Singleton03() {}

	public static Singleton03 getInstance() {
		if (INSTANCE == null) {
			// 造成延迟
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			INSTANCE = new Singleton03();
		}
		return INSTANCE;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			new Thread(() -> System.out.println(Singleton03.getInstance().hashCode())).start();
		}
	}
}
