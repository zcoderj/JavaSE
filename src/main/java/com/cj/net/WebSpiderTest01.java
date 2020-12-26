package com.cj.net;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName WebSpiderTest01
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/22 022 22:31
 * @Version 1.0
 **/
public class WebSpiderTest01 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com");
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
		String str = null;
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
	}
}
