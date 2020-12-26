package com.cj.designpatterns.state;

/**
 * @ClassName Girl
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/15 015 22:09
 * @Version 1.0
 **/
public class Girl {
	private State state;

	public Girl(State state) {
		this.state = state;
	}

	public void smile() {
		state.smile();
	}

	public void cry() {
		state.cry();
	}
}
