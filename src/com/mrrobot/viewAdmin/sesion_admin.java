package com.mrrobot.viewAdmin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.mrrobot.model.Sesion;
import com.mrrobot.viewCapturist.sesion_capturist;
import com.mrrobot.viewTechnical.sesion_technical;

import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sesion_admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnRegisterUser;
	private JButton btnGestionUser;
	private JButton btnSesionCapturista;
	private JButton btnSesionTecnico;
	private JButton btnGame;
	private JButton btnInfo;
	private JLabel lblTitle;
	private JLabel lblRegUser;
	private JLabel lblGestinUsuarios;
	private JLabel lblVistaCapturista;
	private JLabel lblVistaTcnico;
	private JLabel lblJuego;
	private JLabel lblInformacin;
	private JButton btnOff;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sesion_admin frame = new sesion_admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public sesion_admin() {
		try {
			setTitle("Administrador - Sesión de " + Sesion.getSesion().getUser().getNick());
		} catch (Exception e) {
			setTitle("Administrador - Sesión Prueba");
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/com/mrrobot/images/icono.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnRegisterUser = new JButton("");
			btnRegisterUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnRegisterUserJButton(e);
				}
			});
			btnRegisterUser
					.setIcon(new ImageIcon(sesion_admin.class.getResource("/com/mrrobot/images/sesion.register.png")));
			btnRegisterUser.setBackground(new Color(245, 245, 245));
			btnRegisterUser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnRegisterUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegisterUser.setFocusable(false);
			btnRegisterUser.setBounds(33, 77, 120, 120);
			contentPane.add(btnRegisterUser);
		}
		{
			btnGestionUser = new JButton("");
			btnGestionUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnGestionUserJButton(e);
				}
			});
			btnGestionUser
					.setIcon(new ImageIcon(sesion_admin.class.getResource("/com/mrrobot/images/sesion.usuarios.png")));
			btnGestionUser.setBackground(new Color(245, 245, 245));
			btnGestionUser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnGestionUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnGestionUser.setFocusable(false);
			btnGestionUser.setBounds(186, 77, 120, 120);
			contentPane.add(btnGestionUser);
		}
		{
			btnSesionCapturista = new JButton("");
			btnSesionCapturista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnSesionCapturistaJButton(e);
				}
			});
			btnSesionCapturista.setIcon(
					new ImageIcon(sesion_admin.class.getResource("/com/mrrobot/images/sesion.capturista.png")));
			btnSesionCapturista.setBackground(new Color(245, 245, 245));
			btnSesionCapturista.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnSesionCapturista.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnSesionCapturista.setFocusable(false);
			btnSesionCapturista.setBounds(339, 77, 120, 120);
			contentPane.add(btnSesionCapturista);
		}
		{
			btnSesionTecnico = new JButton("");
			btnSesionTecnico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnSesionTecnicoJButton(e);
				}
			});
			btnSesionTecnico
					.setIcon(new ImageIcon(sesion_admin.class.getResource("/com/mrrobot/images/sesion.tecnico.png")));
			btnSesionTecnico.setBackground(new Color(245, 245, 245));
			btnSesionTecnico.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnSesionTecnico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnSesionTecnico.setFocusable(false);
			btnSesionTecnico.setBounds(33, 274, 120, 120);
			contentPane.add(btnSesionTecnico);
		}
		{
			btnGame = new JButton("");
			btnGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnGameJButton(e);
				}
			});
			btnGame.setIcon(new ImageIcon(sesion_admin.class.getResource("/com/mrrobot/images/sesion.game.png")));
			btnGame.setBackground(new Color(245, 245, 245));
			btnGame.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnGame.setFocusable(false);
			btnGame.setBounds(186, 274, 120, 120);
			contentPane.add(btnGame);
		}
		{
			btnInfo = new JButton("");
			btnInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnInfoJButton(e);
				}
			});
			btnInfo.setIcon(new ImageIcon(sesion_admin.class.getResource("/com/mrrobot/images/sesion.info.png")));
			btnInfo.setBackground(new Color(245, 245, 245));
			btnInfo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnInfo.setFocusable(false);
			btnInfo.setBounds(339, 274, 120, 120);
			contentPane.add(btnInfo);
		}
		{
			btnOff = new JButton("");
			btnOff.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnOffJButton(e);
				}
			});
			btnOff.setIcon(new ImageIcon(sesion_admin.class.getResource("/com/mrrobot/images/admin.off.png")));
			btnOff.setBackground(new Color(245, 245, 245));
			btnOff.setFocusable(false);
			btnOff.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnOff.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnOff.setBounds(426, 13, 33, 33);
			contentPane.add(btnOff);
		}
		{
			lblTitle = new JLabel("");
			lblTitle.setForeground(Color.DARK_GRAY);
			lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
			lblTitle.setBounds(33, 13, 383, 35);
			contentPane.add(lblTitle);

			try {
				lblTitle.setText("Bienvenido " + Sesion.getSesion().getUser().getName());
			} catch (Exception e) {
				lblTitle.setText("BIENVENIDO");
			}

			lblRegUser = new JLabel("Registrar usuario");
			lblRegUser.setForeground(Color.DARK_GRAY);
			lblRegUser.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblRegUser.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegUser.setBounds(33, 208, 120, 21);
			contentPane.add(lblRegUser);

		}
		{
			lblGestinUsuarios = new JLabel("Gesti\u00F3n usuarios");
			lblGestinUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
			lblGestinUsuarios.setForeground(Color.DARK_GRAY);
			lblGestinUsuarios.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblGestinUsuarios.setBounds(186, 208, 120, 21);
			contentPane.add(lblGestinUsuarios);
		}
		{
			lblVistaCapturista = new JLabel("Vista Capturista");
			lblVistaCapturista.setHorizontalAlignment(SwingConstants.CENTER);
			lblVistaCapturista.setForeground(Color.DARK_GRAY);
			lblVistaCapturista.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVistaCapturista.setBounds(339, 208, 120, 21);
			contentPane.add(lblVistaCapturista);
		}
		{
			lblVistaTcnico = new JLabel("Vista T\u00E9cnico");
			lblVistaTcnico.setHorizontalAlignment(SwingConstants.CENTER);
			lblVistaTcnico.setForeground(Color.DARK_GRAY);
			lblVistaTcnico.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVistaTcnico.setBounds(33, 405, 120, 21);
			contentPane.add(lblVistaTcnico);
		}
		{
			lblJuego = new JLabel("Juego");
			lblJuego.setHorizontalAlignment(SwingConstants.CENTER);
			lblJuego.setForeground(Color.DARK_GRAY);
			lblJuego.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblJuego.setBounds(186, 405, 120, 21);
			contentPane.add(lblJuego);
		}
		{
			lblInformacin = new JLabel("Informaci\u00F3n");
			lblInformacin.setHorizontalAlignment(SwingConstants.CENTER);
			lblInformacin.setForeground(Color.DARK_GRAY);
			lblInformacin.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblInformacin.setBounds(339, 405, 120, 21);
			contentPane.add(lblInformacin);
		}
	}

	// EVENTOS

	protected void actionPerformedBtnRegisterUserJButton(ActionEvent e) {
		new registerUser(this, true).setVisible(true);
	}

	protected void actionPerformedBtnGestionUserJButton(ActionEvent e) {
		new gestionUser(this, true).setVisible(true);
	}

	protected void actionPerformedBtnSesionCapturistaJButton(ActionEvent e) {
		new sesion_capturist(this,true).setVisible(true);
	}

	protected void actionPerformedBtnSesionTecnicoJButton(ActionEvent e) {
		new sesion_technical(this, true).setVisible(true);
	}

	protected void actionPerformedBtnGameJButton(ActionEvent e) {
		new game(this, true).setVisible(true);
	}

	protected void actionPerformedBtnInfoJButton(ActionEvent e) {
		new information(this, true).setVisible(true);
	}

	protected void actionPerformedBtnOffJButton(ActionEvent e) {
		new index().setVisible(true);
		dispose();
	}
}
