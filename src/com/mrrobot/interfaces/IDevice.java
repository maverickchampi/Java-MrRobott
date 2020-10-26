package com.mrrobot.interfaces;

import java.util.ArrayList;
import com.mrrobot.model.clsClient;
import com.mrrobot.model.clsDevice;

public interface IDevice {
	public clsDevice search(int id);
	public void addDevice(clsDevice d);
	public void updateDevice(clsDevice d);
	public ArrayList<clsDevice> listadoDevice(clsClient c);
	public ArrayList<clsDevice> listadoDevice();
}
