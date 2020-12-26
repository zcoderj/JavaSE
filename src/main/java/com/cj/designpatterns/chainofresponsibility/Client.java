package com.cj.designpatterns.chainofresponsibility;

/**
 * @ClassName Client
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/18 018 16:31
 * @Version 1.0
 **/
public class Client {
	public static void main(String[] args) {
		Leader director = new Director("张三");
		Leader manager = new Manager("李四");

		// 设置职责链角色的关系
		director.nextLeader = manager;

		LeaveRequest leaveRequest = new LeaveRequest("cj", 10);
		director.handleRequest(leaveRequest);
	}
}

class LeaveRequest {
	String name;
	int days;

	public LeaveRequest(String name, int days) {
		this.name = name;
		this.days = days;
	}
}

abstract class Leader {
	String name;
	Leader nextLeader;

	public Leader(String name) {
		this.name = name;
	}

	public abstract void handleRequest(LeaveRequest leaveRequest);
}

class Director extends Leader {

	public Director(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest leaveRequest) {
		if (leaveRequest.days <= 3) {
			System.out.println("Director allows leave..." + leaveRequest.name + "==" + leaveRequest.days);
		} else {
			nextLeader.handleRequest(leaveRequest);
		}
	}
}

class Manager extends Leader {

	public Manager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest leaveRequest) {
		System.out.println("Manager allows leave..." + leaveRequest.name + "==" + leaveRequest.days);
	}
}
