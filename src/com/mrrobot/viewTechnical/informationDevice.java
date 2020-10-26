package com.mrrobot.viewTechnical;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import com.mrrobot.dao.Factory;
import com.mrrobot.model.Sesion;
import com.mrrobot.model.clsDevice;

public class informationDevice extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JLabel lblInformacinDeEquipo;
	private JLabel lblTipo;
	private JComboBox<String> cbTipo;
	private JLabel lblMarca;
	private JComboBox<String> cbMarca;
	private JLabel lblModelo;
	private JTextField txtModelo;
	private JLabel lblSerie;
	private JTextField txtSerie;
	private JLabel lblUsuario;
	private JTextField txtModificacion;
	private JScrollPane spComentarios;
	private JScrollPane spObservaciones;
	private JButton btnUpdate;
	private JLabel lblComentarios;
	private JLabel lblObservaciones;
	private JComboBox<String> cbEstado;
	private JTextField txtFecha;
	private JLabel lblEstado;
	private JLabel lblFechaIngreso;
	private JTextArea txtObservaciones;
	private JTextArea txtComentarios;

	protected static boolean equipo = false;

	public static void main(String[] args) {
		try {
			informationDevice dialog = new informationDevice(null, false, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public informationDevice(JDialog frame, boolean modal, clsDevice d) {
		super(frame, modal);
		try {
			setTitle("Información de equipo - Sesión de " + Sesion.getSesion().getUser().getNick());
		} catch (Exception e) {
			setTitle("Información de equipo - Sesión Prueba");
		}

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(sesion_technical.class.getResource("/com/mrrobot/images/icono.png")));
		setBounds(100, 100, 500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(220, 220, 220));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblInformacinDeEquipo = new JLabel("Informaci\u00F3n de equipo");
			lblInformacinDeEquipo.setHorizontalAlignment(SwingConstants.CENTER);
			lblInformacinDeEquipo.setForeground(Color.DARK_GRAY);
			lblInformacinDeEquipo.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblInformacinDeEquipo.setBounds(10, 16, 458, 20);
			contentPanel.add(lblInformacinDeEquipo);
		}
		{
			lblTipo = new JLabel("Tipo", SwingConstants.CENTER);
			lblTipo.setForeground(Color.DARK_GRAY);
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTipo.setBounds(10, 130, 189, 15);
			contentPanel.add(lblTipo);
		}
		{
			lblMarca = new JLabel("Marca", SwingConstants.CENTER);
			lblMarca.setForeground(Color.DARK_GRAY);
			lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMarca.setBounds(10, 195, 189, 15);
			contentPanel.add(lblMarca);
		}
		{
			lblModelo = new JLabel("Modelo", SwingConstants.CENTER);
			lblModelo.setForeground(Color.DARK_GRAY);
			lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblModelo.setBounds(10, 260, 189, 15);
			contentPanel.add(lblModelo);
		}
		{
			lblSerie = new JLabel("Serie", SwingConstants.CENTER);
			lblSerie.setForeground(Color.DARK_GRAY);
			lblSerie.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblSerie.setBounds(10, 325, 189, 15);
			contentPanel.add(lblSerie);
		}
		{
			lblUsuario = new JLabel("Registrado por", SwingConstants.CENTER);
			lblUsuario.setForeground(Color.DARK_GRAY);
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUsuario.setBounds(10, 388, 189, 20);
			contentPanel.add(lblUsuario);
		}
		{
			lblComentarios = new JLabel("Comentarios / actualizaci\u00F3n t\u00E9cnico", SwingConstants.CENTER);
			lblComentarios.setForeground(Color.DARK_GRAY);
			lblComentarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblComentarios.setBounds(219, 270, 249, 15);
			contentPanel.add(lblComentarios);
		}
		{
			lblObservaciones = new JLabel("Observaciones / reporte ", SwingConstants.CENTER);
			lblObservaciones.setForeground(Color.DARK_GRAY);
			lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblObservaciones.setBounds(219, 130, 249, 15);
			contentPanel.add(lblObservaciones);
		}
		{
			lblEstado = new JLabel("Estado", SwingConstants.CENTER);
			lblEstado.setForeground(Color.DARK_GRAY);
			lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblEstado.setBounds(219, 70, 92, 15);
			contentPanel.add(lblEstado);
		}
		{
			lblFechaIngreso = new JLabel("Fecha Ingreso", SwingConstants.CENTER);
			lblFechaIngreso.setForeground(Color.DARK_GRAY);
			lblFechaIngreso.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblFechaIngreso.setBounds(10, 60, 189, 18);
			contentPanel.add(lblFechaIngreso);
		}
		{
			cbTipo = new JComboBox<String>();
			cbTipo.setEnabled(false);
			cbTipo.setModel(new DefaultComboBoxModel<String>(
					new String[] { "Celular", "Laptop", "Computadora", "Tablet", "Impresora" }));
			cbTipo.setForeground(Color.DARK_GRAY);
			cbTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cbTipo.setFocusable(false);
			cbTipo.setBorder(new LineBorder(new Color(0, 0, 0)));
			cbTipo.setBackground(new Color(211, 211, 211));
			cbTipo.setBounds(11, 150, 188, 35);
			contentPanel.add(cbTipo);
		}
		{
			cbMarca = new JComboBox<String>();
			cbMarca.setEnabled(false);
			cbMarca.setModel(new DefaultComboBoxModel<String>(new String[] { "Acer", "Alcatel", "Alienware", "Apple",
					"Asus", "BlackBerry", "Canon", "Dell", "Epson", "Honor", "HP", "Huawei", "Lenovo", "LG",
					"Microsoft", "Motorola", "MSI", "Nokia", "OnePlus", "OPPO", "Razer", "Realme", "Samsung", "Sony",
					"Toshiba", "Vivo", "Xiaomi", "ZTE" }));
			cbMarca.setForeground(Color.DARK_GRAY);
			cbMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cbMarca.setFocusable(false);
			cbMarca.setBorder(new LineBorder(new Color(0, 0, 0)));
			cbMarca.setBackground(new Color(211, 211, 211));
			cbMarca.setBounds(10, 215, 188, 35);
			contentPanel.add(cbMarca);
		}
		{
			txtModelo = new JTextField();
			txtModelo.setEditable(false);
			txtModelo.setForeground(Color.DARK_GRAY);
			txtModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtModelo.setColumns(10);
			txtModelo.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtModelo.setBackground(new Color(211, 211, 211));
			txtModelo.setBounds(10, 280, 188, 35);
			contentPanel.add(txtModelo);
		}
		{
			txtSerie = new JTextField();
			txtSerie.setEditable(false);
			txtSerie.setForeground(Color.DARK_GRAY);
			txtSerie.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtSerie.setColumns(10);
			txtSerie.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtSerie.setBackground(new Color(211, 211, 211));
			txtSerie.setBounds(10, 345, 188, 35);
			contentPanel.add(txtSerie);
		}
		{
			txtModificacion = new JTextField();
			txtModificacion.setEditable(false);
			txtModificacion.setForeground(Color.DARK_GRAY);
			txtModificacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtModificacion.setColumns(10);
			txtModificacion.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtModificacion.setBackground(new Color(211, 211, 211));
			txtModificacion.setBounds(10, 410, 188, 35);
			contentPanel.add(txtModificacion);
		}
		{
			txtFecha = new JTextField();
			txtFecha.setForeground(Color.DARK_GRAY);
			txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtFecha.setEditable(false);
			txtFecha.setColumns(10);
			txtFecha.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtFecha.setBackground(new Color(211, 211, 211));
			txtFecha.setBounds(10, 84, 189, 35);
			contentPanel.add(txtFecha);
		}
		{
			btnVolver = new JButton("VOLVER");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnVolverJButton(e);
				}
			});
			{
				cbEstado = new JComboBox<String>();
				cbEstado.setModel(new DefaultComboBoxModel<String>(
						new String[] { "Nuevo Ingreso", "No Reparado", "En Revisi\u00F3n", "Reparado", "Entregado" }));
				cbEstado.setForeground(Color.DARK_GRAY);
				cbEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));
				cbEstado.setFocusable(false);
				cbEstado.setBorder(new LineBorder(new Color(0, 0, 0)));
				cbEstado.setBackground(new Color(245, 245, 245));
				cbEstado.setBounds(312, 60, 160, 35);
				contentPanel.add(cbEstado);
			}
			{
				spObservaciones = new JScrollPane();
				spObservaciones.setBorder(new LineBorder(Color.BLACK, 1, true));
				spObservaciones.setBounds(219, 152, 253, 108);
				contentPanel.add(spObservaciones);
				{
					txtObservaciones = new JTextArea();
					txtObservaciones.setEditable(false);
					txtObservaciones.setForeground(Color.BLACK);
					txtObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
					txtObservaciones.setBackground(new Color(211, 211, 211));
					spObservaciones.setViewportView(txtObservaciones);
				}
			}
			{
				spComentarios = new JScrollPane();
				spComentarios.setBorder(new LineBorder(Color.BLACK, 1, true));
				spComentarios.setBounds(219, 290, 249, 108);
				contentPanel.add(spComentarios);
				{
					txtComentarios = new JTextArea();
					txtComentarios.setForeground(Color.BLACK);
					txtComentarios.setFont(new Font("Tahoma", Font.PLAIN, 15));
					txtComentarios.setBackground(new Color(245, 245, 245));
					spComentarios.setViewportView(txtComentarios);
				}
			}
			{
				btnUpdate = new JButton("ACTUALIZAR");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actionPerformedBtnUpdateJButton(e, d);
					}
				});
				btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnUpdate.setForeground(new Color(220, 220, 220));
				btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnUpdate.setFocusable(false);
				btnUpdate.setBorder(new LineBorder(Color.WHITE));
				btnUpdate.setBackground(new Color(47, 79, 79));
				btnUpdate.setBounds(219, 409, 122, 38);
				contentPanel.add(btnUpdate);
			}
			btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnVolver.setForeground(new Color(220, 220, 220));
			btnVolver.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnVolver.setFocusable(false);
			btnVolver.setBorder(new LineBorder(Color.WHITE));
			btnVolver.setBackground(Color.DARK_GRAY);
			btnVolver.setBounds(346, 409, 122, 37);
			contentPanel.add(btnVolver);
		}

		if (d != null)
			loadDevice(d);
	}

	// EVENTOS

	protected void actionPerformedBtnVolverJButton(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnUpdateJButton(ActionEvent arg0, clsDevice d) {
		Factory dao = Factory.getDAOFactory(
				Factory.MYSQL5);/* Base de datos con la cual trabajar */

		d.setStatus(cbEstado.getSelectedIndex());
		d.setComments(txtComentarios.getText().trim());

		dao.getDeviceDAO().updateDevice(d);

		equipo = true;

		JOptionPane.showMessageDialog(null, "Equipo actualizado !", "Éxito", 1);
		dispose();
	}

	// METODOS

	private void loadDevice(clsDevice d) {
		cbTipo.setSelectedIndex(d.getType());
		cbMarca.setSelectedIndex(d.getBrand());
		txtModelo.setText(d.getModel());
		txtSerie.setText(d.getSerie());
		txtModificacion.setText(d.getChange());
		txtFecha.setText(d.getDate());
		cbEstado.setSelectedIndex(d.getStatus());
		txtObservaciones.setText(d.getObservations());
		txtComentarios.setText(d.getComments());
	}
}
