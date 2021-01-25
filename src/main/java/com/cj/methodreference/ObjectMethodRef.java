package com.cj.methodreference;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @ClassName ObjectMethodRef
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/25 025 12:35
 * @Version 1.0
 **/
public class ObjectMethodRef {
	public static void main(String[] args) {
		// 对象方法引用
		Consumer<Type1> c1 = Type1::get;
		Type1 type1 = new Type1();
		type1.name = "zs";
		c1.accept(type1);

		Function<Type1, String> f2 = Type1::getName;
		System.out.println(f2.apply(type1));
	}


}

class Type1 {
	public String name;

	public void get() {
		System.out.println(name);
	}

	public String getName() {
		return name;
	}
}
