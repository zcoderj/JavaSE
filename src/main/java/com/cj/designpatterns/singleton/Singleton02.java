package com.cj.designpatterns.singleton;

/**
 * @ClassName Singleton01
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/7 007 09:57
 * @Version 1.0
 *
 * 与Singleton01一个意思
 * 使用静态语句块初始化
 **/
public class Singleton02 {
	private static final Singleton02 INSTANCE;

	static {
		INSTANCE = new Singleton02();
	}

	private Singleton02() {}

	public static Singleton02 getInstance() {
		return INSTANCE;
	}

	public static void main(String[] args) {
		Singleton02 s1 = Singleton02.getInstance();
		Singleton02 s2 = Singleton02.getInstance();
		System.out.println(s1 == s2);
	}
}
