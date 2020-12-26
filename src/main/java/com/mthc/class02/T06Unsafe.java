package com.mthc.class02;

import sun.misc.Unsafe;

/**
 * @ClassName T06Unsafe
 * @Description TODO
 * @Author CJ
 * @Date 2020/11/21 021 12:46
 * @Version 1.0
 **/
public class T06Unsafe {
	int a;

	public static void main(String[] args) {
		Unsafe unsafe = Unsafe.getUnsafe();
		try {
			T06Unsafe t = (T06Unsafe) unsafe.allocateInstance(T06Unsafe.class);
			t.a = 6;
			System.out.println(t.a);
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
}
