package com.cj.designpatterns.factory.simplefactory;

/**
 * @ClassName SimplePhoneFactory2
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/16 016 14:27
 * @Version 1.0
 **/
public class SimplePhoneFactory2 {

	public static Phone createPhone(String brand) {

		if ("Mi".equals(brand)) {
			return new MiPhone();
		} else if ("Huawei".equals(brand)) {
			return new HuaweiPhone();
		} else {
			return null;
		}
	}
}
