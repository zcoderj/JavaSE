package com.cj.designpatterns.strategy;

/**
 * @ClassName DogComparator
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/8 008 09:53
 * @Version 1.0
 **/
public class DogComparator implements Comparator<Dog> {
	@Override
	public int compare(Dog o1, Dog o2) {
		return o1.height - o2.height;
	}
}
