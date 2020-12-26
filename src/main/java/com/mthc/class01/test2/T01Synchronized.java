package com.mthc.class01.test2;

/**
 * @ClassName T01Synchronized
 * @Description TODO 对某个对象加锁，对对象加锁而不是对代码加锁
 * @Author CJ
 * @Date 2020/11/17 017 20:06
 * @Version 1.0
 **/
public class T01Synchronized {

	private static int count = 1;
	private Object object = new Object();

	public void m1() {
		synchronized (object) { // 任何线程要执行下面代码，必须先拿到 object 的锁
			System.out.println(Thread.currentThread().getName() + " count = " + count++);
		}
	}

	// 锁的是当前对象，相当于 m3()
	public void m2() {
		synchronized (this) { // 任何线程要执行下面代码，必须先拿到 this 的锁
			System.out.println(Thread.currentThread().getName() + " count = " + count++);
		}
	}

	public synchronized void m3() {// 等同于 synchronized (this)
		System.out.println(Thread.currentThread().getName() + " count = " + count++);
	}

	// 静态方法加synchronized，锁的是class对象，相当于 m5()
	public synchronized static void m4() {// 等同于 synchronized (T01Synchronized.class)
		System.out.println(Thread.currentThread().getName() + " count = " + count++);
	}

	public static void m5() {
		synchronized (T01Synchronized.class) {
			System.out.println(Thread.currentThread().getName() + " count = " + count++);
		}
	}

}
