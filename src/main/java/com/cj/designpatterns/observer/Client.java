package com.cj.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Client
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/19 019 00:01
 * @Version 1.0
 **/
public class Client {
	public static void main(String[] args) {
		SubjectA subjectA = new SubjectA();

		Observer o1 = new ObserverA();
		Observer o2 = new ObserverA();
		Observer o3 = new ObserverA();

		subjectA.register(o1);
		subjectA.register(o2);
		subjectA.register(o3);

		subjectA.setState(100);
	}
}

class Subject {
	protected List<Observer> list = new ArrayList<>();

	public void register(Observer observer) {
		list.add(observer);
	}

	public void remove(Observer observer) {
		list.remove(observer);
	}

	protected void Notify() {
		for (Observer observer : list) {
			observer.update(this);
		}
	}
}

class SubjectA extends Subject {
	int state;

	public void setState(int state) {
		this.state = state;
		Notify();
	}
}

interface Observer {
	void update(Subject subject);
}

class ObserverA implements Observer {

	private int state;

	@Override
	public void update(Subject subject) {
		state = ((SubjectA) subject).state;
		System.out.println(state);
	}
}
