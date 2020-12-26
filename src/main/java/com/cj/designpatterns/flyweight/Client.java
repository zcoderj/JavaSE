package com.cj.designpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Client
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/18 018 15:43
 * @Version 1.0
 **/
public class Client {
	public static void main(String[] args) {
		ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑色");
		ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("黑色");
		System.out.println(chess1);
		System.out.println(chess2);

		// 增加外部状态的处理
		chess1.display(new Coordinate(1,2));
		chess2.display(new Coordinate(2,3));
	}
}

// 抽象享元类FlyWeight
interface ChessFlyWeight {
	String getColor();
	void display(Coordinate coordinate);
}

// 具体享元类（内部状态）ConcreteFlyWeight
class ConcreteChess implements ChessFlyWeight {

	String color;

	public ConcreteChess(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void display(Coordinate coordinate) {
		System.out.println("(" + coordinate.x + "," + coordinate.y + ")");
	}
}

// 非共享享元类（外部状态）UnSharedConcreteFlyWeight
class Coordinate {
	int x, y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// 享元工厂类FlyWeightFactory
class ChessFlyWeightFactory {
	static Map<String, ChessFlyWeight> map = new HashMap<>();

	public static ChessFlyWeight getChess(String color) {
		if (map.get(color) != null) {
			return map.get(color);
		} else {
			ChessFlyWeight chess = new ConcreteChess(color);
			map.put(color, chess);
			return chess;
		}
	}
}