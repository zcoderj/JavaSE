package com.cj.test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @ClassName ComparableTest
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/18 018 19:39
 * @Version 1.0
 **/
public class ComparableTest {

	public static void main(String[] args) {

		Map<Student, String> map = new TreeMap<>();
		Student s1 = new Student(103, "Make", 80);
		Student s2 = new Student(100, "David", 98);
		Student s3 = new Student(102, "Mary", 100);
		Student s4 = new Student(102, "Jack", 99);
		map.put(s1, "Make...");
		map.put(s2, "David...");
		map.put(s3, "Mary...");
		map.put(s4, "Jack...");

		Set<Student> students = map.keySet();
		for (Student student : students) {
			System.out.println(student);
		}

	}
}

class Student implements Comparable<Student> {

	private int id;
	private String name;
	private int score;

	public Student(int id, String name, int score) {
		this.id = id;
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", score=" + score +
				'}';
	}

	@Override
	public int compareTo(Student o) {
		if (this.id > o.id) {
			return -1;
		} else if (this.id < o.id) {
			return 1;
		} else {
			if (this.score > o.score) {
				return 1;
			} else if (this.score < o.score) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
