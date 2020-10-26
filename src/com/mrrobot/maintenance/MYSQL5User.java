package com.mrrobot.maintenance;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mrrobot.interfaces.IUser;
import com.mrrobot.model.clsUser;
import com.mrrobot.util.MySQL5Conexion;

public class MYSQL5User implements IUser {

	@Override
	public clsUser searchUser(String nick) {
		clsUser u = null;
		// plantilla
		Connection con = null; // capturar la conexion a la base de datos
		PreparedStatement pst = null; // Prepara las sentencias que vas a
										// utilizar
		ResultSet rs = null;
		try {
			con = MySQL5Conexion.getConexion();// Actualiza la conexion
			String sql = "select * from usuarios where NickUser = ?";

			pst = con.prepareStatement(sql);
			pst.setString(1, nick);
			rs = pst.executeQuery();

			if (rs.next()) {
				u = new clsUser();
				u.setIdUser(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPhone(rs.getString(4));
				u.setNick(rs.getString(5));
				u.setPass(rs.getString(6));
				u.setStatus(rs.getBoolean(7));
				u.setNivel(rs.getInt(8));
				u.setRegistered(rs.getString(9));

			}
		} catch (Exception e) {
			System.out.println("Error al buscar usuario");
//			JOptionPane.showMessageDialog(null, "Error al buscar usuario", "Error!", 0);
		} finally {
			MySQL5Conexion.closeConexion(con);
		}
		return u;
	}

	@Override
	public void addUser(clsUser u) {
		// Plantilla de BD
		Connection con = null; // capturar la conex con la BASE DE DATOS
		PreparedStatement pst = null; // Prepara las sentencias a utilizar
		try {
			con = MySQL5Conexion.getConexion(); // Actualiza la conexion
			String sql = "insert into usuarios values(?,?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);

			pst.setInt(1, u.getidUser()); // ID
			pst.setString(2, u.getName()); // NOMBRE
			pst.setString(3, u.getEmail()); // EMAIL
			pst.setString(4, u.getPhone()); // TELEFONO
			pst.setString(5, u.getNick()); // NICK -- USER
			pst.setString(6, u.getPass()); // PASS
			pst.setBoolean(7, u.isStatus()); // STATUS -- ACTIVO
			pst.setInt(8, u.getNivel()); // NIVEL
			pst.setString(9, u.getRegistered()); // REGISTRADO POR
			pst.executeUpdate();
			// ejecutar la sentencia y guardar resultado
		} catch (Exception e) {
			System.out.println("Error al registrar usuario");
//			JOptionPane.showMessageDialog(null, "Error al registrar usuario", "Error!", 0);
		} finally {
			MySQL5Conexion.closeConexion(con);
		}
	}

	@Override
	public void updateUser(clsUser u) {
		// Plantilla de BD
		Connection con = null; // capturar la conex con la BASE DE DATOS
		PreparedStatement pst = null; // Prepara las sentencias a utilizar
		try {
			con = MySQL5Conexion.getConexion(); // Actualiza la conexion
			String sql = "update usuarios set NameUser=?, EmailUser=?, PhoneUser=?, PassUser=? ,StatusUser=?, NivelUser=? where NickUser=?";
			pst = con.prepareStatement(sql);

			pst.setString(1, u.getName()); // NOMBRE
			pst.setString(2, u.getEmail()); // EMAIL
			pst.setString(3, u.getPhone()); // TELEFONO
			pst.setString(4, u.getPass()); // CONTRA
			pst.setBoolean(5, u.isStatus()); // STATUS -- ACTIVO
			pst.setInt(6, u.getNivel()); // NIVEL
			pst.setString(7, u.getNick()); // NICK -- USER
			pst.executeUpdate();
			// ejecutar la sentencia y guardar resultado
		} catch (Exception e) {
			System.out.println("Error al actualizar usuario");
//			JOptionPane.showMessageDialog(null, "Error al actualizar usuario", "Error!", 0);
		} finally {
			MySQL5Conexion.closeConexion(con);
		}
	}

	@Override
	public ArrayList<clsUser> listadoUser() {
		ArrayList<clsUser> lista = null;
		// plantilla
		Connection con = null; // capturar la conexion a la base de datos
		PreparedStatement pst = null; // Prepara las sentencias que vas a
										// utilizar
		ResultSet rs = null;
		try {
			con = MySQL5Conexion.getConexion();// Actualiza la conexion
			String sql = "select * from usuarios";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			lista = new ArrayList<clsUser>();

			while (rs.next()) {
				clsUser u = new clsUser();
				u.setIdUser(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPhone(rs.getString(4));
				u.setNick(rs.getString(5));
				u.setPass(rs.getString(6));
				u.setStatus(rs.getBoolean(7));
				u.setNivel(rs.getInt(8));
				u.setRegistered(rs.getString(9));
				lista.add(u);
			}
		} catch (Exception e) {
			System.out.println( "Error al listar usuarios");
//			JOptionPane.showMessageDialog(null, "Error al listar usuarios", "Error!", 0);
		} finally {
			MySQL5Conexion.closeConexion(con);
		}
		return lista;
	}

}
