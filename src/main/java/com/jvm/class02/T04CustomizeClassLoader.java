package com.jvm.class02;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName T04CustomizeClassLoader
 * @Description TODO
 * @Author CJ
 * @Date 2020/12/22 022 19:32
 * @Version 1.0
 **/
public class T04CustomizeClassLoader extends ClassLoader {

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		File file = new File("D:/test/", name.replace(".", "/").concat(".class"));
		try {
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int b = 0;
			while ((b=fis.read()) !=-1) {
				baos.write(b);
			}
			byte[] bytes = baos.toByteArray();
			baos.close();
			fis.close();
			System.out.println(Arrays.toString(bytes));
			return defineClass(name, bytes, 0, bytes.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//throw ClassNotFoundException
		return super.findClass(name);
	}

	public static void main(String[] args) throws Exception {
		ClassLoader l = new T04CustomizeClassLoader();
		Class clazz = l.loadClass("com.jvm.Hello");
		Class clazz1 = l.loadClass("com.jvm.Hello");

		System.out.println(clazz == clazz1);
		System.out.println(clazz);

		Object o = clazz.newInstance();

		Method method = clazz.getDeclaredMethod("method");
		method.invoke(o);

		System.out.println(l.getClass().getClassLoader());
		System.out.println(l.getParent());

		System.out.println(getSystemClassLoader());
	}
}
