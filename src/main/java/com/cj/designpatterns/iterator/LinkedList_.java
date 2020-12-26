package com.cj.designpatterns.iterator;


/**
 * @ClassName LinkedList_
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/13 013 20:29
 * @Version 1.0
 **/
public class LinkedList_<E> implements Collection_<E> {

	private Node head;
	private Node tail;
	private int size = 0;

	@Override
	public void add(E e) {
		Node node = new Node(e);
		if (head == null) {
			head = node;
			tail = node;
		}
		tail.next = node;
		tail = node;
		size++;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator_<E> iterator() {
		return new LinkedListIterator_<>();
	}

	private class Node {
		Object data;
		Node next;

		public Node(Object data) {
			this.data = data;
		}
	}

	private class LinkedListIterator_<E> implements Iterator_<E> {

		private int currentIndex = 0;
		private Node node = head;

		@Override
		public boolean hasNext() {
			return currentIndex < size;
		}

		@Override
		public E next() {
			E data = (E) node.data;
			node = node.next;
			currentIndex++;
			return data;
		}
	}
}
