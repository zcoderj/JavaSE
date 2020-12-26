package com.cj.designpatterns.singleton;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * @ClassName Singleton09
 * @Description TODO 反序列化或反射获取单例模式的对象，即破解了所谓的单例（不包括枚举单例模式），如何防止
 * @Author CJ
 * @Date 2020/9/7 007 09:57
 * @Version 1.0
 *
 **/
public class Singleton09 implements Serializable {
	private static final Singleton09 INSTANCE = new Singleton09();

	private Singleton09() {
		// 防止反射创建对象从而破坏了单例模式
		if (INSTANCE != null) {
			throw new RuntimeException();
		}
	}

	public static Singleton09 getInstance() {
		return INSTANCE;
	}

	/**
	 * 反序列化时，如果定义了readResolve()方法，则直接返回此方法的指定的返回对象，而不需要再单独创建新对象
	 * 从而防止反序列化破坏单例模式
	 * @return
	 */
	public Object readResolve() /*throws ObjectStreamException*/ {
		return getInstance();
	}

	public static void main(String[] args) throws Exception {
		Singleton09 s1 = Singleton09.getInstance();
		Singleton09 s2 = Singleton09.getInstance();
		System.out.println(s1);
		System.out.println(s2);

		// 通过反射获取单例模式的对象
//		Class<Singleton09> clazz = (Class<Singleton09>) Class.forName("com.cj.designpatterns.singleton.Singleton09");
//		Constructor<Singleton09> constructor = clazz.getDeclaredConstructor(null);
//		constructor.setAccessible(false);
//		Singleton09 s3 = constructor.newInstance();
//		Singleton09 s4 = constructor.newInstance();
//		System.out.println(s3);
//		System.out.println(s4);

		// 序列化单例对象
//		OutputStream os = new FileOutputStream("D:/a.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(os);
//		oos.writeObject(s1);
//		oos.close();

		// 通过反序列化获取单例模式的对象
//		InputStream is = new FileInputStream("D:/a.txt");
//		ObjectInputStream ois = new ObjectInputStream(is);
//		Singleton09 s3 = (Singleton09) ois.readObject();
//		System.out.println(s3);
	}
}
