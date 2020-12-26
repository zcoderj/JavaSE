package com.cj.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.attribute.FileTime;

/**
 * @ClassName CommonsIOTest03
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/20 020 13:48
 * @Version 1.0
 **/
public class CommonsIOTest03 {

	public static void main(String[] args) throws IOException {
		// 复制文件
//		FileUtils.copyFile(new File("b.txt"), new File("b-copy.txt"));
		// 复制文件到目录
//		FileUtils.copyFileToDirectory(new File("b.txt"), new File("CommonsIO/copy"));
		// 复制目录到目录
//		FileUtils.copyDirectoryToDirectory(new File("CommonsIO/test"), new File("CommonsIO/copy"));
		// 复制目录
//		FileUtils.copyDirectory(new File("CommonsIO/test"), new File("CommonsIO/test2"));
		// 拷贝URL内容
		// 到文件
//		String url = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1592632757&di=d6c2810b73df731fa142c602ef144e5e&src=http://a3.att.hudong.com/14/75/01300000164186121366756803686.jpg";
//		FileUtils.copyURLToFile(new URL(url), new File("copy.jpg"));
		// 到字符串
//		String str = IOUtils.toString(new URL("http://www.baidu.com"), "utf-8");
//		System.out.println(str);
//		String str = IOUtils.toString(new URL("http://www.163.com"), "gbk");
//		System.out.println(str);

	}
}
