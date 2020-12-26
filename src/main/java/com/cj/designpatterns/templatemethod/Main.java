package com.cj.designpatterns.templatemethod;

/**
 * @ClassName Main
 * @Description TODO 模板方法 ==> 钩子函数
 * @Author CJ
 * @Date 2020/9/15 015 21:59
 * @Version 1.0
 **/
public class Main {

	public static void main(String[] args) {
		F f = new F1();
		f.method();
	}
}

abstract class F {
	public void method() {
		op1();
		op2();
	}

	abstract void op1();
	abstract void op2();
}

class F1 extends F {

	@Override
	void op1() {
		System.out.println("op1...");
	}

	@Override
	void op2() {
		System.out.println("op2...");
	}
}