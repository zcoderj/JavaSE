package com.cj.net.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName LoginClient
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/24 024 15:52
 * @Version 1.0
 **/
public class LoginClient {
	public static void main(String[] args) throws IOException {
		Socket client = new Socket("localhost", 10086);
		User user = getUser();
		OutputStream outputStream = client.getOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(user);
		client.shutdownOutput();

		InputStream inputStream = client.getInputStream();
		byte[] data = new byte[1024];
		int length = inputStream.read(data);
		System.out.println(new String(data, 0, length));

		inputStream.close();
		objectOutputStream.close();
		outputStream.close();
		client.close();
	}

	private static User getUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = scanner.nextLine();
		System.out.println("请输入密码：");
		String password = scanner.nextLine();
		return new User(username, password);
	}
}
