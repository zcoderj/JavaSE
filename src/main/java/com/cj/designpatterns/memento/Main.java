package com.cj.designpatterns.memento;

/**
 * @ClassName Main
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/19 019 00:30
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) {
		CareTaker taker = new CareTaker();
		// 信息
		User user = new User("zs");
		System.out.println(user.name);
		// 备忘
		UserMemento userMemento = user.memento();
		// 包存备忘录
		taker.userMemento = userMemento;
		// 修改
		user.name = "ls";
		System.out.println(user.name);
		// 恢复
		user.recover(taker.userMemento);
		System.out.println(user.name);
	}
}

class User {
	String name;

	public User(String name) {
		this.name = name;
	}

	public UserMemento memento() {
		return new UserMemento(this);
	}

	public void recover(UserMemento userMemento) {
		name = userMemento.name;
	}
}

// 备忘录
class UserMemento {
	String name;

	public UserMemento(User user) {
		name = user.name;
	}
}

// 负责人：管理备忘录对象
class CareTaker {
	UserMemento userMemento;
}