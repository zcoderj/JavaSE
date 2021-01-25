package com.cj.methodreference;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ClassName InstanceMethodRef
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/25 025 12:23
 * @Version 1.0
 **/
public class InstanceMethodRef {
	public static void main(String[] args) {
		// 实例方法引用
		Consumer<String> c1 = (str) -> new InstanceMethodRef().set(str);
		c1.accept("hello");

		Consumer<String> c2 = new InstanceMethodRef()::set;
		c2.accept("hello");

		InstanceMethodRef instance = new InstanceMethodRef();

		Consumer<String> c3 = instance::set;
		c3.accept("hello");

		Supplier<String> f1 = instance::get;
		f1.get();
	}

	private void set(String str) {
		System.out.println(str);
	}

	private String get() {
		return "hello";
	}
}
