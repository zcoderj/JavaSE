package com.cj.thread;

/**
 * @ClassName Web12306
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/22 022 09:41
 * @Version 1.0
 **/
public class Web12306Test {

	public static void main(String[] args) {
		Web1236 web1236 = new Web1236(5, "12306");
		new Passenger(web1236, "Make", 2).start();
		new Passenger(web1236, "Jack", 2).start();
	}
}

class Passenger extends Thread {
	private int seats;

	public Passenger(Runnable target, String name, int seats) {
		super(target, name);
		this.seats = seats;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
}

class Web1236 implements Runnable {
	private int available;
	private String name;

	public Web1236(int available, String name) {
		this.available = available;
		this.name = name;
	}

	@Override
	public void run() {
		Passenger passenger = (Passenger) Thread.currentThread();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean flag = bookTicket(passenger.getSeats());
		if (flag) {
			System.out.println("预订成功 " + Thread.currentThread().getName() + "==>位置个数为" + passenger.getSeats());
		} else {
			System.out.println("预订失败 " + Thread.currentThread().getName() + "==>位置不够");
		}
	}

	private synchronized boolean bookTicket(int seats) {

		System.out.println("欢迎光临" + name +"，可用位置为：" + available);
		if (available < seats) {
			return false;
		} else {
			available -= seats;
			return true;
		}
	}
}
