package com.cj.designpatterns.factory.factorymethod;

import com.cj.designpatterns.factory.simplefactory.Phone;

/**
 * @InterfaceName PhoneFactory
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/8 008 15:04
 * @Version 1.0
 **/
public interface PhoneFactory {
	Phone createPhone();
}
