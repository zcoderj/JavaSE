package com.cj.designpatterns.flyweight;

/**
 * @ClassName Main
 * @Description TODO java的String利用的就是享元模式（常量池）
 * @Author CJ
 * @Date 2020/9/11 011 14:10
 * @Version 1.0
 **/
public class Main {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = new String("abc");

		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		System.out.println(s3 == s4);
		System.out.println(s2 == s3.intern());
		System.out.println(s3.intern() == s4.intern());
	}
}
