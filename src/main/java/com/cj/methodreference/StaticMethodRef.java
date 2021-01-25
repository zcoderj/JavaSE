package com.cj.methodreference;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ClassName StaticMethodRef
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/25 025 11:58
 * @Version 1.0
 **/
public class StaticMethodRef {
	public static void main(String[] args) {
		// 静态方法引用
		// 一个输出
//		Supplier<String> s1 = () -> StaticMethodRef.staticMethodRef();
//		System.out.println(s1.get());
//
//		Supplier<String> s2 = StaticMethodRef::staticMethodRef;
//		System.out.println(s2.get());
		// 一个输入
//		Consumer<String> c1 = (str) -> StaticMethodRef.staticMethodRef2(str);
//		c1.accept("staticMethodRef2");

		// 一个输入，一个输出，输入输出类型一般不同
//		Function<String, Integer> f1 = StaticMethodRef::getLength;
//		System.out.println(f1.apply("hello"));、

		// 两个输入，一个输出，输入输出类型一般不同
		BiFunction<String, String, Integer> f2 = StaticMethodRef::getLength;
		System.out.println(f2.apply("hello", "Lambda"));
	}


	private static String staticMethodRef() {
		return "staticMethodRef";
	}

	private static void staticMethodRef2(String str) {
		System.out.println(str);
	}

	private static Integer getLength(String str) {
		return str.length();
	}

	private static Integer getLength(String s1, String s2) {
		return s1.length() + s2.length();
	}
}
