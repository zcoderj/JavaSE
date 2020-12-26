package com.cj.designpatterns.proxy.staticproxy;

import java.time.Instant;

/**
 * @ClassName StaticProxy
 * @Description TODO 静态代理
 * @Author CJ
 * @Date 2020/9/12 012 10:50
 * @Version 1.0
 **/
public class StaticProxy {
	public static void main(String[] args) {
		new TankLogProxy(new TankTimeProxy(new Tank())).move();
	}
}

// 代理角色
class TankLogProxy implements Movable {

	Movable movable;

	public TankLogProxy(Movable movable) {
		this.movable = movable;
	}

	@Override
	public void move() {
		System.out.println("start...");
		movable.move();
		System.out.println("end...");
	}
}

// 代理角色
class TankTimeProxy implements Movable {

	Movable movable;

	public TankTimeProxy(Movable movable) {
		this.movable = movable;
	}

	@Override
	public void move() {
		long start = Instant.now().toEpochMilli();
		movable.move();
		long end = Instant.now().toEpochMilli();
		System.out.println(end - start);
	}
}

// 真实角色
class Tank implements Movable {

	@Override
	public void move() {
		System.out.println("tank moving...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

// 代理角色
interface Movable {
	void move();
}
