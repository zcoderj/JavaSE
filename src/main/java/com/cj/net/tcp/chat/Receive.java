package com.cj.net.tcp.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @ClassName Receive
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 16:39
 * @Version 1.0
 **/
public class Receive implements Runnable {

	private Socket client;
	private boolean isRunning;
	private DataInputStream dis;

	public Receive(Socket client) {
		this.client = client;
		this.isRunning = true;
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("receive==Receive");
			release();
		}
	}

	@Override
	public void run() {
		while (isRunning) {
			String msg = receive();
			if (!msg.equals("")) {
				System.out.println(msg);
			}
		}
	}

	/**
	 * 接受消息
	 * @return
	 */
	private String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();
			return msg;
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("receive==reveive");
			release();
		}
		return "";
	}

	/**
	 * 释放资源
	 */
	private void release() {

	}
}
