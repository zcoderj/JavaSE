package com.cj.net.tcp.chat;

import java.io.Closeable;
import java.io.IOException;

/**
 * @ClassName Utils
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 16:19
 * @Version 1.0
 **/
public class Utils {

	public static void close(Closeable... resources) {
		for (Closeable closeable : resources) {
			try {
				if (closeable != null) {
					closeable.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
