package com.cj.net.udp;

import java.io.*;

/**
 * @ClassName IOUtils
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 11:25
 * @Version 1.0
 **/
public class IOUtils {

	public static byte[] FileToByteArray(String filePath) {

		InputStream is = null;
		ByteArrayOutputStream baos = null;

		try {
			is = new BufferedInputStream(new FileInputStream(filePath));
			baos = new ByteArrayOutputStream();
			byte[] flush = new byte[1024 * 2];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				baos.write(flush, 0, len);
			}
			baos.flush();
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

	public static void ByteArrayToFile(byte[] data, String filePath) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new ByteArrayInputStream(data);
			os = new FileOutputStream(filePath);
			byte[] flush = new byte[1024 * 2];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				os.write(flush, 0, len);
			}
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
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
