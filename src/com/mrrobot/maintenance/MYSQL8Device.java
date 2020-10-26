package com.mrrobot.maintenance;

import java.util.ArrayList;

import com.mrrobot.interfaces.IDevice;
import com.mrrobot.model.clsClient;
import com.mrrobot.model.clsDevice;

public class MYSQL8Device implements IDevice {

	@Override
	public clsDevice search(int id) {
		return null;
	}

	@Override
	public void addDevice(clsDevice d) {

	}

	@Override
	public void updateDevice(clsDevice d) {

	}

	@Override
	public ArrayList<clsDevice> listadoDevice(clsClient c) {
		return null;
	}

	@Override
	public ArrayList<clsDevice> listadoDevice() {
		return null;
	}

}
