package com.cj.io;

import java.io.*;

/**
 * @ClassName Test01
 * @Description TODO 文件字节输入流+输出流 （拷贝） / 加上字节缓冲流
 * @Author CJ
 * @Date 2020/6/19 019 10:57
 * @Version 1.0
 **/
public class Test04 {

	public static void main(String[] args) {
		// 1.创建流
		// 2.选择流
		InputStream is = null;
		OutputStream os = null;
		try {
//			is = new FileInputStream("1.jpg");
//			os = new FileOutputStream("2.jpg");
			is = new BufferedInputStream(new FileInputStream("1.jpg"));
			os = new BufferedOutputStream(new FileOutputStream("2.jpg"));
			// 3.操作流
			byte[] flush = new byte[1024 * 2];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				os.write(flush, 0, len);
				os.flush();
			}
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
