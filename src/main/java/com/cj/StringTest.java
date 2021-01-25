package com.cj;

/**
 * @ClassName StringTest
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/14 014 19:02
 * @Version 1.0
 **/
public class StringTest {
	public static void main(String[] args) {
		String s1 = "Java ";
		String s2 = "String";
		String s3 = "Java String";
		String s4 = s1 + "String";
		String s5 = s1 + s2;
		String s6 = "Java " + "String";
		System.out.println(s3 == s4); // false
		System.out.println(s3 == s4.intern()); // true
		System.out.println(s3 == s6); // true
		System.out.println(s3 == s5); // false
		System.out.println(s4 == s5); // false

	}
}
