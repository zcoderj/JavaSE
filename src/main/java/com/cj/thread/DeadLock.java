package com.cj.thread;

/**
 * @ClassName DeadLock
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/22 022 10:38
 * @Version 1.0
 **/
public class DeadLock {

	public static void main(String[] args) {
		Markup g1 = new Markup(1, "Make");
		Markup g2 = new Markup(0, "Jack");
		g1.start();
		g2.start();
	}

}

//口红
class Lipstick {

}

//镜子
class Mirror {

}

//化妆
class Markup extends Thread {
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror = new Mirror();
	//选择
	int choice;
	//名字
	String girl;

	public Markup(int choice, String girl) {
		this.choice = choice;
		this.girl = girl;
	}

	@Override
	public void run() {
		//化妆
		markup();
	}

	//相互持有对方的对象锁-->可能造成死锁
	private void markup() {
		if (choice == 0) {
			synchronized (lipstick) { //获得口红的锁
				System.out.println(this.girl + "涂口红");
				//1秒后想拥有镜子的锁
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//死锁
				/*synchronized(mirror) {
					System.out.println(this.girl+"照镜子");
				}*/
			}
			synchronized (mirror) {
				System.out.println(this.girl + "照镜子");
			}
		} else {
			synchronized (mirror) { //获得镜子的锁
				System.out.println(this.girl + "照镜子");
				//2秒后想拥有口红的锁
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 死锁
				/*synchronized(lipstick) {
					System.out.println(this.girl+"涂口红");
				}*/

			}
			synchronized (lipstick) {
				System.out.println(this.girl + "涂口红");
			}
		}
	}
}

