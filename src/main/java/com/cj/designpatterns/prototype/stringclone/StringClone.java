package com.cj.designpatterns.prototype.stringclone;

/**
 * @ClassName StringClone
 * @Description TODO
 * 直接赋值的String类型不需要深拷贝，
 * 而通过new创建String对象的方式，拷贝后虽然指向的是同一个对象，
 * 但是由于String是不可变字符序列，所以当两者中有一个改变时，并不会影响另一个的内容，此时两者的指向已不同。
 * 通过StringBuilder得到的String，由于StringBuilder是可变的字符序列，
 * 所以需要进行深拷贝，否则在有一方改变的时候，另一方也可能发生改变，如调用StringBuilder的reverse()方法
 *
 * @Author CJ
 * @Date 2020/9/15 015 18:59
 * @Version 1.0
 **/
public class StringClone {
	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1 = new Person();
		Person p2 = (Person) p1.clone();
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.location.street == p2.location.street);

		p1.location.street.reverse();
		System.out.println(p1);
		System.out.println(p2);
	}
}

class Person implements Cloneable {
	int age = 18;
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
	StringBuilder street = new StringBuilder("gz");
	int roomNo = 101;

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Location{" +
				"street='" + street.toString() + '\'' +
				", roomNo=" + roomNo +
				'}';
	}
}
