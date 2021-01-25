package com.cj.designpatterns.facade;

/**
 * @ClassName Main
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/18 018 11:44
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) {
		new Facade().method();
	}
}

class Facade {
	public void method() {
		new SubSystemOne().m();
		new SubSystemTwo().m();
	}
}

class SubSystemOne {
	public void m() {
		System.out.println("SubSystemOne...");
	}
}

class SubSystemTwo {
	public void m() {
		System.out.println("SubSystemTwo...");
	}
}