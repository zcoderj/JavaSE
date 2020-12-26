package com.cj.designpatterns.factory.abstractfactory;

/**
 * @ClassName HuaweiFactory
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/8 008 15:29
 * @Version 1.0
 **/
public class HuaweiFactory extends AbstractFactory {
	@Override
	Computer createComputer() {
		return new HuaweiComputer();
	}

	@Override
	Headset createHeadset() {
		return new HuaweiHeadset();
	}
}
