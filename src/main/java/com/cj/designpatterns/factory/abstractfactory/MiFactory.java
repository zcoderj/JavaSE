package com.cj.designpatterns.factory.abstractfactory;

/**
 * @ClassName MiFactory
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/8 008 15:24
 * @Version 1.0
 **/
public class MiFactory extends AbstractFactory {
	@Override
	Computer createComputer() {
		return new MiComputer();
	}

	@Override
	Headset createHeadset() {
		return new MiHeadset();
	}
}
