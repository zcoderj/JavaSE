package com.cj.methodreference;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ClassName ConstructionMethodRef
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/25 025 12:51
 * @Version 1.0
 **/
public class ConstructionMethodRef {
	public static void main(String[] args) {
		Supplier<Person> s1 = Person::new;
		System.out.println(s1.get());

		Consumer<String> c1 = Person::new;
		c1.accept("zs");

		Function<String, Person> f1 = Person::new;
		System.out.println(f1.apply("zs"));
	}
}

class Person {
	private String name;

	public Person() {
		System.out.println("无参构造");
	}

	public Person(String name) {
		this.name = name;
		System.out.println("有参构造");
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				'}';
	}
}
