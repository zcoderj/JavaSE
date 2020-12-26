package com.cj.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CommonsIOTest02
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/20 020 13:30
 * @Version 1.0
 **/
public class CommonsIOTest02 {
	public static void main(String[] args) throws IOException {
		// 读取文件
//		String str = FileUtils.readFileToString(new File("b.txt"), "UTF-8");
//		System.out.println(str);

		byte[] bytes = FileUtils.readFileToByteArray(new File("b.txt"));
		System.out.println(bytes.length);

//		List<String> lines = FileUtils.readLines(new File("b.txt"), "utf-8");
//		for (String line : lines) {
//			System.out.println(line);
//		}

//		LineIterator iterator = FileUtils.lineIterator(new File("b.txt"), "utf-8");
//		while (iterator.hasNext()) {
//			System.out.println(iterator.nextLine());
//		}

		// 写出文件
//		FileUtils.write(new File("bb.txt"), "伟大\r\n", "UTF-8");
		// 追加
//		FileUtils.writeStringToFile(new File("bb.txt"), "辛苦\r\n", "UTF-8", true);
//		FileUtils.writeByteArrayToFile(new File("bb.txt"), bytes, true);

		// 写出列表
		List<String> list = new ArrayList<>();
		list.add("haha");
		list.add("hehe");
		list.add("eeee");
		FileUtils.writeLines(new File("bb.txt"), list, "===", true);
	}
}
