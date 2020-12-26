package com.cj.designpatterns.prototype.deepclone;

/**
 * @ClassName DeepClone
 * @Description TODO 深拷贝（通过clone方式）
 * @Author CJ
 * @Date 2020/9/15 015 18:50
 * @Version 1.0
 **/
public class DeepClone {
	public static void main(String[] args) throws Exception {
		Person p1 = new Person();
		Person p2 = (Person) p1.clone();
		System.out.println(p1);
		System.out.println(p2);

		System.out.println(p1.location == p2.location);
		p2.location.street = "sz";
		System.out.println(p2);
		System.out.println(p1.location);
	}
}

class Person implements Cloneable {
	int age = 8;
	String name = "cj";
	Location location = new Location();

	@Override
	public Object clone() throws CloneNotSupportedException {
		Person p = (Person) super.clone();
		p.location = (Location) location.clone();
		return p;
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

class Location implements Cloneable {
	String street = "gd";
	int roomNo = 101;

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Location{" +
				"street='" + street + '\'' +
				", roomNo=" + roomNo +
				'}';
	}
}
