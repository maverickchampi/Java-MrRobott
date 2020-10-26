package com.mrrobot.viewAdmin;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.mrrobot.dao.Factory;
import com.mrrobot.model.Sesion;
import com.mrrobot.model.clsUser;
import com.mrrobot.viewCapturist.sesion_capturist;
import com.mrrobot.viewTechnical.sesion_technical;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class index extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel logo;
	private JTextField txtUsuario;
	private JButton btnEntrar;
	private JPasswordField txtPassword;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel l_etiqueta;
	private JLabel lblRecovery;
	private JLabel lblCambioDeCorreo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public index() {
		setTitle("Login - Bienvenido a MrRobott");
		setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/com/mrrobot/images/icono.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			logo = new JLabel("");
			logo.setIcon(new ImageIcon(index.class.getResource("/com/mrrobot/images/index.logo.png")));
			logo.setBounds(47, 22, 250, 170);
			contentPane.add(logo);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					limitKey(e, txtUsuario);
				}
			});
			txtUsuario.setForeground(Color.DARK_GRAY);
			txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtUsuario.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtUsuario.setBackground(new Color(245, 245, 245));
			txtUsuario.setBounds(78, 225, 188, 35);
			contentPane.add(txtUsuario);
			txtUsuario.setColumns(10);
		}
		{
			txtPassword = new JPasswordField();
			txtPassword.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					limitKey(e, txtPassword);
				}
			});
			txtPassword.setForeground(Color.DARK_GRAY);
			txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtPassword.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtPassword.setBackground(new Color(245, 245, 245));
			txtPassword.setColumns(10);
			txtPassword.setBounds(78, 295, 188, 35);
			contentPane.add(txtPassword);
		}
		{
			lblUsuario = new JLabel("Usuario", SwingUtilities.CENTER);
			lblUsuario.setForeground(Color.DARK_GRAY);
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUsuario.setBounds(77, 205, 189, 15);
			contentPane.add(lblUsuario);
		}
		{
			lblContrasea = new JLabel("Contrase\u00F1a", SwingConstants.CENTER);
			lblContrasea.setForeground(Color.DARK_GRAY);
			lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblContrasea.setBounds(77, 275, 189, 15);
			contentPane.add(lblContrasea);
		}
		{
			btnEntrar = new JButton("ACCEDER");
			btnEntrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actionPerformedBtnEntrarJButton(arg0);
				}
			});
			btnEntrar.setBorder(new LineBorder(Color.WHITE));
			btnEntrar.setFocusable(false);
			btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnEntrar.setForeground(new Color(220, 220, 220));
			btnEntrar.setBackground(Color.DARK_GRAY);
			btnEntrar.setBounds(78, 345, 188, 40);
			contentPane.add(btnEntrar);
		}
		{
			lblRecovery = new JLabel("\u00BFOlvidaste tu contrase\u00F1a?");
			lblRecovery.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					mouseEnteredLblNewLabelJLabel(arg0, lblRecovery);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					mouseExitedLblNewLabelJLabel(e, lblRecovery);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					mousePressedLblRecoveryJLabel(e);
				}
			});
			lblRecovery.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblRecovery.setForeground(Color.BLACK);
			lblRecovery.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblRecovery.setHorizontalAlignment(SwingConstants.CENTER);
			lblRecovery.setBounds(78, 395, 188, 14);
			contentPane.add(lblRecovery);
		}
		{
			lblCambioDeCorreo = new JLabel("Cambio de correo");
			lblCambioDeCorreo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblCambioDeCorreo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					mouseEnteredLblNewLabelJLabel(arg0, lblCambioDeCorreo);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					mouseExitedLblNewLabelJLabel(e, lblCambioDeCorreo);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					mousePressedLblCambioDeCorreoJLabel(e);
				}
			});
			lblCambioDeCorreo.setHorizontalAlignment(SwingConstants.CENTER);
			lblCambioDeCorreo.setForeground(Color.BLACK);
			lblCambioDeCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCambioDeCorreo.setBounds(78, 410, 188, 14);
			contentPane.add(lblCambioDeCorreo);
		}
		{
			l_etiqueta = new JLabel("Created by Maverick \u00A9");
			l_etiqueta.setForeground(Color.DARK_GRAY);
			l_etiqueta.setFont(new Font("Tahoma", Font.BOLD, 11));
			l_etiqueta.setBounds(195, 440, 130, 14);
			contentPane.add(l_etiqueta);
		}
	}

	// EVENTOS

	protected void actionPerformedBtnEntrarJButton(ActionEvent arg0) {
		String nickname = txtUsuario.getText();
		@SuppressWarnings("deprecation")
		String pass = txtPassword.getText();

		Factory dao = Factory.getDAOFactory(
				Factory.MYSQL5);/* Base de datos con la cual trabajar */
		clsUser u = dao.getUserDAO().searchUser(nickname);

		if (!nickname.isEmpty()) {
			if (!pass.isEmpty()) {
				if (u != null) {
					if (pass.equals(u.getPass())) {
						if (u.isStatus()) {

							Sesion.getSesion()
									.setUser(u); /* patron singleton - sesion */

							switch (u.getNivel()) {
							case 0:
								new sesion_admin().setVisible(true);
								break;
							case 1:
								new sesion_capturist(this,true).setVisible(true);
								break;
							default:
								new sesion_technical(this, true).setVisible(true);
							}

							dispose();

						} else
							JOptionPane.showMessageDialog(null, "Cuenta Inactiva", "Consulte con un administrador", 2);
					} else
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Intentelo nuevamente", 2);
				} else
					JOptionPane.showMessageDialog(null, "Usuario no existe", "Intentelo nuevamente", 2);
			} else
				JOptionPane.showMessageDialog(null, "Contraseña no ingresada", "Intentelo nuevamente", 2);
		} else
			JOptionPane.showMessageDialog(null, "Usuario no ingresado", "Intentelo nuevamente", 2);

	}

	protected void limitKey(KeyEvent e, JTextField c) {

		// VERIFICA QUE NO PASE CARACTERES
		if (c.getText().length() >= 20) {
			JOptionPane.showMessageDialog(null, "Introduzca menos de 20 caracteres", "Advertencia!", 2);
			e.consume();
		}
	}

	protected void mouseEnteredLblNewLabelJLabel(MouseEvent e, JLabel lbl) {
		lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
	}

	protected void mouseExitedLblNewLabelJLabel(MouseEvent e, JLabel lbl) {
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
	}

	protected void mousePressedLblRecoveryJLabel(MouseEvent e) {
		new recoveryPass(this, true).setVisible(true);
	}

	protected void mousePressedLblCambioDeCorreoJLabel(MouseEvent e) {
		new recoveryEmail(this, true).setVisible(true);
	}
}
