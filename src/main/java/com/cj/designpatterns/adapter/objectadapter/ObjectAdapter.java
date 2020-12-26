package com.cj.designpatterns.adapter.objectadapter;

/**
 * @ClassName ObjectAdapter
 * @Description TODO 对象适配器模式（组合方式）
 * @Author CJ
 * @Date 2020/9/17 017 20:39
 * @Version 1.0
 **/
public class ObjectAdapter {
	public static void main(String[] args) {
		Target target = new Adapter(new Adaptee());
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
class Adapter implements Target {

	private Adaptee adaptee;

	public Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void m() {
		adaptee.method();
		System.out.println("Adapter...");
	}
}
