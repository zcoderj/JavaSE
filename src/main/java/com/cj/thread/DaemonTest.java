package com.cj.thread;

/**
 * @ClassName DaemonTest
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/21 021 14:36
 * @Version 1.0
 **/
public class DaemonTest {

	public static void main(String[] args) {
		// daemon 守护进程：是为用户进程而服务，jvm停止不需要等待守护进程执行完毕
		// 进程默认为用户进程，jvm必须等待用户线程执行完毕才会停止

		Thread daemon = new Thread(() -> {
			for (; true; ) {
				System.out.println("daemon...");
			}
		}, "daemon");
		// 设置为守护进程
		daemon.setDaemon(true);
		daemon.start();

		// 默认为用户进程
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("userThread...");
			}
		}).start();
	}
}
