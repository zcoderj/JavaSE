package com.cj.test;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName Test
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/17 017 09:04
 * @Version 1.0
 **/
public class Test {

	public static void main(String[] args) throws Exception {
//		StringBuilder sb = new StringBuilder();
//
//		for (int i = 0; i < 26; i++) {
//			sb.append((char) ('a' + i));
//		}
//
//		System.out.println(sb);
//
////		sb.deleteCharAt(0);
//		sb.delete(0,1);
//		System.out.println(sb);

//		Date date1 = new Date(2000);
//		System.out.println(date1);

//		Date date2 = new Date();
//		System.out.println(date2);
//
////		System.out.println(date2.before(date1));
//
//		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH小时mm分钟ss秒");
//		String format = df.format(date2);
//		System.out.println(format);
//
//		DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
//		Date date3 = df2.parse("2020年06月17日 09时54分45秒");
//		System.out.println(date3);
//
//		//当年中的第几天
//		DateFormat df3 = new SimpleDateFormat("D");
//		String days = df3.format(new Date());
//		System.out.println(days);

//		Calendar calendar = new GregorianCalendar(1999,0,10,22,22,22);
//		System.out.println(calendar);
//		int year = calendar.get(Calendar.YEAR);
//		System.out.println(year);
//
//		Calendar calendar2 = new GregorianCalendar();
//		calendar2.set(Calendar.YEAR, 1999);
//		System.out.println(calendar2);
//		Date date = calendar2.getTime();
//
//		Calendar calendar3 = new GregorianCalendar();
//		calendar3.setTime(new Date());
//		System.out.println(calendar3);


		// 可视化日期：
		/*Scanner scanner = new Scanner(System.in);
		System.out.println("请输入日期，格式为2020-06-17");
		String str = scanner.nextLine();

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(str);

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		System.out.println("日\t一\t二\t三\t四\t五\t六");

		int days = calendar.getActualMaximum(Calendar.DATE);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		for (int i = 0; i < dayOfWeek - 1; i++) {
			System.out.print(" \t");
		}

		for (int j = 1; j <= days; j++) {
			if (calendar.get(Calendar.DAY_OF_MONTH) == dayOfMonth) {
				System.out.print(j + "*\t");
			} else {
				System.out.print(j + "\t");
			}
			if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				System.out.println();
			}
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}*/

//		File file = new File("D:/a.txt");
//		File file = new File("D:\\a.txt");
//		System.out.println(file);
//
//		System.out.println(System.getProperty("user.dir"));
//
//		File file2 = new File("b.txt");
//		file2.createNewFile();
//		System.out.println(file2.exists());
//		System.out.println(file2.isFile());
//		System.out.println(file2.isDirectory());
//		System.out.println(file2.lastModified());
//		System.out.println(file2.length());
//		System.out.println(file2.getName());
//		System.out.println(file2.getPath());
//		System.out.println(file2.getAbsolutePath());

//		File file3 = new File("D:/aaa/aaa");
//		// mkdir 目录中有一个不存在，则返回false(创建一级目录)，mkdirs 不存在则新建，返回true（创建多级目录）
////		boolean mkdir = file3.mkdir();
//		boolean mkdir = file3.mkdirs();
//		System.out.println(mkdir);

//		File[] files = File.listRoots();
//		for (File file1 : files) {
//			System.out.println(file1.getPath());
//		}

//		System.out.println(Season.SPRING);
//		Season summer = Season.SUMMER;

//		File file = new File("D:/IDEA/JavaSE");
////		printFileName(file, 0);
//
//		System.out.println(sizeOfDirectory(file));

//		String str = "你好hi";
//		byte[] bytes = str.getBytes("GBK");
//		System.out.println(bytes.length);
//
//		str = new String(bytes,0, str.length(), "GBK");
//		System.out.println(str);

	}

	public static void printFileName(File file, int deep) {

		if (null == file || !file.exists()) {
			return;
		}

		System.out.print(deep);
		for (int i = 0; i < deep; i++) {
			System.out.print("-");
		}
		System.out.println(file.getName());

		if (file.isDirectory()) {
			for (File listFile : file.listFiles()) {
				printFileName(listFile, deep + 1);
			}
		}
	}

	private static long size;

	public static Long sizeOfDirectory(File file) {
		if (null == file || !file.exists()) {
			return null;
		}
		if (file.isFile()) {
			size += file.length();
		} else if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				sizeOfDirectory(f);
			}
		}
		return size;

	}

}
