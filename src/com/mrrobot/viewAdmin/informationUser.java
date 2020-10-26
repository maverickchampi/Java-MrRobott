package com.mrrobot.viewAdmin;

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
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.mrrobot.dao.Factory;
import com.mrrobot.model.Sesion;
import com.mrrobot.model.clsUser;

public class informationUser extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JLabel lblInformacinDeUsuario;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtUser;
	private JTextField txtRegistered;
	private JComboBox<String> cbNivel;
	private JComboBox<String> cbStatus;
	private JButton btnUpdate;
	private JLabel lblUsuario;
	private JLabel lblUsuario_1;
	private JLabel lblUsuario_2;
	private JLabel lblUsuario_3;
	private JLabel lblUsuario_4;
	private JLabel lblUsuario_5;
	private JLabel lblUsuario_6;
	protected static boolean info = false;

	public static void main(String[] args) {
		try {
			informationUser dialog = new informationUser(null, false, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public informationUser(JDialog frame, boolean modal, clsUser u) {
		super(frame, modal);
		try {
			setTitle("Información de usuario - Sesión de " + Sesion.getSesion().getUser().getNick());
		} catch (Exception e) {
			setTitle("Información de usuario - Sesión Prueba");
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/com/mrrobot/images/icono.png")));
		setBounds(100, 100, 500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(220, 220, 220));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblInformacinDeUsuario = new JLabel("Informaci\u00F3n de usuario");
			lblInformacinDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			lblInformacinDeUsuario.setForeground(Color.DARK_GRAY);
			lblInformacinDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblInformacinDeUsuario.setBounds(50, 21, 394, 20);
			contentPanel.add(lblInformacinDeUsuario);
		}
		{
			txtName = new JTextField();
			txtName.setForeground(Color.DARK_GRAY);
			txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtName.setColumns(10);
			txtName.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtName.setBackground(new Color(245, 245, 245));
			txtName.setBounds(51, 89, 188, 35);
			contentPanel.add(txtName);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setEditable(false);
			txtEmail.setForeground(Color.DARK_GRAY);
			txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtEmail.setColumns(10);
			txtEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtEmail.setBackground(new Color(245, 245, 245));
			txtEmail.setBounds(256, 171, 188, 35);
			contentPanel.add(txtEmail);
		}
		{
			txtPhone = new JTextField();
			txtPhone.setForeground(Color.DARK_GRAY);
			txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtPhone.setColumns(10);
			txtPhone.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtPhone.setBackground(new Color(245, 245, 245));
			txtPhone.setBounds(50, 329, 188, 35);
			contentPanel.add(txtPhone);
		}
		{
			txtUser = new JTextField();
			txtUser.setEditable(false);
			txtUser.setForeground(Color.DARK_GRAY);
			txtUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtUser.setColumns(10);
			txtUser.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtUser.setBackground(new Color(245, 245, 245));
			txtUser.setBounds(257, 89, 188, 35);
			contentPanel.add(txtUser);
		}
		{
			txtRegistered = new JTextField();
			txtRegistered.setEditable(false);
			txtRegistered.setForeground(Color.DARK_GRAY);
			txtRegistered.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtRegistered.setColumns(10);
			txtRegistered.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtRegistered.setBackground(new Color(245, 245, 245));
			txtRegistered.setBounds(256, 249, 188, 35);
			contentPanel.add(txtRegistered);
		}
		{
			cbNivel = new JComboBox<String>();
			cbNivel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cbNivel.setModel(
					new DefaultComboBoxModel<String>(new String[] { "Administrador", "Capturista", "T\u00E9cnico" }));
			cbNivel.setForeground(Color.DARK_GRAY);
			cbNivel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cbNivel.setFocusable(false);
			cbNivel.setBorder(new LineBorder(new Color(0, 0, 0)));
			cbNivel.setBackground(new Color(245, 245, 245));
			cbNivel.setBounds(51, 171, 188, 35);
			contentPanel.add(cbNivel);
		}
		{
			cbStatus = new JComboBox<String>();
			cbStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cbStatus.setModel(new DefaultComboBoxModel<String>(new String[] { "Activo", "Inactivo" }));
			cbStatus.setForeground(Color.DARK_GRAY);
			cbStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cbStatus.setFocusable(false);
			cbStatus.setBorder(new LineBorder(new Color(0, 0, 0)));
			cbStatus.setBackground(new Color(245, 245, 245));
			cbStatus.setBounds(50, 249, 188, 35);
			contentPanel.add(cbStatus);
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
			btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnVolver.setFocusable(false);
			btnVolver.setBorder(new LineBorder(Color.WHITE));
			btnVolver.setBackground(Color.DARK_GRAY);
			btnVolver.setBounds(257, 390, 188, 38);
			contentPanel.add(btnVolver);
		}
		{
			btnUpdate = new JButton("ACTUALIZAR");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnUpdateJButton(e, u);
				}
			});
			btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnUpdate.setForeground(new Color(220, 220, 220));
			btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnUpdate.setFocusable(false);
			btnUpdate.setBorder(new LineBorder(Color.WHITE));
			btnUpdate.setBackground(new Color(47, 79, 79));
			btnUpdate.setBounds(51, 390, 188, 38);
			contentPanel.add(btnUpdate);
		}
		{
			lblUsuario = new JLabel("Nombre", SwingConstants.CENTER);
			lblUsuario.setForeground(Color.DARK_GRAY);
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUsuario.setBounds(51, 63, 189, 15);
			contentPanel.add(lblUsuario);
		}
		{
			lblUsuario_1 = new JLabel("Usuario", SwingConstants.CENTER);
			lblUsuario_1.setForeground(Color.DARK_GRAY);
			lblUsuario_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUsuario_1.setBounds(257, 65, 189, 15);
			contentPanel.add(lblUsuario_1);
		}
		{
			lblUsuario_2 = new JLabel("Email ", SwingConstants.CENTER);
			lblUsuario_2.setForeground(Color.DARK_GRAY);
			lblUsuario_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUsuario_2.setBounds(255, 145, 189, 15);
			contentPanel.add(lblUsuario_2);
		}
		{
			lblUsuario_3 = new JLabel("Registrado por", SwingConstants.CENTER);
			lblUsuario_3.setForeground(Color.DARK_GRAY);
			lblUsuario_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUsuario_3.setBounds(256, 218, 189, 20);
			contentPanel.add(lblUsuario_3);
		}
		{
			lblUsuario_4 = new JLabel("Tel\u00E9fono", SwingConstants.CENTER);
			lblUsuario_4.setForeground(Color.DARK_GRAY);
			lblUsuario_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUsuario_4.setBounds(50, 303, 189, 15);
			contentPanel.add(lblUsuario_4);
		}
		{
			lblUsuario_5 = new JLabel("Nivel", SwingConstants.CENTER);
			lblUsuario_5.setForeground(Color.DARK_GRAY);
			lblUsuario_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUsuario_5.setBounds(50, 145, 189, 15);
			contentPanel.add(lblUsuario_5);
		}
		{
			lblUsuario_6 = new JLabel("Estado", SwingConstants.CENTER);
			lblUsuario_6.setForeground(Color.DARK_GRAY);
			lblUsuario_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUsuario_6.setBounds(50, 223, 189, 15);
			contentPanel.add(lblUsuario_6);
		}
		if (u != null)
			loadUser(u);
	}

	// EVENTOS

	protected void actionPerformedBtnVolverJButton(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnUpdateJButton(ActionEvent arg0, clsUser u) {
		if (!txtName.getText().trim().isEmpty()) {
			String patron = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			if (Pattern.matches(patron, txtEmail.getText().trim())) {
				if (txtPhone.getText().trim().length() > 4) {

					Factory dao = Factory.getDAOFactory(Factory.MYSQL5);

					u.setName(txtName.getText().trim());
					u.setEmail(txtEmail.getText().trim());
					u.setPhone(txtPhone.getText().trim());
					if (cbStatus.getSelectedIndex() == 0)
						u.setStatus(true);
					else
						u.setStatus(false);
					u.setNivel(cbNivel.getSelectedIndex());

					info = true;/* sirve para actualizar tabla de gestion */

					dao.getUserDAO().updateUser(u);
					JOptionPane.showMessageDialog(null, "Usuario actualizado !", "Éxito", 1);
					dispose();

				} else
					changeColor(txtPhone, Color.RED, "Ingrese un número de teléfono válido");
			} else
				changeColor(txtEmail, Color.RED, "Ingrese un correo válido");
		} else
			changeColor(txtName, Color.RED, "Ingrese un nombre válido");

	}
	// METODOS

	private void loadUser(clsUser u) {
		txtUser.setText(u.getNick());
		txtEmail.setText(u.getEmail());
		txtPhone.setText(u.getPhone());
		txtName.setText(u.getName());
		txtRegistered.setText(u.getRegistered());
		cbNivel.setSelectedIndex(u.getNivel());
		int estado = 1;
		if (u.isStatus())
			estado = 0;
		cbStatus.setSelectedIndex(estado);
	}

	private void changeColor(JTextField txt, Color bg, String msg) {
		txt.setBackground(bg);
		JOptionPane.showMessageDialog(null, msg, "Advertencia !", 2);
		txt.setBackground(new Color(245, 245, 245));
		txt.requestFocus();
	}

}
