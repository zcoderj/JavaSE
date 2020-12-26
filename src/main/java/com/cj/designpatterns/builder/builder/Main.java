package com.cj.designpatterns.builder.builder;

/**
 * @ClassName Main
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/16 016 15:42
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) {
		HuaweiDirector director = new HuaweiDirector(new HuaweiComputerBuilder());
		Computer computer = director.builder();
		System.out.println(computer);
	}
}
