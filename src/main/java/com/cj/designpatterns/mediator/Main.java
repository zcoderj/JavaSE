package com.cj.designpatterns.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Main
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/18 018 20:11
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) {
		Mediator mediator = new President();
		Department development = new Development(mediator);
		Department finance = new Finance(mediator);

		mediator.register("development", development);
		mediator.register("finance", finance);

		development.selfAction();
		development.outAction("finance");
	}
}

interface Department {
	void selfAction();
	void outAction(String departmentName);
}

class Development implements Department {

	private Mediator mediator;

	public Development(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void selfAction() {
		System.out.println("develop...");
	}

	@Override
	public void outAction(String departmentName) {
		System.out.println("to apply for funds...");
		mediator.command(departmentName);
	}
}

class Finance implements Department {

	private Mediator mediator;

	public Finance(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void selfAction() {
		System.out.println("funding others...");
	}

	@Override
	public void outAction(String departmentName) {
		System.out.println("reporting...");
	}
}

interface Mediator {
	void register(String departmentName, Department department);
	void command(String departmentName);
}

class President implements Mediator {

	private Map<String, Department> map = new HashMap<>();

	@Override
	public void register(String departmentName, Department department) {
		map.put(departmentName, department);
		System.out.println("register..." + departmentName);
	}

	@Override
	public void command(String departmentName) {
		map.get(departmentName).selfAction();
	}
}
