package com.cj.designpatterns.factory.factorymethod;

import com.cj.designpatterns.factory.simplefactory.Phone;

/**
 * @ClassName Main
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/8 008 15:07
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) {
		PhoneFactory phoneFactory1 = new MiPhoneFactory();
		Phone MiPhone = phoneFactory1.createPhone();

		PhoneFactory phoneFactory2 = new HuaweiPhoneFactory();
		Phone HuaweiPhone = phoneFactory2.createPhone();
	}
}
