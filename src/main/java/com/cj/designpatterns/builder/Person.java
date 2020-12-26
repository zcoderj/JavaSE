package com.cj.designpatterns.builder;


/**
 * @ClassName Person
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/13 013 21:23
 * @Version 1.0
 **/
public class Person {
	int id;
	String name;
	int age;
	double weight;
	int score;
	Location location;
	// ...

	// 直接构建此对象可能过于复杂

	private Person() {}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", weight=" + weight +
				", score=" + score +
				", location=" + location +
				'}';
	}

	public static class PersonBuilder {
		private Person person = new Person();

		public PersonBuilder basicInfo(int id, String name, int age) {
			person.id = id;
			person.name = name;
			person.age = age;
			return this;
		}

		public PersonBuilder weight(double weight) {
			person.weight = weight;
			return this;
		}

		public PersonBuilder score(int score) {
			person.score = score;
			return this;
		}

		public PersonBuilder location(String street, String roomNo) {
			person.location = new Location(street, roomNo);
			return this;
		}

		public Person build() {
			return person;
		}
	}
}

class Location {
	String street;
	String roomNo;

	public Location(String street, String roomNo) {
		this.street = street;
		this.roomNo = roomNo;
	}

	@Override
	public String toString() {
		return "Location{" +
				"street='" + street + '\'' +
				", roomNo='" + roomNo + '\'' +
				'}';
	}
}
