package com.cj.designpatterns.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @ClassName Main
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/15 015 16:18
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:/test.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		while (line != null && !line.equals("")) {
			System.out.println(line);
		}
		br.close();
	}

}
