package com.mrrobot.interfaces;

import java.util.ArrayList;
import com.mrrobot.model.clsUser;

public interface IUser {
	public clsUser searchUser(String nick);
	public void addUser(clsUser u);
	public void updateUser(clsUser u);
	public ArrayList<clsUser> listadoUser();
}
