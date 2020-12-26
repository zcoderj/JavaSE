package com.cj.designpatterns.prototype.deepclone2;

import java.io.*;

/**
 * @ClassName DeepClone2
 * @Description TODO 深拷贝（通过反序列化方式）
 * @Author CJ
 * @Date 2020/9/15 015 17:58
 * @Version 1.0
 **/
public class DeepClone2 {
	public static void main(String[] args) throws Exception {
		Person p1 = new Person();
		System.out.println(p1);

		// 序列化
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(p1);
		byte[] bytes = baos.toByteArray();

		// 反序列化达到克隆对象的目的
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Person p2 = (Person) ois.readObject();
		System.out.println(p2);

		System.out.println(p1.location == p2.location);
		p2.location.street = "sz";
		System.out.println(p1.location);
	}
}

class Person implements Serializable {
	int age = 8;
	String name = "cj";
	Location location = new Location();

	@Override
	public String toString() {
		return "Person{" +
				"age=" + age +
				", name='" + name + '\'' +
				", location=" + location +
				'}';
	}
}

class Location implements Serializable {
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
