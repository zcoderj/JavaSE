package com.cj.thread;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName TicketWindow
 * @Description TODO
 * @Author CJ
 * @Date 2020/12/16 016 08:53
 * @Version 1.0
 **/
public class TicketWindow extends Thread {

	public static volatile Integer num = 1000;

	public TicketWindow(String name) {
		super(name);
	}

	@Override
	public void run() {
		synchronized(num) {
			while (true) {
				if (num > 0) {
					try {
						TimeUnit.MILLISECONDS.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(getName() + "==>" + num--);
				}
			}
		}
	}

	public static void main(String[] args) {
		TicketWindow w1 = new TicketWindow("W1");
		TicketWindow w2 = new TicketWindow("W2");
		TicketWindow w3 = new TicketWindow("W3");

		w1.start();
		w2.start();
		w3.start();
	}
}
