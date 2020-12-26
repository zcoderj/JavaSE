package com.cj.designpatterns.factory.simplefactory;

/**
 * @ClassName Main
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/8 008 14:48
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) {
		Phone miPhone = SimplePhoneFactory.createMiPhone();
		Phone huawePhone = SimplePhoneFactory.createHuawePhone();

		Phone miPhone2 = SimplePhoneFactory2.createPhone("Mi");
		Phone huaweiPhone2 = SimplePhoneFactory2.createPhone("Huawei");
	}
}
