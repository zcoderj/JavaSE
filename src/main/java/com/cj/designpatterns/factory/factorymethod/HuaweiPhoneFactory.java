package com.cj.designpatterns.factory.factorymethod;

import com.cj.designpatterns.factory.simplefactory.HuaweiPhone;
import com.cj.designpatterns.factory.simplefactory.Phone;

/**
 * @ClassName HuaweiPhoneFactory
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/8 008 15:06
 * @Version 1.0
 **/
public class HuaweiPhoneFactory implements PhoneFactory {
	@Override
	public Phone createPhone() {
		return new HuaweiPhone();
	}
}
