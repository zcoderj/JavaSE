package com.cj.designpatterns.bridge;

/**
 * @ClassName Main
 * @Description TODO 桥接模式 （多个维度扩展）
 * @Author CJ
 * @Date 2020/9/15 015 16:28
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) {
		// 放荡的书
		Gift gift1 = new WildGift(new Book());
		// 温暖的花
		Gift gift2 = new WarmGift(new Flower());
	}
}
