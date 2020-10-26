package com.mrrobot.viewAdmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.mrrobot.dao.Factory;
import com.mrrobot.model.clsUser;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class recoveryPass extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JButton btnEnviarCdigo;
	private JLabel lblContrasea;
	private JPasswordField txtPassword;
	private JLabel lblConfirmacin;
	private JPasswordField txtConfirmation;
	private JButton btnCambiar;
	private JButton btnValidar;
	private JTextField txtCode;
	private JLabel lblIngreseCdigo;
	private JButton btnReenviar;

	private String nick, correo, code;
	
	public static void main(String[] args) {
		try {
			recoveryPass dialog = new recoveryPass(null, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public recoveryPass(JFrame frame, boolean modal) {
		super(frame, modal);
		setTitle("Recuperación de contraseña");
		setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/com/mrrobot/images/icono.png")));
		setBounds(100, 100, 350, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(220, 220, 220));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblCorreo = new JLabel("Ingrese correo", SwingConstants.CENTER);
			lblCorreo.setForeground(Color.DARK_GRAY);
			lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCorreo.setBounds(79, 11, 189, 19);
			contentPanel.add(lblCorreo);
		}
		{
			lblContrasea = new JLabel("Ingrese nueva contrase\u00F1a", SwingConstants.CENTER);
			lblContrasea.setForeground(Color.LIGHT_GRAY);
			lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblContrasea.setBounds(61, 276, 225, 15);
			contentPanel.add(lblContrasea);
		}
		{
			lblConfirmacin = new JLabel("Confirmaci\u00F3n", SwingConstants.CENTER);
			lblConfirmacin.setForeground(Color.LIGHT_GRAY);
			lblConfirmacin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblConfirmacin.setBounds(61, 339, 225, 15);
			contentPanel.add(lblConfirmacin);
		}
		{
			lblIngreseCdigo = new JLabel("Ingrese c\u00F3digo", SwingConstants.CENTER);
			lblIngreseCdigo.setForeground(Color.LIGHT_GRAY);
			lblIngreseCdigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblIngreseCdigo.setBounds(80, 142, 189, 19);
			contentPanel.add(lblIngreseCdigo);
		}
		{
			txtCorreo = new JTextField();
			txtCorreo.setForeground(Color.DARK_GRAY);
			txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtCorreo.setColumns(10);
			txtCorreo.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtCorreo.setBackground(new Color(245, 245, 245));
			txtCorreo.setBounds(61, 33, 225, 35);
			contentPanel.add(txtCorreo);
		}
		{
			txtCode = new JTextField();
			txtCode.setEditable(false);
			txtCode.setForeground(Color.DARK_GRAY);
			txtCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtCode.setColumns(10);
			txtCode.setBorder(new LineBorder(Color.GRAY, 1, true));
			txtCode.setBackground(Color.LIGHT_GRAY);
			txtCode.setBounds(62, 164, 225, 35);
			contentPanel.add(txtCode);
		}
		{
			txtPassword = new JPasswordField();
			txtPassword.setEditable(false);
			txtPassword.setForeground(Color.DARK_GRAY);
			txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtPassword.setColumns(10);
			txtPassword.setBorder(new LineBorder(Color.GRAY, 1, true));
			txtPassword.setBackground(Color.LIGHT_GRAY);
			txtPassword.setBounds(63, 295, 224, 35);
			contentPanel.add(txtPassword);
		}
		{
			txtConfirmation = new JPasswordField();
			txtConfirmation.setEditable(false);
			txtConfirmation.setForeground(Color.DARK_GRAY);
			txtConfirmation.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtConfirmation.setColumns(10);
			txtConfirmation.setBorder(new LineBorder(Color.GRAY, 1, true));
			txtConfirmation.setBackground(Color.LIGHT_GRAY);
			txtConfirmation.setBounds(63, 357, 224, 35);
			contentPanel.add(txtConfirmation);
		}
		{
			btnEnviarCdigo = new JButton("ENVIAR C\u00D3DIGO");
			btnEnviarCdigo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnEnviarCdigoJButton(e);
				}
			});
			btnEnviarCdigo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEnviarCdigo.setForeground(new Color(220, 220, 220));
			btnEnviarCdigo.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnEnviarCdigo.setFocusable(false);
			btnEnviarCdigo.setBorder(new LineBorder(Color.WHITE));
			btnEnviarCdigo.setBackground(Color.DARK_GRAY);
			btnEnviarCdigo.setBounds(62, 74, 111, 40);
			contentPanel.add(btnEnviarCdigo);
		}
		{
			btnValidar = new JButton("VALIDAR");
			btnValidar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnValidarJButton(e);
				}
			});
			btnValidar.setEnabled(false);
			btnValidar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnValidar.setForeground(new Color(220, 220, 220));
			btnValidar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnValidar.setFocusable(false);
			btnValidar.setBorder(new LineBorder(Color.WHITE));
			btnValidar.setBackground(Color.LIGHT_GRAY);
			btnValidar.setBounds(62, 206, 111, 40);
			contentPanel.add(btnValidar);
		}
		{
			btnReenviar = new JButton("REENVIAR");
			btnReenviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actionPerformedBtnReenviarJButton(arg0);
				}
			});
			btnReenviar.setEnabled(false);
			btnReenviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnReenviar.setForeground(new Color(220, 220, 220));
			btnReenviar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnReenviar.setFocusable(false);
			btnReenviar.setBorder(new LineBorder(Color.WHITE));
			btnReenviar.setBackground(Color.LIGHT_GRAY);
			btnReenviar.setBounds(175, 74, 111, 40);
			contentPanel.add(btnReenviar);
		}
		{
			btnCambiar = new JButton("ACTUALIZAR");
			btnCambiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCambiarJButton(e);
				}
			});
			btnCambiar.setEnabled(false);
			btnCambiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnCambiar.setForeground(new Color(220, 220, 220));
			btnCambiar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnCambiar.setFocusable(false);
			btnCambiar.setBorder(new LineBorder(Color.WHITE));
			btnCambiar.setBackground(Color.LIGHT_GRAY);
			btnCambiar.setBounds(62, 403, 111, 40);
			contentPanel.add(btnCambiar);
		}

	}

	// EVENTOS

	protected void actionPerformedBtnEnviarCdigoJButton(ActionEvent e) {
		Factory dao = Factory
				.getDAOFactory(Factory.MYSQL5);/* Bd con la cual trabajar */
		List<clsUser> u = dao.getUserDAO().listadoUser();

		boolean ex = false;
		correo = txtCorreo.getText().trim();

		for (clsUser x : u)
			if (x.getEmail().equals(correo)) {
				ex = true;
				nick = x.getNick();
			}

		if (ex) {
			sendCode(correo);
			blockone();
		} else
			JOptionPane.showMessageDialog(null, "Correo no registrado en ninguna cuenta", "Intentelo nuevamente", 2);

	}

	protected void actionPerformedBtnReenviarJButton(ActionEvent arg0) {
		sendCode(correo);
	}

	protected void actionPerformedBtnValidarJButton(ActionEvent e) {
		if (txtCode.getText().equals(code)) {
			blocktwo();
		} else
			JOptionPane.showMessageDialog(null, "Código inválido", "Intentelo nuevamente", 2);
	}

	@SuppressWarnings("deprecation")
	protected void actionPerformedBtnCambiarJButton(ActionEvent e) {
		if (txtPassword.getText().trim().length() > 3) {
			if (txtConfirmation.getText().equals(txtPassword.getText())) {

				Factory dao = Factory.getDAOFactory(
						Factory.MYSQL5);/* Bd con la cual trabajar */
				clsUser u = dao.getUserDAO().searchUser(nick);

				u.setPass(txtPassword.getText().trim());

				dao.getUserDAO().updateUser(u);
				JOptionPane.showMessageDialog(null, "Cambio de contraseña exitoso", "Éxito", 1);
				dispose();

			} else
				JOptionPane.showMessageDialog(null, "Confirmación errónea", "Intentelo nuevamente", 2);
		} else
			JOptionPane.showMessageDialog(null, "Ingrese una contraseña más larga", "Intentelo nuevamente", 2);
	}

	// METODOS

	private void sendCode(String email) {

		// PROPIEDADES
		Properties propiedades = new Properties();
		propiedades.put("mail.smtp.auth", "true");
		propiedades.put("mail.smtp.starttls.enable", "true");
		propiedades.put("mail.smtp.host", "smtp.gmail.com");
		propiedades.put("mail.smtp.port", "587");

		// SESION DEL CORREO REMITENTE
		Session sesion = Session.getDefaultInstance(propiedades, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("idk.mrrobot@gmail.com", "Mrrobot2020");
			}
		});

		// ENVIO DEL MENSAJE
		try {
			code = randomCode();

			MimeMessage message = new MimeMessage(sesion);
			message.setFrom(new InternetAddress("idk.mrrobot@gmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("Cambio de contraseña - MrRobot");
			message.setText("Este es su código para el cambio de contraseña :\t" + code);
			Transport.send(message);
			JOptionPane.showMessageDialog(null, "Se ha enviado código", "Revise su bandeja de correo", 1);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error al enviar", "Intentelo nuevamente", 0);
		}
	}

	private String randomCode() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		StringBuilder sb = new StringBuilder(8);
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	private void blockone() {
		btnEnviarCdigo.setBackground(Color.LIGHT_GRAY);
		btnEnviarCdigo.setEnabled(false);

		txtCorreo.setBackground(Color.LIGHT_GRAY);
		txtCorreo.setEditable(false);
		txtCorreo.setForeground(Color.GRAY);
		txtCorreo.setBorder(new LineBorder(Color.GRAY));

		txtCode.setBackground(new Color(245, 245, 245));
		txtCode.setEditable(true);
		txtCode.requestFocus();
		txtCode.setBorder(new LineBorder(new Color(0, 0, 0)));

		lblCorreo.setForeground(Color.LIGHT_GRAY);
		lblIngreseCdigo.setForeground(Color.DARK_GRAY);

		btnReenviar.setBackground(Color.DARK_GRAY);
		btnValidar.setBackground(Color.DARK_GRAY);
		btnReenviar.setEnabled(true);
		btnValidar.setEnabled(true);
	}

	private void blocktwo() {
		btnValidar.setEnabled(false);
		btnReenviar.setEnabled(false);
		btnValidar.setBackground(Color.LIGHT_GRAY);
		btnReenviar.setBackground(Color.LIGHT_GRAY);
		lblIngreseCdigo.setForeground(Color.LIGHT_GRAY);

		txtCode.setBackground(Color.LIGHT_GRAY);
		txtCode.setEditable(false);
		txtCode.setForeground(Color.GRAY);
		txtCode.setBorder(new LineBorder(Color.GRAY));

		lblContrasea.setForeground(Color.DARK_GRAY);
		lblConfirmacin.setForeground(Color.DARK_GRAY);

		txtPassword.setBackground(new Color(245, 245, 245));
		txtPassword.setEditable(true);
		txtPassword.requestFocus();
		txtPassword.setBorder(new LineBorder(new Color(0, 0, 0)));

		txtConfirmation.setBackground(new Color(245, 245, 245));
		txtConfirmation.setEditable(true);
		txtConfirmation.setBorder(new LineBorder(new Color(0, 0, 0)));

		btnCambiar.setEnabled(true);
		btnCambiar.setBackground(Color.DARK_GRAY);
	}

}
