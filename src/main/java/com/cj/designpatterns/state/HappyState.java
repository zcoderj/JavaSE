package com.cj.designpatterns.state;

/**
 * @ClassName HappyState
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/15 015 22:07
 * @Version 1.0
 **/
public class HappyState extends State {
	@Override
	void smile() {
		System.out.println("happy smile...");
	}

	@Override
	void cry() {
		System.out.println("happy to cry...");
	}
}
