package com.cj;


import javax.xml.bind.SchemaOutputResolver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.*;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author CJ
 * @Date 2020/10/19 019 20:49
 * @Version 1.0
 **/
public class Test2 {

	public static void main(String[] args) {
//		String str = "001";
//		String str1 = "a1 a2.a3. a4 .a5";
//
//		String[] str1s = str1.split("\\s+|\\.");
//		System.out.println(str1s.length);
//		for (String s : str1s) {
//			System.out.println(s);
//		}

//		byte b1 = 0xf;
//		System.out.println(b1);

//		char c = str.charAt(2);
//		int i = c - '0';
//		System.out.println(Character.getNumericValue(c));
//		System.out.println(c);
//		System.out.println(i);

//		int a = -2;
//		System.out.println(a >>> 3);

//		String 欢 = "20013";
//		String 度 = "31179";
//		String 国 = "24555";
//		String 庆 = "20048";
//
//		System.err.print((char) Integer.parseInt(欢));
//		System.err.print((char) Integer.parseInt(度));
//		System.err.print((char) Integer.parseInt(国));
//		System.err.print((char) Integer.parseInt(庆));

//		Map<String, String> map = Collections.singletonMap("key", "value");
//		System.out.println(map.get("key"));

		StringTokenizer stringTokenizer = new StringTokenizer("a,b,c", ",");
		while (stringTokenizer.hasMoreTokens()) {
			System.out.println(stringTokenizer.nextToken());
		}

	}
}

interface H1 {

	int a = 1;

	public static void main(String[] args) {
	}
}






