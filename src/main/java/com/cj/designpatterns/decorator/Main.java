package com.cj.designpatterns.decorator;

/**
 * @ClassName Main
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/17 017 22:25
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) {
		// 陆地
		ICar car1 = new Car();
		car1.move();
		// 陆地，天上
		ICar car2 = new FlyCar(car1);
		car2.move();
		// 陆地，天上，水里
		ICar car3 = new WaterCar(car2);
		car3.move();
	}
}

interface ICar {
	void move();
}

class Car implements ICar {
	@Override
	public void move() {
		System.out.println("Driving on land...");
	}
}

class SuperCar implements ICar {
	private ICar car;

	public SuperCar(ICar car) {
		this.car = car;
	}

	@Override
	public void move() {
		car.move();
	}
}

class FlyCar extends SuperCar {

	public FlyCar(ICar car) {
		super(car);
	}

	public void fly() {
		System.out.println("flying in the sky...");
	}

	@Override
	public void move() {
		super.move();
		fly();
	}
}

class WaterCar extends SuperCar {

	public WaterCar(ICar car) {
		super(car);
	}

	public void water() {
		System.out.println("Driving in the water...");
	}

	@Override
	public void move() {
		super.move();
		water();
	}
}
