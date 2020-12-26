package com.cj.net.tcp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @ClassName Client
 * @Description TODO 客户端
 * @Author CJ
 * @Date 2020/6/23 023 16:46
 * @Version 1.0
 **/
public class Client {

	public static void main(String[] args) throws IOException {
		System.out.println("Client...");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String name = br.readLine();
		Socket client = new Socket("localhost", 6666);
		new Thread(new Send(client, name)).start();
		new Thread(new Receive(client)).start();
	}
}
