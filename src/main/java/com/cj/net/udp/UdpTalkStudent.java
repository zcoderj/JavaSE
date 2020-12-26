package com.cj.net.udp;

/**
 * @ClassName TalkStudent
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 12:50
 * @Version 1.0
 **/
public class UdpTalkStudent {

	public static void main(String[] args) {
		// 发送
		new Thread(new UdpTalkSend(6666, "localhost", 7777)).start();
		// 接受
		new Thread(new UdpTalkReceive(5555, "老师")).start();
	}
}
