package com.mrrobot.dao;

import com.mrrobot.interfaces.IClient;
import com.mrrobot.interfaces.IDevice;
import com.mrrobot.interfaces.IUser;

//clase que sólo sirve para implementar la DAO(interfaces)
public abstract class Factory { // Padre
	public static final int MYSQL5 = 1;
	public static final int MYSQL8 = 2;

	// importo interfaces
	public abstract IClient getClientDAO();

	public abstract IDevice getDeviceDAO();

	public abstract IUser getUserDAO();

	// switch para elegir opciones
	public static Factory getDAOFactory(int qFactory) {
		switch (qFactory) {
		case MYSQL5:
			return new MySQL5Factory();
		case MYSQL8:
			return new MySQL8Factory();
		default:
			return null;
		}
	}
}
