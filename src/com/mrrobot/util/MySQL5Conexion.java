package com.mrrobot.util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MySQL5Conexion {

	public static Connection getConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/base_mrrobott";
			String usr = "root";
			String psw = "";
			con = (Connection) DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Llame a un administrador", "Error >> Driver no Instalado!!", 0);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Verifique su conexión a la BD", "Error >> de conexión con la BD", 0);
		}
		return con;
	}

	public static void closeConexion(java.sql.Connection con) {

		try {
			con.close();// Sentencia para cerrar la conexión
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Llame a un administrador", "Problemas al cerrar la conexion", 0);
		}
	}

}
