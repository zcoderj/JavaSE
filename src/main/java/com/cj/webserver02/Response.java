package com.cj.webserver02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @ClassName Response
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/24 024 07:01
 * @Version 1.0
 **/
public class Response {

	private BufferedWriter bw;
	// 正文
	private StringBuilder content;
	// 协议头
	private StringBuilder headInfo;
	// 正文字节数
	private int len;
	// 空格
	private final String BLANK = " ";
	// 换行
	private final String CRLF = "\r\n";

	public Response() {
		content = new StringBuilder();
		headInfo = new StringBuilder();
	}

	public Response(Socket client) {
		this();
		try {
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			headInfo = null;
		}
	}

	public Response(OutputStream os) {
		this();
		bw = new BufferedWriter(new OutputStreamWriter(os));
	}

	/**
	 * 动态添加内容
	 *
	 * @param info
	 * @return
	 */
	public Response print(String info) {
		content.append(info);
		len += info.getBytes().length;
		return this;
	}

	/**
	 * 动态添加内容（换行）
	 *
	 * @param info
	 * @return
	 */
	public Response println(String info) {
		content.append(info).append(CRLF);
		len += (info + CRLF).getBytes().length;
		return this;
	}

	/**
	 * 构建头信息
	 * @param code
	 */
	private void creadHaedInfo(int code) {
		// 1.响应行: HTTP/1.1 200 OK
		headInfo.append("HTTP/1.1").append(BLANK);
		headInfo.append(code).append(BLANK);
		switch (code) {
			case 200:
				headInfo.append("OK").append(CRLF);
				break;
			case 404:
				headInfo.append("NOT FOUND").append(CRLF);
				break;
			case 505:
				headInfo.append("SERVER ERROR").append(CRLF);
				break;
		}
		// 2.响应头(最后一行存在空行):
		headInfo.append("Date:").append(new Date()).append(CRLF);
		headInfo.append("Server:").append("zcoderj Server/0.0.1;charset=gbk").append(CRLF);
		headInfo.append("Content-type:text/html").append(CRLF);
		headInfo.append("Content-length:").append(len).append(CRLF);
		headInfo.append(CRLF);
	}

	/**
	 * 返回响应信息
	 * @param code
	 * @throws IOException
	 */
	public void pushToBrowser(int code) throws IOException {
		if (headInfo == null) {
			code = 505;
		}
		creadHaedInfo(code);
		bw.append(headInfo);
		bw.append(content);
		bw.flush();
	}
}
