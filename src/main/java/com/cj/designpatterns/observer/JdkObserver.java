package com.cj.designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName JdkObserver
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/19 019 00:17
 * @Version 1.0
 **/
public class JdkObserver {
	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject();

		Observer o1 = new ObserverB();
		Observer o2 = new ObserverB();
		Observer o3 = new ObserverB();

		subject.addObserver(o1);
		subject.addObserver(o2);
		subject.addObserver(o3);

		subject.setState(100);
	}
}

class ConcreteSubject extends Observable {
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		// 表示目标对象已经改变
		setChanged();
		// 通知所有的观察者
		notifyObservers();
	}
}

class ObserverB implements Observer {

	private int myState;

	@Override
	public void update(Observable o, Object arg) {
		myState = ((ConcreteSubject) o).getState();
		System.out.println(myState);
	}
}
