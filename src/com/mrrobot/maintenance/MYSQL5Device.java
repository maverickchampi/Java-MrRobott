package com.mrrobot.maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.mrrobot.util.MySQL5Conexion;
import com.mrrobot.interfaces.IDevice;
import com.mrrobot.model.clsClient;
import com.mrrobot.model.clsDevice;

public class MYSQL5Device implements IDevice {

	@Override
	public clsDevice search(int id) {
		clsDevice d = null;
		// plantilla
		Connection con = null; // capturar la conexion a la base de datos
		PreparedStatement pst = null; // Prepara las sentencias que vas a
										// utilizar
		ResultSet rs = null;
		try {
			con = MySQL5Conexion.getConexion();// Actualiza la conexion
			String sql = "select * from equipos where IdDevice = ?";

			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				d = new clsDevice();
				d.setIdDevice(rs.getInt(1));
				d.setIdClient(rs.getInt(2));
				d.setType(rs.getInt(3));
				d.setBrand(rs.getInt(4));
				d.setModel(rs.getString(5));
				d.setSerie(rs.getString(6));
				d.setStatus(rs.getInt(7));
				d.setChange(rs.getString(8));
				d.setObservations(rs.getString(9));
				d.setComments(rs.getString(10));
				d.setDate(rs.getString(11));

			}
		} catch (Exception e) {
			System.out.println("Error al buscar equipo");
			// JOptionPane.showMessageDialog(null, "Error al buscar equipo",
			// "Error!", 0);
		} finally {
			MySQL5Conexion.closeConexion(con);
		}
		return d;
	}

	@Override
	public void addDevice(clsDevice d) {
		// Plantilla de BD
		Connection con = null; // capturar la conex con la BASE DE DATOS
		PreparedStatement pst = null; // Prepara las sentencias a utilizar
		try {
			con = MySQL5Conexion.getConexion(); // Actualiza la conexion
			String sql = "insert into equipos values(?,?,?,?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);

			pst.setInt(1, d.getIdDevice()); // ID EQUIPO
			pst.setInt(2, d.getIdClient()); // ID CLIENTE
			pst.setInt(3, d.getType()); // TIPO
			pst.setInt(4, d.getBrand()); // MARCA
			pst.setString(5, d.getModel()); // MODELO
			pst.setString(6, d.getSerie()); // SERIE
			pst.setInt(7, d.getStatus()); // ESTADO
			pst.setString(8, d.getChange()); // MODIFICACION
			pst.setString(9, d.getObservations()); // OBSERVACIONES
			pst.setString(10, d.getComments()); // COMENTARIOS
			pst.setString(11, d.getDate()); // FECHA
			pst.executeUpdate();
			// ejecutar la sentencia y guardar resultado
		} catch (Exception e) {
			System.out.println("Error al registrar equipo" + e);
			// JOptionPane.showMessageDialog(null, "Error al registrar equipo",
			// "Error!", 0);
		} finally {
			MySQL5Conexion.closeConexion(con);
		}
	}

	@Override
	public void updateDevice(clsDevice d) {
		// Plantilla de BD
		Connection con = null; // capturar la conex con la BASE DE DATOS
		PreparedStatement pst = null; // Prepara las sentencias a utilizar
		try {
			con = MySQL5Conexion.getConexion(); // Actualiza la conexion
			String sql = "update equipos set TypeDevice=?, BrandDevice=?, ModelDevice=?, SerieDevice=? ,StatusDevice=?, ChangeDevice=?,ObservationsDevice=?,CommentsDevice=? where IdDevice=?";
			pst = con.prepareStatement(sql);

			pst.setInt(1, d.getType()); // TIPO
			pst.setInt(2, d.getBrand()); // MARCA
			pst.setString(3, d.getModel()); // MODELO
			pst.setString(4, d.getSerie()); // SERIE
			pst.setInt(5, d.getStatus()); // ESTADO
			pst.setString(6, d.getChange()); // MODIFICACION
			pst.setString(7, d.getObservations()); // OBSERVACIONES
			pst.setString(8, d.getComments()); // COMENTARIOS
			pst.setInt(9, d.getIdDevice()); // ID EQUIPO
			pst.executeUpdate();

			// ejecutar la sentencia y guardar resultado
		} catch (Exception e) {
			System.out.println("Error al actualizar equipo");
			// JOptionPane.showMessageDialog(null, "Error al actualizar
			// equipo", "Error!", 0);
		} finally {
			MySQL5Conexion.closeConexion(con);
		}
	}

	@Override
	public ArrayList<clsDevice> listadoDevice(clsClient c) {
		ArrayList<clsDevice> lista = null;
		// plantilla
		Connection con = null; // capturar la conexion a la base de datos
		PreparedStatement pst = null; // Prepara las sentencias que vas a
										// utilizar
		ResultSet rs = null;
		try {
			con = MySQL5Conexion.getConexion();// Actualiza la conexion
			String sql = "select * from equipos where IdClient = ?";

			pst = con.prepareStatement(sql);
			pst.setInt(1, c.getidClient());
			rs = pst.executeQuery();

			lista = new ArrayList<clsDevice>();

			while (rs.next()) {
				clsDevice d = new clsDevice();
				d.setIdDevice(rs.getInt(1));
				d.setIdClient(rs.getInt(2));
				d.setType(rs.getInt(3));
				d.setBrand(rs.getInt(4));
				d.setModel(rs.getString(5));
				d.setSerie(rs.getString(6));
				d.setStatus(rs.getInt(7));
				d.setChange(rs.getString(8));
				d.setObservations(rs.getString(9));
				d.setComments(rs.getString(10));
				d.setDate(rs.getString(11));
				lista.add(d);
			}
		} catch (Exception e) {
			System.out.println("Error al listar equipos");
			// JOptionPane.showMessageDialog(null, "Error al listar equipos",
			// "Error!", 0);
		} finally {
			MySQL5Conexion.closeConexion(con);
		}
		return lista;
	}

	@Override
	public ArrayList<clsDevice> listadoDevice() {
		ArrayList<clsDevice> lista = null;
		// plantilla
		Connection con = null; // capturar la conexion a la base de datos
		PreparedStatement pst = null; // Prepara las sentencias que vas a
										// utilizar
		ResultSet rs = null;
		try {
			con = MySQL5Conexion.getConexion();// Actualiza la conexion
			String sql = "select * from equipos";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			lista = new ArrayList<clsDevice>();

			while (rs.next()) {
				clsDevice d = new clsDevice();
				d.setIdDevice(rs.getInt(1));
				d.setIdClient(rs.getInt(2));
				d.setType(rs.getInt(3));
				d.setBrand(rs.getInt(4));
				d.setModel(rs.getString(5));
				d.setSerie(rs.getString(6));
				d.setStatus(rs.getInt(7));
				d.setChange(rs.getString(8));
				d.setObservations(rs.getString(9));
				d.setComments(rs.getString(10));
				d.setDate(rs.getString(11));
				lista.add(d);
			}
		} catch (Exception e) {
			System.out.println("Error al listar equipos");
			// JOptionPane.showMessageDialog(null, "Error al listar equipos",
			// "Error!", 0);
		} finally {
			MySQL5Conexion.closeConexion(con);
		}
		return lista;
	}

}
