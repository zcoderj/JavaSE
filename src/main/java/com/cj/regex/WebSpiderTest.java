package com.cj.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName WebSpiderTest
 * @Description TODO
 * @Author CJ
 * @Date 2020/7/20 020 19:05
 * @Version 1.0
 **/
public class WebSpiderTest {

	/**
	 * 获取网页源码
	 *
	 * @param urlStr
	 * @param charset
	 * @return
	 */
	public static String getURLContent(String urlStr, String charset) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlStr);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName(charset)));
			String temp = "";
			while ((temp = reader.readLine()) != null) {
				sb.append(temp);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 获取超链接标签中的地址
	 *
	 * @param destStr
	 * @param regexStr
	 * @return
	 */
	public static List<String> getMatherSubstrs(String destStr, String regexStr) {
		Pattern pattern = Pattern.compile(regexStr);
		Matcher matcher = pattern.matcher(destStr);
		List<String> list = new ArrayList<>();
		while (matcher.find()) {
			list.add(matcher.group(1));
		}
		return list;
	}

	public static void main(String[] args) {

		String destStr = getURLContent("http://www.163.com", "gbk");
//		System.out.println(destStr);
		// 获取a标签的整个内容
		// "<a[\\s\\S]+?</a>"
		List<String> list = getMatherSubstrs(destStr, "href=\"([\\w\\s./:]+?)\"");
		for (String s : list) {
			System.out.println(s);
		}
	}
}
