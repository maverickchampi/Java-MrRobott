package com.mrrobot.interfaces;

import java.util.ArrayList;

import com.mrrobot.model.clsClient;

public interface IClient {
	public clsClient searchClient(int id);
	public void addClient(clsClient c);
	public void updateClient(clsClient c);
	public ArrayList<clsClient> listadoCLient();
}
