package com.cj.designpatterns.state;

/**
 * @ClassName Main
 * @Description TODO 状态模式，根据状态决定动作
 * @Author CJ
 * @Date 2020/9/15 015 22:10
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) {
		Girl girl = new Girl(new HappyState());
//		Girl girl = new Girl(new SadState());
		girl.smile();
		girl.cry();
	}
}
