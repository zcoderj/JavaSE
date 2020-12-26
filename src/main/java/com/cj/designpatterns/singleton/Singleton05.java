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
 * 可以通过synchronized解决，但也造成效率下降
 **/
public class Singleton05 {
	private static Singleton05 INSTANCE;

	private Singleton05() {}

	public static Singleton05 getInstance() {
		if (INSTANCE == null) {
			// 试图通过减小同步代码块的方式提高效率，
			// 但是这样却又造成了线程不安全
			synchronized (Singleton05.class) {
				// 造成延迟
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				INSTANCE = new Singleton05();
			}
		}
		return INSTANCE;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			new Thread(() -> System.out.println(Singleton05.getInstance().hashCode())).start();
		}
	}
}
