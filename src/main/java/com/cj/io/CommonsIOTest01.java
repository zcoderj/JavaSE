package com.cj.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.*;

import java.io.File;
import java.util.Collection;

/**
 * @ClassName CommonsIOTest01
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/20 020 13:01
 * @Version 1.0
 **/
public class CommonsIOTest01 {

	public static void main(String[] args) {
		// 文件大小
//		long fileSize = FileUtils.sizeOf(new File("1.jpg"));
//		System.out.println(fileSize);
		// 目录大小
//		long directorySize = FileUtils.sizeOf(new File("splitFile"));
//		System.out.println(directorySize);

		// 列出CommonsIO文件夹下的非空子级文件
//		Collection<File> files = FileUtils.listFiles(new File("CommonsIO"), EmptyFileFilter.NOT_EMPTY, null);
//		for (File file : files) {
//			System.out.println(file.getAbsolutePath());
//		}
		// 列出CommonsIO文件夹下的空子孙级文件
//		Collection<File> files = FileUtils.listFiles(new File("CommonsIO"), EmptyFileFilter.EMPTY, DirectoryFileFilter.INSTANCE);
//		for (File file : files) {
//			System.out.println(file.getAbsolutePath());
//		}
		// 列出CommonsIO文件夹下后缀名为java的子孙级文件
//		Collection<File> files = FileUtils.listFiles(new File("CommonsIO"), new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
//		for (File file : files) {
//			System.out.println(file.getAbsolutePath());
//		}
		// 列出CommonsIO文件夹下后缀名为java或txt或为空的子孙级文件
//		Collection<File> files = FileUtils.listFiles(new File("CommonsIO"),
//				FileFilterUtils.or(new SuffixFileFilter("java"),
//				new SuffixFileFilter("txt"), EmptyFileFilter.EMPTY),
//				DirectoryFileFilter.INSTANCE);
//		for (File file : files) {
//			System.out.println(file.getAbsolutePath());
//		}
		// 列出CommonsIO下前缀为c并且不为空的子孙级文件
//		Collection<File> files = FileUtils.listFiles(new File("CommonsIO"), FileFilterUtils.and(new PrefixFileFilter("c"), EmptyFileFilter.NOT_EMPTY), DirectoryFileFilter.INSTANCE);
//		for (File file : files) {
//			System.out.println(file.getAbsolutePath());
//		}
	}
}
