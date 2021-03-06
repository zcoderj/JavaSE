package com.cj.designpatterns.strategy;

/**
 * @ClassName CatWeightComparator
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/8 008 10:06
 * @Version 1.0
 **/
public class CatHeightComparator implements Comparator<Cat> {
	@Override
	public int compare(Cat o1, Cat o2) {
		return o1.height - o2.height;
	}
}
