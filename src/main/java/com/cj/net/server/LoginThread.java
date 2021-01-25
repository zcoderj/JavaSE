package com.cj.net.server;

import com.cj.net.client.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName LoginThread
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/24 024 16:02
 * @Version 1.0
 **/
public class LoginThread implements Runnable {
	private Socket socket;

	public LoginThread(Socket socket) {
		this.socket = socket;
	}


	@Override
	public void run() {
		ObjectInputStream objectInputStream = null;
		OutputStream outputStream = null;
		try {
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			User user = (User) objectInputStream.readObject();
			String result = "";
			if ("zs".equals(user.username) && "123".equals(user.password)) {
				result = "登录成功！";
				System.out.println("欢迎您，" + user.username);
			} else {
				result = "登录失败！";
			}
			socket.shutdownInput();

			outputStream = socket.getOutputStream();
			outputStream.write(result.getBytes());
			socket.shutdownOutput();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
				objectInputStream.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
