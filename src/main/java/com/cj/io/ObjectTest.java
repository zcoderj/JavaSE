package com.cj.io;

import java.io.*;

/**
 * @ClassName ObjectTest
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/16 016 23:26
 * @Version 1.0
 **/
public class ObjectTest {
	public static void main(String[] args) throws Exception {
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("now1.txt"));
		outputStream.writeObject(new Person("haha"));
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("now1.txt"));
		Person person = (Person) inputStream.readObject();
		System.out.println(person);
		inputStream.close();
		outputStream.close();
	}
}

class Person implements Serializable{
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public Person() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				'}';
	}
}
