package com.jvm.class02;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName T05CustomizeClassLoaderWithEncryption
 * @Description TODO 自定义类加载器（简单加密）
 * @Author CJ
 * @Date 2020/12/22 022 23:05
 * @Version 1.0
 **/
public class T05CustomizeClassLoaderWithEncryption extends ClassLoader {
	public static int seed = 0B10110110;

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		File file = new File("D:/test/", name.replace('.', '/').concat(".myclass"));
		try {
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int b = 0;
			while ((b=fis.read()) !=-1) {
				baos.write(b ^ seed);
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

		encFile("com.jvm.Hello");

		ClassLoader l = new T05CustomizeClassLoaderWithEncryption();
		Class clazz = l.loadClass("com.jvm.Hello");
		Object o = clazz.newInstance();

		Method method = clazz.getDeclaredMethod("method");
		method.invoke(o);

		System.out.println(l.getClass().getClassLoader());
		System.out.println(l.getParent());
	}

	private static void encFile(String name) throws Exception {
		File f = new File("D:/test/", name.replace('.', '/').concat(".class"));
		FileInputStream fis = new FileInputStream(f);
		FileOutputStream fos = new FileOutputStream(new File("D:/test/", name.replace(".", "/").concat(".myclass")));
		int b = 0;

		while ((b = fis.read()) != -1) {
			fos.write(b ^ seed);
		}

		fis.close();
		fos.close();
	}
}
