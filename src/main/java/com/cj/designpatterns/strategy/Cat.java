package com.cj.designpatterns.strategy;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/8 008 09:50
 * @Version 1.0
 **/
public class Cat {

	public int height;
	public int weight;

	public Cat(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Cat{" +
				"height=" + height +
				", weight=" + weight +
				'}';
	}
}
