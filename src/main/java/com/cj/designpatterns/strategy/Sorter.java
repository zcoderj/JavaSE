package com.cj.designpatterns.strategy;

/**
 * @ClassName Sorter
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/8 008 09:43
 * @Version 1.0
 **/
public class Sorter<T> {

	public void sort(T[] arr, Comparator<T> comparator) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minPos = i;
			for (int j = i + 1; j < arr.length; j++) {
				minPos = comparator.compare(arr[j], arr[minPos]) < 0 ? j : minPos;
			}
			swap(arr, i, minPos);
		}
	}

	private void swap(T[] arr, int i, int minPos) {
		T temp = arr[i];
		arr[i] = arr[minPos];
		arr[minPos] = temp;
	}
}
