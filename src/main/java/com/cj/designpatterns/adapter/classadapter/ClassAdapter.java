package com.cj.designpatterns.adapter.classadapter;

/**
 * @ClassName ClassAdapter
 * @Description TODO 类适配器模式（继承方式）
 * @Author CJ
 * @Date 2020/9/17 017 20:39
 * @Version 1.0
 **/
public class ClassAdapter {
	public static void main(String[] args) {
		Target target = new Adapter();
		target.m();
	}
}

// 适配者（不可直接使用的接口）
class Adaptee {
	public void method() {
		System.out.println("Adaptee...");
	}
}

// 目标接口
interface Target {
	public void m();
}

// 适配器
class Adapter extends Adaptee implements Target {

	@Override
	public void m() {
		super.method();
		System.out.println("Adapter...");
	}
}
