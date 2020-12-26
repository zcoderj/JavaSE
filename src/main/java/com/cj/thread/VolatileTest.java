package com.cj.thread;

/**
 * @ClassName VolatileTest
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/22 022 13:30
 * @Version 1.0
 **/
public class VolatileTest {
//	private static int a = 0;
	private volatile static int a = 0;
	public static void main(String[] args) {

		new Thread(() -> {
			// 忙于死循环中，没有更新a，所以当a改变之后（主存），此处a仍然为0（工作区）
			// 当a变量加了volatile关键字之后，若a的值发生改变，
			// 将会立即写会主存，通知工作区对a的值进行更新
			// 则此处也就退出了循环
			while (a == 0) {

			}
		}).start();

		// 2秒后改变a的值
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = 1;
	}
}
