package com.cj.thread;

/**
 * @ClassName Race
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/21 021 10:26
 * @Version 1.0
 **/
public class Race implements Runnable {

	private String winner = null;

	@Override
	public void run() {
		for (int step = 0; step < 100; step++) {
			if ("rabbit".equals(Thread.currentThread().getName())) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " ==> " + step);
			if (gameOver(step)) {
				break;
			}
		}
	}

	private boolean gameOver(int step) {
		if (winner != null) {
			return true;
		} else {
			if (step == 99) {
				this.winner = Thread.currentThread().getName();
				System.out.println("winner:^" + this.winner + "^");
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Race race = new Race();
		new Thread(race, "tortoise").start();
		new Thread(race, "rabbit").start();
	}
}
