package com.cj.io;

import java.io.*;

/**
 * @ClassName Test01
 * @Description TODO 文件字节输入流 （分段）
 * @Author CJ
 * @Date 2020/6/19 019 10:57
 * @Version 1.0
 **/
public class Test02 {

	public static void main(String[] args) {
		// 1.创建流
		File file = new File("b.txt");
		// 2.选择流
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			// 3.操作流（分段读取）
			// 1kb
//			byte[] flush = new byte[1024 * 1];
			// 缓冲容器
			byte[] flush = new byte[3];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				// 字节数组-》字符串（解码）
				String str = new String(flush, 0, len);
				System.out.println(len + "-" + str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
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
