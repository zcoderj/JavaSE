package com.cj.regex;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Demo2
 * @Description TODO
 * @Author CJ
 * @Date 2020/7/20 020 18:56
 * @Version 1.0
 **/
public class Demo2 {
	public static void main(String[] args) {

		Pattern pattern = Pattern.compile("([a-z]+)([0-9]+)");
		Matcher matcher = pattern.matcher("zcoderj110&&cj110");

//		while (matcher.find()) {
			//group(),group(0)匹配整个表达式的子字符串
//			System.out.println(matcher.group());
//			System.out.println(matcher.group(1));
//			System.out.println(matcher.group(2));
//		}

		// 替换（替换匹配到的结果）
//		String str = matcher.replaceAll("#");
//		System.out.println(str);

		// 分割
		String str2 = "z110c110j110";
		String[] strs = str2.split("\\d+");
		System.out.println(Arrays.toString(strs));
	}
}
