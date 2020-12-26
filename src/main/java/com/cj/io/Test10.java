package com.cj.io;

import java.io.*;

/**
 * @ClassName Test10
 * @Description TODO 打印流
 * @Author CJ
 * @Date 2020/6/20 020 10:29
 * @Version 1.0
 **/
public class Test10 {

	public static void main(String[] args) throws FileNotFoundException {

//		printStream();
		printWriter();
	}

	public static void printStream() throws FileNotFoundException {
		PrintStream ps = System.out;
		ps.println("hahaha");

		// 重定向输出端
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("printStream.txt")));
		ps.println("哈哈");
		ps.println("haha");
		ps.flush();
		ps.close();

		// 重定向会原始输出端
		// true 自动刷新
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)), true);
		ps.println("lalala");
//		ps.flush();
		ps.close();
	}

	public static void printWriter() throws FileNotFoundException {

		PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("printWriter.txt")), true);

		pw.println("啦啦啦");
		pw.println("lalala");
		pw.close();
	}
}
