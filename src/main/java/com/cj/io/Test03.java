package com.cj.io;

import java.io.*;
import java.util.stream.Stream;

/**
 * @ClassName Test01
 * @Description TODO 文件字节输出流
 * @Author CJ
 * @Date 2020/6/19 019 10:57
 * @Version 1.0
 **/
public class Test03 {

	public static void main(String[] args) {
		// 1.创建流
		// 2.选择流
		OutputStream os = null;
		try {
//			is = new FileOutputStream("c.txt");
			// true 追加，默认为false
			os = new FileOutputStream("c.txt", true);
			// 3.操作流
			String str = "zcoderj cj\r\n";
			// 字符串-》字符数组（编码）
			byte[] bytes = str.getBytes();
			os.write(bytes, 0, bytes.length);
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// 4.释放流
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
