package com.cj.designpatterns.iterator;

/**
 * @ClassName ArrayList_
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/13 013 20:15
 * @Version 1.0
 **/
public class ArrayList_<E> implements Collection_<E> {

	private E[] elements = (E[]) new Object[10];
	private int size;

	@Override
	public void add(E e) {
		if (size == elements.length) {
			E[] newElements = (E[]) new Object[elements.length * 2];
			System.arraycopy(elements, 0, newElements, 0, size);
			elements = newElements;
		}
		elements[size++] = e;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator_<E> iterator() {
		return new ArrayListIterator_<>();
	}

	private class ArrayListIterator_<E> implements Iterator_<E> {

		private int currentIndex = 0;

		@Override
		public boolean hasNext() {
			return currentIndex < size;
		}

		@Override
		public E next() {
			return (E) elements[currentIndex++];
		}
	}
}
