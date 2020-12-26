package com.cj.designpatterns.factory.factorymethod;

import com.cj.designpatterns.factory.simplefactory.MiPhone;
import com.cj.designpatterns.factory.simplefactory.Phone;

/**
 * @ClassName MiPhoneFactory
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/8 008 15:05
 * @Version 1.0
 **/
public class MiPhoneFactory implements PhoneFactory {
	@Override
	public Phone createPhone() {
		return new MiPhone();
	}
}
