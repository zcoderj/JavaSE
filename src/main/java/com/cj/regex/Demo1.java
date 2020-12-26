package com.cj.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Demo1
 * @Description TODO
 * @Author CJ
 * @Date 2020/7/20 020 18:48
 * @Version 1.0
 **/
public class Demo1 {
	public static void main(String[] args) {

		// 表达式对象
		Pattern pattern = Pattern.compile("\\w+");
		// 创建Matcher对象
		Matcher matcher = pattern.matcher("zcoderj&&cj");

		// 将整个字符串序列与该模式匹配
//		boolean matches = matcher.matches();
//		System.out.println(matches);

		// 该方法扫描输入的序列，查找与该模式匹配的下一个子序列
//		boolean b = matcher.find();
//		System.out.println(b);
//		System.out.println(matcher.group());

		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println(matcher.group(0));
		}
	}
}
