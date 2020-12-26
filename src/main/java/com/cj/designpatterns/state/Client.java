package com.cj.designpatterns.state;

/**
 * @ClassName Client
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/18 018 23:39
 * @Version 1.0
 **/
public class Client {
	public static void main(String[] args) {
		RoomState state = new FreeState();
		Context context = new Context(state);
		context.request();
	}
}

class Context {
	private RoomState state;

	public Context(RoomState state) {
		this.state = state;
	}

	public void request() {
		state.handle();
	}
}

interface RoomState {
	void handle();
}

class FullState implements RoomState {

	@Override
	public void handle() {
		System.out.println("full...");
	}
}

class FreeState implements RoomState {

	@Override
	public void handle() {
		System.out.println("free...");
	}
}
