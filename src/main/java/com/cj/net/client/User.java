package com.cj.net.client;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/24 024 15:51
 * @Version 1.0
 **/
public class User implements Serializable {
	public String username;
	public String password;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
