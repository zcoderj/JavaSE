package com.cj.io;

import java.io.*;

/**
 * @ClassName Test05
 * @Description TODO 文件字符输入流+输出流 （拷贝） / 加上字符缓冲流
 * @Author CJ
 * @Date 2020/6/19 019 14:57
 * @Version 1.0
 **/
public class Test05 {

	public static void main(String[] args) {

//		Reader reader = null;
//		Writer writer = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
//			 reader = new FileReader("b.txt");
//			 writer = new FileWriter("c.txt");
			reader = new BufferedReader(new FileReader("b.txt"));
			writer = new BufferedWriter(new FileWriter("c.txt"));
			char[] flush = new char[1024 * 1];
			/*int len = -1;
			while ((len = reader.read(flush)) != -1) {
				writer.write(flush, 0, len);
			}*/

			// readLine ==> BufferedReader的方法
			// newLine ==> BufferedWriter的方法
			String line = null;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
