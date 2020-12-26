package com.cj.thread;

/**
 * @ClassName LambdaTest
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/21 021 11:36
 * @Version 1.0
 **/
public class LambdaTest01 {

	public static void main(String[] args) {

//		One one = () -> {
//			System.out.println("one....");
//		};
//		one.test();

		// 只有一个参数，括号可省略
//		Two two = a -> {
//			System.out.println("two..." + a);
//		};
//		two.test(6);

		// 只有一句代码，花括号可省略，
		// 如果是该语句是return语句，return关键字可省略
//		Three three = (a, b) -> a + b;
//		System.out.println(three.test(6, 6));

//		Three three = (a, b) -> {
//			int c = a + b;
//			return c;
//		};
//		System.out.println(three.test(7, 7));
	}
}

interface One {
	// 无参无返回值
	void test();
}

interface Two {
	// 有一个参数
	void test(int a);
}

interface Three {
	// 多个参数有返回值
	int test(int a, int b);
}