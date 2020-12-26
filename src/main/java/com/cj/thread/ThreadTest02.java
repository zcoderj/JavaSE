package com.cj.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName ThreadTest02
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/20 020 15:03
 * @Version 1.0
 **/
public class ThreadTest02 extends Thread {

	private String url;
	private String destPath;

	public ThreadTest02(String url, String destPath) {
		this.url = url;
		this.destPath = destPath;
	}

	@Override
	public void run() {
		UploadPhoto uploadPhoto = new UploadPhoto();
		uploadPhoto.upload(this.url, this.destPath);
		System.out.println(this.destPath);
	}

	public static void main(String[] args) {
		ThreadTest02 thread1 = new ThreadTest02("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1141259048,554497535&fm=26&gp=0.jpg",
				"cat.jpg");
		ThreadTest02 thread2 = new ThreadTest02("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1694681277,1453280371&fm=26&gp=0.jpg",
				"tiger.jpg");
		ThreadTest02 thread3 = new ThreadTest02("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1830914723,3154965800&fm=26&gp=0.jpg",
				"cloud.jpg");
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

class UploadPhoto {

	public void upload(String url, String destPath) {
		try {
			FileUtils.copyURLToFile(new URL(url), new File(destPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}