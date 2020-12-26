package com.cj.thread;

/**
 * @ClassName ThreadLambda
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/21 021 11:58
 * @Version 1.0
 **/
public class ThreadLambda {

	public static void main(String[] args) {

		// 匿名内部类
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(i);
				}
			}
		}).start();

		// lambda表达式
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		}).start();
	}
}
