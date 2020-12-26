package com.cj.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Cinema
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/22 022 08:23
 * @Version 1.0
 **/
public class CinemaTest {
	public static void main(String[] args) {
		List<Integer> available = new ArrayList<>();
		available.add(1);
		available.add(2);
		available.add(3);
		available.add(4);
		available.add(5);
		Cinema cinema = new Cinema("CJ Cinema", available);
		List<Integer> seats1 = new ArrayList<>();
		seats1.add(1);
		seats1.add(2);
		List<Integer> seats2 = new ArrayList<>();
		seats2.add(6);
		seats2.add(3);
		seats2.add(4);
		new Thread(new Customer(cinema, seats1),"Make").start();
		new Thread(new Customer(cinema, seats2),"Jack").start();
	}
}

class Cinema {
	String name;
	List<Integer> available;

	public Cinema(String name, List<Integer> available) {
		this.name = name;
		this.available = available;
	}

	public boolean bookTicket(List<Integer> seats) {

		System.out.println("欢迎光临"+ name +"，当前可用位置为：" + available);
		List<Integer> copy = new ArrayList<>();
		copy.addAll(available);
		copy.removeAll(seats);
		if (available.size() - copy.size() != seats.size()) {
			return false;
		} else {
			this.available = copy;
			return true;
		}
	}
}

class Customer implements Runnable {

	private Cinema cinema;
	private List<Integer> seats;

	public Customer(Cinema cinema, List<Integer> seats) {
		this.cinema = cinema;
		this.seats = seats;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (cinema) {

			boolean flag = cinema.bookTicket(seats);
			if (flag) {
				System.out.println("预订成功" + Thread.currentThread().getName() + "==>位置为" + seats);
			} else {
				System.out.println("预订失败" + Thread.currentThread().getName() + "==>位置不够");
			}
		}
	}
}

