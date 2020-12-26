package com.cj.designpatterns.command;

/**
 * @ClassName Client
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/18 018 22:05
 * @Version 1.0
 **/
public class Client {
	public static void main(String[] args) {
		Command1 concreteCommand = new ConcreteCommand(new Receiver());
		Invoke invoke = new Invoke(concreteCommand);
		invoke.call();
	}
}

// 真正的命令执行者
class Receiver {
	public void action() {
		System.out.println("action...");
	}
}

// 抽象命令类
interface Command1 {
	// 多个方法。。。
	void execute();
}

// 具体命令类
class ConcreteCommand implements Command1 {
	private Receiver receiver;

	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		System.out.println("pre-processing...");
		receiver.action();
		System.out.println("post-processing...");
	}
}

// 调用者/发起者/请求者
class Invoke {
	// 或者容器，多个命令
	private Command1 command;

	public Invoke(Command1 command) {
		this.command = command;
	}

	// 业务方法，用于调用命令类的方法
	public void call() {
		command.execute();
	}
}