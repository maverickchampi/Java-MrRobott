package com.mrrobot.model;

public class Sesion {

	private static Sesion sesion;
	private clsUser u;

	private Sesion() {

	}

	public static Sesion getSesion() {
		if (sesion == null) {
			sesion = new Sesion();
		}
		return sesion;
	}

	public void setUser(clsUser u) {
		this.u = u;
	}

	public clsUser getUser() {
		return u;
	}
}
