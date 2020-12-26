package com.cj.net.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @ClassName UdpTalkClient
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 12:26
 * @Version 1.0
 **/
public class UdpTalkSend implements Runnable {

	private DatagramSocket client;
	private BufferedReader reader;
	private String toIP;
	private int toPort;

	public UdpTalkSend(int port, String toIP, int toPort) {
		try {
			client = new DatagramSocket(port);
			reader = new BufferedReader(new InputStreamReader(System.in));
			this.toIP = toIP;
			this.toPort = toPort;
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		while (true) {
			try {
				// 获取输入的信息
				String data = reader.readLine();
				byte[] datas = data.getBytes();
				// 封装包裹，指定目的地
				DatagramPacket datagramPacket = new DatagramPacket(datas, 0, datas.length,
						new InetSocketAddress(toIP, toPort));
				// 发送包裹
				client.send(datagramPacket);
				if ("bye".equals(data)) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 释放资源
		client.close();
	}
}
