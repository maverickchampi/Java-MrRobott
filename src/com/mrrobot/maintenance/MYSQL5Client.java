package com.mrrobot.maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.mrrobot.interfaces.IClient;
import com.mrrobot.model.clsClient;
import com.mrrobot.util.MySQL5Conexion;

public class MYSQL5Client implements IClient {

	@Override
	public clsClient searchClient(int id) {
		clsClient c = null;
		// plantilla
		Connection con = null; // capturar la conexion a la base de datos
		PreparedStatement pst = null; // Prepara las sentencias que vas a
										// utilizar
		ResultSet rs = null;
		try {
			con = MySQL5Conexion.getConexion();// Actualiza la conexion
			String sql = "select * from clientes where IdClient = ?";

			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				c = new clsClient();
				c.setidClient(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhone(rs.getString(4));
				c.setDirection(rs.getString(5));
				c.setChange(rs.getString(6));

			}
		} catch (Exception e) {
			System.out.println("Error al buscar cliente");
			// JOptionPane.showMessageDialog(null, "Error al buscar cliente",
			// "Error!", 0);
		} finally {
			MySQL5Conexion.closeConexion(con);
		}
		return c;
	}

	@Override
	public void addClient(clsClient c) {
		// Plantilla de BD
		Connection con = null; // capturar la conex con la BASE DE DATOS
		PreparedStatement pst = null; // Prepara las sentencias a utilizar
		try {
			con = MySQL5Conexion.getConexion(); // Actualiza la conexion
			String sql = "insert into clientes values(?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);

			pst.setInt(1, c.getidClient()); // ID
			pst.setString(2, c.getName()); // NOMBRE
			pst.setString(3, c.getEmail()); // EMAIL
			pst.setString(4, c.getPhone()); // TELEFONO
			pst.setString(5, c.getDirection()); // DIRECTION
			pst.setString(6, c.getChange()); // ,MODIFICACION
			pst.executeUpdate();
			// ejecutar la sentencia y guardar resultado
		} catch (Exception e) {
			System.out.println("Error al registrar cliente");
			// JOptionPane.showMessageDialog(null, "Error al registrar cliente",
			// "Error!", 0);
		} finally {
			MySQL5Conexion.closeConexion(con);
		}
	}

	@Override
	public void updateClient(clsClient c) {
		// Plantilla de BD
		Connection con = null; // capturar la conex con la BASE DE DATOS
		PreparedStatement pst = null; // Prepara las sentencias a utilizar
		try {
			con = MySQL5Conexion.getConexion(); // Actualiza la conexion
			String sql = "update clientes set NameClient=?, EmailClient=?, PhoneClient=?, DirectionClient=? ,ChangeClient=? where IdClient=?";
			pst = con.prepareStatement(sql);

			pst.setString(1, c.getName()); // NOMBRE
			pst.setString(2, c.getEmail()); // EMAIL
			pst.setString(3, c.getPhone()); // TELEFONO
			pst.setString(4, c.getDirection()); // DIRECCION
			pst.setString(5, c.getChange()); // MODIFICACION
			pst.setInt(6, c.getidClient()); // ID CLIENTE
			pst.executeUpdate();
			// ejecutar la sentencia y guardar resultado
		} catch (Exception e) {
			System.out.println("Error al actualizar cliente");
			// JOptionPane.showMessageDialog(null, "Error al actualizar
			// usuario", "Error!", 0);
		} finally {
			MySQL5Conexion.closeConexion(con);
		}
	}

	@Override
	public ArrayList<clsClient> listadoCLient() {
		ArrayList<clsClient> lista = null;
		// plantilla
		Connection con = null; // capturar la conexion a la base de datos
		PreparedStatement pst = null; // Prepara las sentencias que vas a
										// utilizar
		ResultSet rs = null;
		try {
			con = MySQL5Conexion.getConexion();// Actualiza la conexion
			String sql = "select * from clientes";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			lista = new ArrayList<clsClient>();

			while (rs.next()) {
				clsClient c = new clsClient();
				c.setidClient(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhone(rs.getString(4));
				c.setDirection(rs.getString(5));
				c.setChange(rs.getString(6));
				lista.add(c);
			}
		} catch (Exception e) {
			System.out.println("Error al listar clientes");
			// JOptionPane.showMessageDialog(null, "Error al listar clientes",
			// "Error!", 0);
		} finally {
			MySQL5Conexion.closeConexion(con);
		}
		return lista;
	}

}
