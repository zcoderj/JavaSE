package com.cj.designpatterns.strategy;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/8 008 09:52
 * @Version 1.0
 **/
public class Dog {

	public int height;

	public Dog(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Dog{" +
				"height=" + height +
				'}';
	}
}
