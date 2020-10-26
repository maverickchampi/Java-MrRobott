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
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class recoveryEmail extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JButton btnEnviarCdigo;
	private JButton btnReenviar;
	private JLabel lblIngreseCdigo;
	private JTextField txtCode;
	private JButton btnValidar;
	private JLabel lblIngreseNuevoCorreo;
	private JTextField txtNewCorreo;
	private JButton btnCambiar;

	private String nick, correo, code;

	public static void main(String[] args) {
		try {
			recoveryEmail dialog = new recoveryEmail(null, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public recoveryEmail(JFrame frame, boolean modal) {
		super(frame, modal);
		setTitle("Cambio de correo");
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
			lblCorreo.setBounds(81, 44, 189, 19);
			contentPanel.add(lblCorreo);
		}
		{
			lblIngreseCdigo = new JLabel("Ingrese c\u00F3digo", SwingConstants.CENTER);
			lblIngreseCdigo.setForeground(Color.LIGHT_GRAY);
			lblIngreseCdigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblIngreseCdigo.setBounds(82, 175, 189, 19);
			contentPanel.add(lblIngreseCdigo);
		}
		{
			lblIngreseNuevoCorreo = new JLabel("Ingrese nuevo correo", SwingConstants.CENTER);
			lblIngreseNuevoCorreo.setForeground(Color.LIGHT_GRAY);
			lblIngreseNuevoCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblIngreseNuevoCorreo.setBounds(81, 303, 189, 19);
			contentPanel.add(lblIngreseNuevoCorreo);
		}
		{
			txtCorreo = new JTextField();
			txtCorreo.setForeground(Color.DARK_GRAY);
			txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtCorreo.setColumns(10);
			txtCorreo.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtCorreo.setBackground(new Color(245, 245, 245));
			txtCorreo.setBounds(63, 66, 225, 35);
			contentPanel.add(txtCorreo);
		}
		{
			txtCode = new JTextField();
			txtCode.setForeground(Color.DARK_GRAY);
			txtCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtCode.setEditable(false);
			txtCode.setColumns(10);
			txtCode.setBorder(new LineBorder(Color.GRAY, 1, true));
			txtCode.setBackground(Color.LIGHT_GRAY);
			txtCode.setBounds(64, 197, 225, 35);
			contentPanel.add(txtCode);
		}
		{
			txtNewCorreo = new JTextField();
			txtNewCorreo.setEditable(false);
			txtNewCorreo.setForeground(Color.DARK_GRAY);
			txtNewCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtNewCorreo.setColumns(10);
			txtNewCorreo.setBorder(new LineBorder(Color.GRAY, 1, true));
			txtNewCorreo.setBackground(Color.LIGHT_GRAY);
			txtNewCorreo.setBounds(63, 325, 225, 35);
			contentPanel.add(txtNewCorreo);
		}
		{
			btnEnviarCdigo = new JButton("ENVIAR C\u00D3DIGO");
			btnEnviarCdigo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actionPerformedBtnEnviarCdigoJButton(arg0);
				}
			});
			btnEnviarCdigo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEnviarCdigo.setForeground(new Color(220, 220, 220));
			btnEnviarCdigo.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnEnviarCdigo.setFocusable(false);
			btnEnviarCdigo.setBorder(new LineBorder(Color.WHITE));
			btnEnviarCdigo.setBackground(Color.DARK_GRAY);
			btnEnviarCdigo.setBounds(64, 107, 111, 40);
			contentPanel.add(btnEnviarCdigo);
		}
		{
			btnReenviar = new JButton("REENVIAR");
			btnReenviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnReenviarJButton(e);
				}
			});
			btnReenviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnReenviar.setForeground(new Color(220, 220, 220));
			btnReenviar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnReenviar.setFocusable(false);
			btnReenviar.setEnabled(false);
			btnReenviar.setBorder(new LineBorder(Color.WHITE));
			btnReenviar.setBackground(Color.LIGHT_GRAY);
			btnReenviar.setBounds(177, 107, 111, 40);
			contentPanel.add(btnReenviar);
		}
		{
			btnValidar = new JButton("VALIDAR");
			btnValidar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnValidarJButton(e);
				}
			});
			btnValidar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnValidar.setForeground(new Color(220, 220, 220));
			btnValidar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnValidar.setFocusable(false);
			btnValidar.setEnabled(false);
			btnValidar.setBorder(new LineBorder(Color.WHITE));
			btnValidar.setBackground(Color.LIGHT_GRAY);
			btnValidar.setBounds(64, 239, 111, 40);
			contentPanel.add(btnValidar);
		}
		{
			btnCambiar = new JButton("ENVIAR C\u00D3DIGO");
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
			btnCambiar.setBounds(64, 366, 111, 40);
			contentPanel.add(btnCambiar);
		}
	}

	// EVENTOS

	protected void actionPerformedBtnEnviarCdigoJButton(ActionEvent arg0) {
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

	protected void actionPerformedBtnReenviarJButton(ActionEvent e) {
		sendCode(correo);
	}

	protected void actionPerformedBtnValidarJButton(ActionEvent e) {
		if (txtCode.getText().equals(code)) {
			blocktwo();
		} else
			JOptionPane.showMessageDialog(null, "Código inválido", "Intentelo nuevamente", 2);
	}

	protected void actionPerformedBtnCambiarJButton(ActionEvent e) {
		String patron = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if (Pattern.matches(patron, txtNewCorreo.getText().trim())) {

			Factory dao = Factory
					.getDAOFactory(Factory.MYSQL5);/* Bd con la cual trabajar */
			clsUser u = dao.getUserDAO().searchUser(nick);

			u.setEmail(txtNewCorreo.getText().trim());

			dao.getUserDAO().updateUser(u);
			JOptionPane.showMessageDialog(null, "Cambio de contraseña exitoso", "Éxito", 1);
			dispose();

		} else
			JOptionPane.showMessageDialog(null, "Ingrese un correo válido", "Intentelo nuevamente", 2);
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
			message.setSubject("Cambio de correo - MrRobot");
			message.setText("Este es su código para el cambio de correo electrónico :\t" + code);
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

		lblIngreseNuevoCorreo.setForeground(Color.DARK_GRAY);

		txtNewCorreo.setBackground(new Color(245, 245, 245));
		txtNewCorreo.setEditable(true);
		txtNewCorreo.requestFocus();
		txtNewCorreo.setBorder(new LineBorder(new Color(0, 0, 0)));

		btnCambiar.setEnabled(true);
		btnCambiar.setBackground(Color.DARK_GRAY);
	}
}
