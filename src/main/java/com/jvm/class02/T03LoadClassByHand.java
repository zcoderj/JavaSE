package com.jvm.class02;

/**
 * @ClassName T03LoadClassByHand
 * @Description TODO 手动加载class
 * @Author CJ
 * @Date 2020/12/22 022 18:23
 * @Version 1.0
 **/
public class T03LoadClassByHand {
	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz = T03LoadClassByHand.class.getClassLoader().loadClass("com.jvm.class02.T01ClassLoader");
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());

		// 利用类加载器加载资源
//		T03LoadClassByHand.class.getClassLoader().getResourceAsStream("");
	}
}
