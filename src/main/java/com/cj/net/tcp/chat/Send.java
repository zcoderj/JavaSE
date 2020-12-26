package com.cj.net.tcp.chat;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName Send
 * @Description TODO 发送端
 * @Author CJ
 * @Date 2020/6/23 023 16:24
 * @Version 1.0
 **/
public class Send implements Runnable {

	private Socket client;
	private BufferedReader br;
	private DataOutputStream dos;
	private boolean isRunning;
	private String name;

	public Send(Socket client, String name) {
		this.client = client;
		br = new BufferedReader(new InputStreamReader(System.in));
		isRunning = true;
		this.name = name;
		try {
			dos = new DataOutputStream(client.getOutputStream());
			send(name);
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("send==send");
			release();
		}
	}

	@Override
	public void run() {
		while (isRunning) {
			String msg = getMsg();
			if (!msg.equals("")) {
				send(msg);
			}
		}
	}

	/**
	 * 获取信息（从控制台）
	 * @return
	 */
	private String getMsg() {
		try {
			return br.readLine();
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("send==getMsg");
			release();
		}
		return "";
	}

	/**
	 * 发送消息到服务器
	 * @param msg
	 */
	private void send(String msg) {

		try {
			dos.writeUTF(msg);
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("send==send");
			release();
		}
	}

	/**
	 * 释放资源
	 */
	private void release() {
		this.isRunning = false;
		Utils.close(client, br, dos);
	}
}
