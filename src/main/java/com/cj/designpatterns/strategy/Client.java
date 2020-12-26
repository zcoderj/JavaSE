package com.cj.designpatterns.strategy;

/**
 * @ClassName Client
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/18 018 23:01
 * @Version 1.0
 **/
public class Client {
	public static void main(String[] args) {
		Strategy strategy = new OldCustomerStrategy();
		Context context = new Context(strategy);
		context.printPrice(100);
	}
}

interface Strategy {
	double getPrice(double originalPrice);
}

class NewCustomerStrategy implements Strategy {

	@Override
	public double getPrice(double originalPrice) {
		System.out.println("no discount...");
		return originalPrice;
	}
}

class OldCustomerStrategy implements Strategy {

	@Override
	public double getPrice(double originalPrice) {
		System.out.println("10-percent discount...");
		return originalPrice * 0.9;
	}
}

class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public void printPrice(double originalPrice) {
		System.out.println(strategy.getPrice(originalPrice));
	}
}
