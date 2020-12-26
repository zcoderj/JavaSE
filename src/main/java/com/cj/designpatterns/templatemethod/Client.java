package com.cj.designpatterns.templatemethod;

/**
 * @ClassName Client
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/18 018 23:21
 * @Version 1.0
 **/
public class Client {
	public static void main(String[] args) {
		Dinner dinner = new CustomerOne();
		dinner.havingDinner();
	}
}

abstract class Dinner {
	protected abstract void order();

	protected void eat() {
		System.out.println("eating...");
	}

	protected void checkOut() {
		System.out.println("check out...");
	}

	// 模板方法
	public final void havingDinner() {
		// 回调
		order();

		eat();

		checkOut();
	}
}

class CustomerOne extends Dinner {

	@Override
	public void order() {
		System.out.println("customerOne order...");
	}
}
