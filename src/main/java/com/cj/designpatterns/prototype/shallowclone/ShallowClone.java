package com.cj.designpatterns.prototype.shallowclone;

/**
 * @ClassName ShallowClone
 * @Description TODO 浅拷贝，只拷贝了非引用类型
 * @Author CJ
 * @Date 2020/9/15 015 17:58
 * @Version 1.0
 **/
public class ShallowClone {
	public static void main(String[] args) throws Exception {
		Person p1 = new Person();
		Person p2 = (Person) p1.clone();
		System.out.println(p1);
		System.out.println(p2);

		System.out.println(p1.location == p2.location);
		p2.location.street = "sz";
		System.out.println(p1.location);
	}
}

class Person implements Cloneable {
	int age = 8;
	String name = "cj";
	Location location = new Location();

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Person{" +
				"age=" + age +
				", name='" + name + '\'' +
				", location=" + location +
				'}';
	}
}

class Location {
	String street = "gd";
	int roomNo = 101;

	@Override
	public String toString() {
		return "Location{" +
				"street='" + street + '\'' +
				", roomNo=" + roomNo +
				'}';
	}
}
