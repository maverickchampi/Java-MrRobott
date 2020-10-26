package com.mrrobot.model;

public class clsClient {

	private int idClient;
	private String name, email, phone, direction, change;

	@Override
	public String toString() {
		return "clsClient [idClient=" + idClient + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", direction=" + direction + ", change=" + change + "]";
	}

	public int getidClient() {
		return idClient;
	}

	public void setidClient(int idClient) {
		this.idClient = idClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

}
