package com.mrrobot.model;

public class clsUser {

	private String name, email, phone, nick, pass, registered;
	private boolean status;
	private int idUser, nivel;

	@Override
	public String toString() {
		return "clsUser [idUser=" + idUser + ", name=" + name + ", email=" + email + ", phone=" + phone + ", nick="
				+ nick + ", pass=" + pass + ", registered=" + registered + ", status=" + status + ", nivel=" + nivel
				+ "]";
	}

	public int getidUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
}
