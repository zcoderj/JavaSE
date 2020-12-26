package com.cj.designpatterns.factory.abstractfactory;

/**
 * @ClassName Main
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/8 008 15:30
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) {
		AbstractFactory miFactory = new MiFactory();
		Computer miComputer = miFactory.createComputer();
		Headset miHeadset = miFactory.createHeadset();

		AbstractFactory huaweiFactory = new HuaweiFactory();
		Computer huaweiComputer = huaweiFactory.createComputer();
		Headset huaweiHeadset = huaweiFactory.createHeadset();
	}
}
