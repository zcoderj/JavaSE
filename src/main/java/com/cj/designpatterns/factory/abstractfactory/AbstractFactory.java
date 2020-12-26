package com.cj.designpatterns.factory.abstractfactory;

import com.cj.designpatterns.factory.simplefactory.Phone;

/**
 * @ClassName AbstractFactory
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/8 008 15:23
 * @Version 1.0
 **/
public abstract class AbstractFactory {
	abstract Computer createComputer();

	abstract Headset createHeadset();
}
