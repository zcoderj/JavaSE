package com.cj.net.tcp.chat;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName Chat
 * @Description TODO 聊天室 服务器
 * @Author CJ
 * @Date 2020/6/23 023 15:43
 * @Version 1.0
 **/
public class Chat {

	private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();

	public static void main(String[] args) throws IOException {
		System.out.println("Server...");
		ServerSocket server = new ServerSocket(6666);
		while (true) {
			Socket client = server.accept();
			System.out.println("一个新用户建立了连接");
			Channel channel = new Channel(client);
			all.add(channel);
			new Thread(channel).start();
		}
	}

	static class Channel implements Runnable {

		private Socket client;
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning;
		private String name;

		public Channel(Socket client) {
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				isRunning = true;
				name = receive();
				send("欢迎来到聊天室");
				sendOthers(name + "进入了聊天室", true);
			} catch (IOException e) {
//				e.printStackTrace();
				System.out.println("server==channel");
				release();
			}
		}

		@Override
		public void run() {
			while (isRunning) {
				String msg = receive();
				if (msg != "") {
					sendOthers(msg, false);
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
			} catch (IOException e) {
//				e.printStackTrace();
				System.out.println("server==receive");
				release();
			}
			return msg;
		}

		/**
		 * 发送消息
		 * @param msg
		 */
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
//				e.printStackTrace();
				System.out.println("server==send");
				release();
			}
		}

		/**
		 * 发送消息给其他用户
		 * @param msg
		 * @param isSysMsg
		 */
		private void sendOthers(String msg, boolean isSysMsg) {

			boolean isPrivate = msg.startsWith("@");
			// 私聊消息
			if (isPrivate) {
				int index = msg.indexOf(":");
				String targetName = msg.substring(1, index);
				msg = msg.substring(index + 1);
				for (Channel channel : all) {
					if (channel.name.equals(targetName)) {
						channel.send(this.name + "私聊对您说：" + msg);
						break;
					}
				}
			} else {
				for (Channel channel : all) {
					if (channel == this) {
						continue;
					} else {
						if (isSysMsg) {
							// 系统消息
							channel.send(msg);
						} else {
							// 群聊消息
							channel.send(this.name + ":" + msg);
						}
					}
				}
			}
		}

		/**
		 * 释放资源
		 */
		private void release() {
			this.isRunning = false;
			// 释放资源
			Utils.close(client, dis, dos);
			// 退出聊天室
			all.remove(this);
			sendOthers(this.name + "离开了聊天室", true);
		}
	}
}
