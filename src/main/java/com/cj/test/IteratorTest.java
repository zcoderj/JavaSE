package com.cj.test;

import java.util.*;

/**
 * @ClassName IteratorTest
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/18 018 20:45
 * @Version 1.0
 **/
public class IteratorTest {

	public static void main(String[] args) {
//		listIterator1();

		listIterator2();

//		mapIterator1();
//
//		mapIterator2();
	}

	public static void listIterator1() {

		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("c");
		list.add("b");
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}

	}

	// ListIterator 可反向遍历list，并且可更改值
	public static void listIterator2() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		for (ListIterator<String> iterator = list.listIterator(list.size()); iterator.hasPrevious();) {
			System.out.println(iterator.previous() + "==" + iterator.previousIndex());
			if (iterator.previousIndex() + 1 == 2) {
				iterator.set("d");
			}
		}
		System.out.println("===========");
		for (ListIterator<String> iterator = list.listIterator(list.size()); iterator.hasPrevious();) {
			System.out.println(iterator.previous());
		}
	}

	public static void mapIterator1() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");

		Set<Map.Entry<Integer, String>> entries = map.entrySet();
		for (Map.Entry<Integer, String> entry : entries) {
			System.out.println(entry.getKey() + "---" + entry.getValue());
		}
	}

	public static void mapIterator2() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");

		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			System.out.println(key + "===" + map.get(key));
		}
	}
}
