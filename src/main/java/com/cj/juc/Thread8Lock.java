package com.cj.juc;

/**
 * @ClassName Thread8Lock
 * @Description TODO 线程八锁
 * @Author CJ
 * @Date 2020/8/31 031 09:58
 * @Version 1.0
 *
 * 1.两个普通同步方法，两个线程 ==one two
 * 2.getOne()加上Thread.sleep() ==one two
 * 3.新增普通方法getThree() ==three one two
 * 4.两个普通同步方法，两个Number对象 ==two one
 * 5.修改getOne()为静态同步方法 ==two one
 * 6.修改两个方法都为静态同步方法 ==one two
 * 7.一个静态同步方法，一个非静态同步方法，两个Number对象 ==two one
 * 8.两个静态同步方法，两个Number对象
 *
 * 结论（线程八锁的关键）：
 * 1.非静态方法的锁默认为 this，静态方法的锁为对象的Class实例
 * 2.某一个时刻内，只能有一个线程持有锁，无论几个方法
 **/
public class Thread8Lock {

	public static void main(String[] args) {
		Number number = new Number();
		Number number2 = new Number();

		new Thread(new Runnable() {
			@Override
			public void run() {
				number.getOne();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				number2.getTwo();
			}
		}).start();

//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				number.getThree();
//			}
//		}).start();
	}
}

class Number {

	public static synchronized void getOne() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("one");
	}

	public static synchronized void getTwo() {
		System.out.println("two");
	}

	public void getThree() {
		System.out.println("three");
	}
}

