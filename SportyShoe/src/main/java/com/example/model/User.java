package com.example.model;

public class User {

	private String username;
	private int userId;
	private String password;
	private String dateBooked;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateBooked() {
		return dateBooked;
	}

	public void setDateBooked(String dateBooked) {
		this.dateBooked = dateBooked;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", userId=" + userId + ", password=" + password + ", dateBooked="
				+ dateBooked + "]";
	}

}
