package com.cj.designpatterns.iterator;

/**
 * @ClassName Main
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/13 013 20:23
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) {
		ArrayList_<Integer> list = new ArrayList_<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		System.out.println("size:" + list.size());

		Iterator_<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

		System.out.println();

		LinkedList_<Integer> linkedList = new LinkedList_<>();
		for (int i = 0; i < 10; i++) {
			linkedList.add(i);
		}
		System.out.println("size:" + linkedList.size());

		Iterator_<Integer> iterator2 = linkedList.iterator();
		while (iterator2.hasNext()) {
			System.out.print(iterator2.next() + " ");
		}
	}
}
