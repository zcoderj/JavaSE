package com.cj.designpatterns.factory.simplefactory;

/**
 * @ClassName SimplePhoneFactory
 * @Description TODO 简单工厂 or 静态工厂
 * @Author CJ
 * @Date 2020/9/8 008 14:44
 * @Version 1.0
 *
 * 简单工厂可扩展性不好
 **/
public class SimplePhoneFactory {

	public static MiPhone createMiPhone() {
		// before processing
		return new MiPhone();
		// after processing
	}

	public static HuaweiPhone createHuawePhone() {
		return new HuaweiPhone();
	}
}
