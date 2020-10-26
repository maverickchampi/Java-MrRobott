package com.mrrobot.viewCapturist;

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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

import com.mrrobot.dao.Factory;
import com.mrrobot.model.Sesion;
import com.mrrobot.model.clsClient;
import com.mrrobot.model.clsDevice;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class registerDevice extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JLabel lblIngreseDatosDel;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblTipo;
	private JComboBox<String> cbTipo;
	private JLabel lblMarca;
	private JComboBox<String> cbMarca;
	private JTextField txtModelo;
	private JLabel lblModelo;
	private JTextField txtSerie;
	private JLabel lblSerie;
	private JButton btnRegistrarEquipo;
	private JLabel lblObservciones;
	private JScrollPane scrollPane;
	private JTextArea txtObservaciones;

	public static void main(String[] args) {
		try {
			registerDevice dialog = new registerDevice(null, false, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public registerDevice(JDialog frame, boolean modal, clsClient c) {
		super(frame, modal);
		try {
			setTitle("Registrar nuevo equipo para " + c.getName() + " - Sesion de "
					+ Sesion.getSesion().getUser().getNick());
		} catch (Exception e) {
			setTitle("Registrar nuevo equipo");
		}

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(sesion_capturist.class.getResource("/com/mrrobot/images/icono.png")));
		setBounds(100, 100, 500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(220, 220, 220));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblIngreseDatosDel = new JLabel("Ingrese datos del equipo");
			lblIngreseDatosDel.setHorizontalAlignment(SwingConstants.CENTER);
			lblIngreseDatosDel.setForeground(Color.DARK_GRAY);
			lblIngreseDatosDel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblIngreseDatosDel.setBounds(26, 21, 442, 20);
			contentPanel.add(lblIngreseDatosDel);
		}
		{
			lblNombre = new JLabel("Nombre Cliente", SwingConstants.CENTER);
			lblNombre.setForeground(Color.DARK_GRAY);
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNombre.setBounds(26, 72, 189, 15);
			contentPanel.add(lblNombre);
		}
		{
			lblTipo = new JLabel("Tipo", SwingConstants.CENTER);
			lblTipo.setForeground(Color.DARK_GRAY);
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTipo.setBounds(26, 144, 189, 15);
			contentPanel.add(lblTipo);
		}
		{
			lblMarca = new JLabel("Marca", SwingConstants.CENTER);
			lblMarca.setForeground(Color.DARK_GRAY);
			lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMarca.setBounds(26, 216, 189, 15);
			contentPanel.add(lblMarca);
		}
		{
			lblModelo = new JLabel("Modelo", SwingConstants.CENTER);
			lblModelo.setForeground(Color.DARK_GRAY);
			lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblModelo.setBounds(26, 288, 189, 15);
			contentPanel.add(lblModelo);
		}
		{
			lblSerie = new JLabel("Serie", SwingConstants.CENTER);
			lblSerie.setForeground(Color.DARK_GRAY);
			lblSerie.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblSerie.setBounds(26, 360, 189, 15);
			contentPanel.add(lblSerie);
		}
		{
			lblObservciones = new JLabel("Observaciones / reporte", SwingConstants.CENTER);
			lblObservciones.setForeground(Color.DARK_GRAY);
			lblObservciones.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblObservciones.setBounds(268, 74, 200, 15);
			contentPanel.add(lblObservciones);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setForeground(Color.DARK_GRAY);
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtNombre.setColumns(10);
			txtNombre.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtNombre.setBackground(new Color(245, 245, 245));
			txtNombre.setBounds(26, 98, 188, 35);
			contentPanel.add(txtNombre);
		}
		{
			cbTipo = new JComboBox<String>();
			cbTipo.setModel(new DefaultComboBoxModel<String>(
					new String[] { "Celular", "Laptop", "Computadora", "Tablet", "Impresora" }));
			cbTipo.setForeground(Color.DARK_GRAY);
			cbTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cbTipo.setFocusable(false);
			cbTipo.setBorder(new LineBorder(new Color(0, 0, 0)));
			cbTipo.setBackground(new Color(245, 245, 245));
			cbTipo.setBounds(27, 170, 188, 35);
			contentPanel.add(cbTipo);
		}
		{
			cbMarca = new JComboBox<String>();
			cbMarca.setModel(new DefaultComboBoxModel<String>(new String[] {"Acer", "Alcatel", "Alienware", "Apple", "Asus", "BlackBerry", "Canon", "Dell", "Epson", "Honor", "HP", "Huawei", "Lenovo", "LG", "Microsoft", "Motorola", "MSI", "Nokia", "OnePlus", "OPPO", "Razer", "Realme", "Samsung", "Sony", "Toshiba", "Vivo", "Xiaomi", "ZTE"}));
			cbMarca.setForeground(Color.DARK_GRAY);
			cbMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cbMarca.setFocusable(false);
			cbMarca.setBorder(new LineBorder(new Color(0, 0, 0)));
			cbMarca.setBackground(new Color(245, 245, 245));
			cbMarca.setBounds(26, 242, 188, 35);
			contentPanel.add(cbMarca);
		}
		{
			txtModelo = new JTextField();
			txtModelo.setForeground(Color.DARK_GRAY);
			txtModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtModelo.setColumns(10);
			txtModelo.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtModelo.setBackground(new Color(245, 245, 245));
			txtModelo.setBounds(26, 314, 188, 35);
			contentPanel.add(txtModelo);
		}
		{
			txtSerie = new JTextField();
			txtSerie.setForeground(Color.DARK_GRAY);
			txtSerie.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtSerie.setColumns(10);
			txtSerie.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtSerie.setBackground(new Color(245, 245, 245));
			txtSerie.setBounds(26, 386, 188, 35);
			contentPanel.add(txtSerie);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBorder(new LineBorder(Color.BLACK, 1, true));
			scrollPane.setBounds(268, 98, 200, 205);
			contentPanel.add(scrollPane);
			{
				txtObservaciones = new JTextArea();
				txtObservaciones.setBackground(new Color(245, 245, 245));
				txtObservaciones.setForeground(Color.BLACK);
				txtObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
				scrollPane.setViewportView(txtObservaciones);
			}
		}
		{
			btnRegistrarEquipo = new JButton("REGISTRAR EQUIPO");
			btnRegistrarEquipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnRegistrarEquipoJButton(e, c);
				}
			});
			btnRegistrarEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegistrarEquipo.setForeground(new Color(220, 220, 220));
			btnRegistrarEquipo.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnRegistrarEquipo.setFocusable(false);
			btnRegistrarEquipo.setBorder(new LineBorder(Color.WHITE));
			btnRegistrarEquipo.setBackground(new Color(47, 79, 79));
			btnRegistrarEquipo.setBounds(268, 332, 200, 40);
			contentPanel.add(btnRegistrarEquipo);
		}
		{
			btnVolver = new JButton("VOLVER");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnVolverJButton(e);
				}
			});
			btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnVolver.setForeground(new Color(220, 220, 220));
			btnVolver.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnVolver.setFocusable(false);
			btnVolver.setBorder(new LineBorder(Color.WHITE));
			btnVolver.setBackground(Color.DARK_GRAY);
			btnVolver.setBounds(268, 383, 200, 40);
			contentPanel.add(btnVolver);
		}

		if (c != null)
			txtNombre.setText(c.getName());
	}

	// EVENTOS

	protected void actionPerformedBtnVolverJButton(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnRegistrarEquipoJButton(ActionEvent e, clsClient c) {
		if (!txtModelo.getText().trim().isEmpty()) {
			if (!txtSerie.getText().trim().isEmpty()) {
				if (!txtObservaciones.getText().trim().isEmpty()) {

					Factory dao = Factory.getDAOFactory(Factory.MYSQL5);
					clsDevice d = new clsDevice();
					d.setIdDevice(0);
					d.setIdClient(c.getidClient());
					d.setType(cbTipo.getSelectedIndex());
					d.setBrand(cbMarca.getSelectedIndex());
					d.setModel(txtModelo.getText().trim());
					d.setSerie(txtSerie.getText().trim());
					try {
						d.setChange(Sesion.getSesion().getUser().getName());
					} catch (Exception ex) {
						d.setChange("Prueba");
					}
					d.setObservations(txtObservaciones.getText().trim());
					d.setComments("");
					d.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
					d.setStatus(0);

					dao.getDeviceDAO().addDevice(d);

					informationClient.equipo = true;

					JOptionPane.showMessageDialog(null, "Equipo registrado !", "Éxito", 1);
					dispose();

				} else
					changeColor(txtObservaciones, "Ingrese observación");
			} else
				changeColor(txtSerie, "Ingrese el número de serie de su equipo");
		} else
			changeColor(txtModelo, "Ingrese el modelo de su equipo");

	}

	// METODOS

	private void changeColor(JTextField txt, String msg) {
		txt.setBackground(Color.RED);
		JOptionPane.showMessageDialog(null, msg, "Advertencia !", 2);
		txt.setBackground(new Color(245, 245, 245));
		txt.requestFocus();
	}

	private void changeColor(JTextArea txt, String msg) {
		txt.setBackground(Color.RED);
		JOptionPane.showMessageDialog(null, msg, "Advertencia !", 2);
		txt.setBackground(new Color(245, 245, 245));
		txt.requestFocus();
	}
}
