package com.mrrobot.dao;

import com.mrrobot.interfaces.IClient;
import com.mrrobot.interfaces.IDevice;
import com.mrrobot.interfaces.IUser;
import com.mrrobot.maintenance.MYSQL5Client;
import com.mrrobot.maintenance.MYSQL5Device;
import com.mrrobot.maintenance.MYSQL5User;

public class MySQL5Factory extends Factory {

	@Override
	public IClient getClientDAO() {

		return new MYSQL5Client();
	}

	@Override
	public IDevice getDeviceDAO() {

		return new MYSQL5Device();
	}

	@Override
	public IUser getUserDAO() {

		return new MYSQL5User();
	}

}
