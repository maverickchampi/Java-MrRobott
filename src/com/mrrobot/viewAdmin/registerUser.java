package com.mrrobot.viewAdmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.mrrobot.dao.Factory;
import com.mrrobot.model.Sesion;
import com.mrrobot.model.clsUser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

public class registerUser extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JLabel lblRegistroDeUsuarios;
	private JTextField txtNombre;
	private JTextField txtUsuario;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JComboBox<String> cbNivel;
	private JLabel lblNombre;
	private JLabel lblEmail;
	private JLabel lblTelfono;
	private JLabel lblUsuario_3;
	private JLabel lblContrasea;
	private JLabel lblNivel;
	private JLabel lblConfirmacin;
	private JButton btnRegistrar;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmacion;

	public static void main(String[] args) {
		try {
			registerUser dialog = new registerUser(null, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public registerUser(JFrame frame, boolean modal) {
		super(frame, modal);
		try {
			setTitle("Registrar Usuario - Sesión de " + Sesion.getSesion().getUser().getNick());
		} catch (Exception e) {
			setTitle("Registrar Usuario - Sesión Prueba");
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
			lblRegistroDeUsuarios = new JLabel("Ingrese los datos del nuevo usuario");
			lblRegistroDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegistroDeUsuarios.setForeground(Color.DARK_GRAY);
			lblRegistroDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblRegistroDeUsuarios.setBounds(50, 20, 394, 26);
			contentPanel.add(lblRegistroDeUsuarios);
		}
		{
			txtNombre = new JTextField();
			txtNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					limitKey(e, txtNombre, 40);
				}
			});
			txtNombre.setForeground(Color.DARK_GRAY);
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtNombre.setColumns(10);
			txtNombre.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtNombre.setBackground(new Color(245, 245, 245));
			txtNombre.setBounds(52, 93, 393, 35);
			contentPanel.add(txtNombre);
		}
		{
			cbNivel = new JComboBox<String>();
			cbNivel.setModel(
					new DefaultComboBoxModel<String>(new String[] { "Administrador", "Capturista", "T\u00E9cnico" }));
			cbNivel.setFocusable(false);
			cbNivel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cbNivel.setForeground(Color.DARK_GRAY);
			cbNivel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cbNivel.setBorder(new LineBorder(new Color(0, 0, 0)));
			cbNivel.setBackground(new Color(245, 245, 245));
			cbNivel.setBounds(51, 173, 188, 35);
			contentPanel.add(cbNivel);
		}
		{
			txtEmail = new JTextField();
			txtEmail.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					limitKey(e, txtEmail, 40);
				}
			});
			txtEmail.setForeground(Color.DARK_GRAY);
			txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtEmail.setColumns(10);
			txtEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtEmail.setBackground(new Color(245, 245, 245));
			txtEmail.setBounds(51, 253, 188, 35);
			contentPanel.add(txtEmail);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					limitKey(e, txtTelefono, 20);
				}
			});
			txtTelefono.setForeground(Color.DARK_GRAY);
			txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtTelefono.setColumns(10);
			txtTelefono.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtTelefono.setBackground(new Color(245, 245, 245));
			txtTelefono.setBounds(52, 333, 187, 35);
			contentPanel.add(txtTelefono);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					limitKey(e, txtUsuario, 20);
				}
			});
			txtUsuario.setForeground(Color.DARK_GRAY);
			txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtUsuario.setColumns(10);
			txtUsuario.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtUsuario.setBackground(new Color(245, 245, 245));
			txtUsuario.setBounds(257, 173, 188, 35);
			contentPanel.add(txtUsuario);
		}
		{
			txtPassword = new JPasswordField();
			txtPassword.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					limitKey(e, txtPassword, 20);
				}
			});
			txtPassword.setForeground(Color.DARK_GRAY);
			txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtPassword.setColumns(10);
			txtPassword.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtPassword.setBackground(new Color(245, 245, 245));
			txtPassword.setBounds(257, 253, 188, 35);
			contentPanel.add(txtPassword);
		}
		{
			txtConfirmacion = new JPasswordField();
			txtConfirmacion.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					limitKey(e, txtConfirmacion, 20);
				}
			});
			txtConfirmacion.setForeground(Color.DARK_GRAY);
			txtConfirmacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtConfirmacion.setColumns(10);
			txtConfirmacion.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtConfirmacion.setBackground(new Color(245, 245, 245));
			txtConfirmacion.setBounds(257, 333, 188, 35);
			contentPanel.add(txtConfirmacion);
		}
		{
			lblNombre = new JLabel("Nombre", SwingConstants.CENTER);
			lblNombre.setForeground(Color.DARK_GRAY);
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNombre.setBounds(51, 67, 394, 15);
			contentPanel.add(lblNombre);
		}
		{
			lblEmail = new JLabel("Email", SwingConstants.CENTER);
			lblEmail.setForeground(Color.DARK_GRAY);
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblEmail.setBounds(50, 227, 189, 15);
			contentPanel.add(lblEmail);
		}
		{
			lblTelfono = new JLabel("Tel\u00E9fono", SwingConstants.CENTER);
			lblTelfono.setForeground(Color.DARK_GRAY);
			lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTelfono.setBounds(51, 307, 189, 15);
			contentPanel.add(lblTelfono);
		}
		{
			lblUsuario_3 = new JLabel("Usuario", SwingConstants.CENTER);
			lblUsuario_3.setForeground(Color.DARK_GRAY);
			lblUsuario_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUsuario_3.setBounds(256, 147, 189, 15);
			contentPanel.add(lblUsuario_3);
		}
		{
			lblContrasea = new JLabel("Contrase\u00F1a", SwingConstants.CENTER);
			lblContrasea.setForeground(Color.DARK_GRAY);
			lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblContrasea.setBounds(256, 227, 189, 15);
			contentPanel.add(lblContrasea);
		}
		{
			lblNivel = new JLabel("Nivel", SwingConstants.CENTER);
			lblNivel.setForeground(Color.DARK_GRAY);
			lblNivel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNivel.setBounds(51, 147, 189, 15);
			contentPanel.add(lblNivel);
		}
		{
			lblConfirmacin = new JLabel("Confirmaci\u00F3n", SwingConstants.CENTER);
			lblConfirmacin.setForeground(Color.DARK_GRAY);
			lblConfirmacin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblConfirmacin.setBounds(256, 307, 189, 15);
			contentPanel.add(lblConfirmacin);
		}
		{
			btnRegistrar = new JButton("REGISTRAR");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actionPerformedBtnRegistrarJButton(arg0);
				}
			});
			btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegistrar.setForeground(new Color(220, 220, 220));
			btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnRegistrar.setFocusable(false);
			btnRegistrar.setBorder(new LineBorder(Color.WHITE));
			btnRegistrar.setBackground(new Color(47, 79, 79));
			btnRegistrar.setBounds(51, 393, 189, 40);
			contentPanel.add(btnRegistrar);
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
			btnVolver.setBounds(257, 393, 188, 40);
			contentPanel.add(btnVolver);
		}

	}

	// EVENTOS

	protected void actionPerformedBtnVolverJButton(ActionEvent e) {
		dispose();
	}

	protected void limitKey(KeyEvent e, JTextField c, int l) {

		// VERIFICA QUE NO PASE CARACTERES
		if (c.getText().length() >= l) {
			JOptionPane.showMessageDialog(null, "Introduzca menos de " + l + "  caracteres", "Advertencia!", 2);
			e.consume();
		}
	}

	@SuppressWarnings("deprecation")
	protected void actionPerformedBtnRegistrarJButton(ActionEvent arg0) {
		if (!txtNombre.getText().trim().isEmpty()) {
			String patron = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			if (Pattern.matches(patron, txtEmail.getText().trim())) {
				if (txtTelefono.getText().trim().length() > 4) {
					if (txtUsuario.getText().trim().length() > 3) {
						if (txtPassword.getText().trim().length() > 3) {
							if (txtConfirmacion.getText().equals(txtPassword.getText())) {

								Factory dao = Factory.getDAOFactory(Factory.MYSQL5);
								clsUser u = new clsUser();
								u.setIdUser(0);
								u.setName(txtNombre.getText().trim());
								u.setEmail(txtEmail.getText().trim());
								u.setPhone(txtTelefono.getText().trim());
								u.setNick(txtUsuario.getText().trim());
								u.setPass(txtPassword.getText().trim());
								u.setStatus(true);
								u.setNivel(cbNivel.getSelectedIndex());
								try {
									u.setRegistered(Sesion.getSesion().getUser().getName());
								} catch (Exception e) {
									u.setRegistered("Prueba");
								}
								dao.getUserDAO().addUser(u);
								JOptionPane.showMessageDialog(null, "Usuario registrado !", "Éxito", 1);
								dispose();

							} else
								changeColor(txtConfirmacion, Color.RED, "Confirmación errónea");
						} else
							changeColor(txtPassword, Color.RED, "Ingrese una contraseña más larga");
					} else
						changeColor(txtUsuario, Color.RED, "Ingrese un nombre de usuario más largo");
				} else
					changeColor(txtTelefono, Color.RED, "Ingrese un número de teléfono válido");
			} else
				changeColor(txtEmail, Color.RED, "Ingrese un correo válido");
		} else
			changeColor(txtNombre, Color.RED, "Ingrese un nombre válido");

	}

	// METODOS

	private void changeColor(JTextField txt, Color bg, String msg) {
		txt.setBackground(bg);
		JOptionPane.showMessageDialog(null, msg, "Advertencia !", 2);
		txt.setBackground(new Color(245, 245, 245));
		txt.requestFocus();
	}
}
