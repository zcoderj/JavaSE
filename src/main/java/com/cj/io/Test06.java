package com.cj.io;

import java.io.*;

/**
 * @ClassName Test06
 * @Description TODO 字节数组流
 * @Author CJ
 * @Date 2020/6/19 019 16:40
 * @Version 1.0
 **/
public class Test06 {

	public static void main(String[] args) {
		byte[] data = fileToByteArray("1.jpg");
		byteArrayToFile(data,"3.jpg");
	}

	public static byte[] fileToByteArray(String sourcePath) {

		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try {
			is = new FileInputStream(sourcePath);
			baos = new ByteArrayOutputStream();
			byte[] flush = new byte[1024 * 2];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				baos.write(flush, 0, len);
			}
			return baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void byteArrayToFile(byte[] data, String targetPath) {

		// try...with...resource
//		InputStream is = null;
//		OutputStream os = null;
		try(InputStream is = new ByteArrayInputStream(data);
		    OutputStream os = new FileOutputStream(targetPath)) {
//			is = new ByteArrayInputStream(data);
//			os = new FileOutputStream(targetPath);
			byte[] flush = new byte[1024 * 2];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				os.write(flush, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
