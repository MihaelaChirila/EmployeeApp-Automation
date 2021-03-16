package tstdata;

import utils.Reader;

public class User {
	public String username;
	public String password;

	public User(String name) {
		this.username = Reader.json(name).get("username").toString();
		this.password = Reader.json(name).get("password").toString();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
