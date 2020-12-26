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
 * Double Check Lock
 **/
public class Singleton06 {
	// 必须加上volatile，
	// 原因：new一个对象可简单分为三步，这就存在多个指令，
	// 而cpu在执行指令时，可能存在着指令重排的现象
	// 那就可能获取到一个还没真正初始化完成的对象
	// 而volatile修饰的内存，则不会存在指令重排现象。
	private static volatile Singleton06 INSTANCE;

	private Singleton06() {}

	public static Singleton06 getInstance() {
		// 双重检查锁
		if (INSTANCE == null) {
			synchronized (Singleton06.class) {
				if (INSTANCE == null) {
					// 造成延迟
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					INSTANCE = new Singleton06();
				}
			}
		}
		return INSTANCE;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			new Thread(() -> System.out.println(Singleton06.getInstance().hashCode())).start();
		}
	}
}
