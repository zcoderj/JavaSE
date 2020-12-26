package com.cj.designpatterns.builder;

/**
 * @ClassName Main
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/13 013 21:29
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) {
		Person person = new Person.PersonBuilder()
				.basicInfo(1, "cj", 18)
				.score(100)
				.weight(140)
				.location("xx", "101")
				.build();
		System.out.println(person);

		ComputerBuilder computerBuilder = new HuaweiComputerBuilder();
		Computer computer = computerBuilder.buildCpu().buildBoard().buildMemory().build();
		System.out.println(computer);


	}
}
