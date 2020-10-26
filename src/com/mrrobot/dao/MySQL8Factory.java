package com.mrrobot.dao;

import com.mrrobot.interfaces.IClient;
import com.mrrobot.interfaces.IDevice;
import com.mrrobot.interfaces.IUser;
import com.mrrobot.maintenance.MYSQL8Client;
import com.mrrobot.maintenance.MYSQL8Device;
import com.mrrobot.maintenance.MYSQL8User;

public class MySQL8Factory extends Factory {

	@Override
	public IClient getClientDAO() {
	
		return new MYSQL8Client();
	}

	@Override
	public IDevice getDeviceDAO() {
		
		return new MYSQL8Device();
	}

	@Override
	public IUser getUserDAO() {
		
		return new MYSQL8User();
	}

}
