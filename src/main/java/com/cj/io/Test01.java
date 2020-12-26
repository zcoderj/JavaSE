package com.cj.io;

import java.io.*;

/**
 * @ClassName Test01
 * @Description TODO 文件字节输入流
 * @Author CJ
 * @Date 2020/6/19 019 10:57
 * @Version 1.0
 **/
public class Test01 {

	public static void main(String[] args) {
		// 1.创建流
		File file = new File("b.txt");
		// 2.选择流
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			// 3.操作流
			int temp;
			while ((temp = is.read()) != -1) {
				System.out.println(temp + "-" +(char)temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// 4.释放流
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
