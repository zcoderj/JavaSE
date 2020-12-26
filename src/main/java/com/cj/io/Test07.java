package com.cj.io;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName Test07
 * @Description TODO 转换流（字节流 -》 字符流）
 * @Author CJ
 * @Date 2020/6/19 019 20:25
 * @Version 1.0
 **/
public class Test07 {

	public static void main(String[] args) {
//		test1();
		test2();
	}

	public static void test1() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
			String str = null;
			while (!"exit".equals(str)) {
				str = reader.readLine();
				writer.write(str);
				writer.newLine();
				// 强制刷新
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void test2() {
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new URL("https://www.baidu.com").openStream(), "UTF-8"));
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream("baidu.html"), "UTF-8"))) {

			String data = null;
			while ((data = reader.readLine()) != null) {
				writer.write(data);
				writer.newLine();
				writer.flush();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
