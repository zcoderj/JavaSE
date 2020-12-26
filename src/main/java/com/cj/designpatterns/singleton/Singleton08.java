package com.cj.designpatterns.singleton;

/**
 * 不仅可以解决线程同步，还可以防止反序列化
 * java可以通过反射得到实例，所以，之前的单例方式，原则上都不是绝对安全
 * 而枚举单例则不会被反序列化 ==> 枚举没有构造方法
 * 所以枚举单例即使通过反序列化，得到的实例也是与单例创建的实例是同一个
 */
public enum Singleton08 {

	INSTANCE;

	private int i = 0;

	public void method() {
		System.out.println("zcoderj");
		System.out.println(i++);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			new Thread(() -> System.out.println(Singleton08.INSTANCE.hashCode())).start();
		}
		Singleton08.INSTANCE.method();

	}
}
