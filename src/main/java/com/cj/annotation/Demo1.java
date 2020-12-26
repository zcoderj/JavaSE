package com.cj.annotation;

/**
 * @ClassName Demo1
 * @Description TODO
 * @Author CJ
 * @Date 2020/8/11 011 12:02
 * @Version 1.0
 **/
public class Demo1 {

	@Information(id = 1, name = {"cj", "zcoderj"})
	public void test() {
		System.out.println("haha");
	}
}
