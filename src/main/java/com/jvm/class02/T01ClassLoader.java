package com.jvm.class02;

/**
 * @ClassName T01ClassLoader
 * @Description TODO
 * @Author CJ
 * @Date 2020/12/18 018 13:47
 * @Version 1.0
 **/
public class T01ClassLoader {

	public static void main(String[] args) {
		// sun.misc.Launcher$AppClassLoader@18b4aac2
		System.out.println(T01ClassLoader.class.getClassLoader());
		// null
		System.out.println(T01ClassLoader.class.getClassLoader().getClass().getClassLoader());
		// sun.misc.Launcher$ExtClassLoader@7f31245a
		System.out.println(T01ClassLoader.class.getClassLoader().getParent());
		// bootstrap class loader（本地实现） ==> null
		System.out.println(T01ClassLoader.class.getClassLoader().getParent().getParent());
		// java.lang.NullPointerException
		System.out.println(T01ClassLoader.class.getClassLoader().getParent().getParent().getParent());
	}
}
