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
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.mrrobot.dao.Factory;
import com.mrrobot.model.Sesion;
import com.mrrobot.model.clsClient;

public class registerClient extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JLabel lblIngreseLosDatos;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblEmail;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JLabel lblTelfono;
	private JLabel lblUsuario;
	private JTextField txtEmail;
	private JButton btnRegistrar;

	public static void main(String[] args) {
		try {
			registerClient dialog = new registerClient(null, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public registerClient(JDialog frame, boolean modal) {
		super(frame, modal);
		try {
			setTitle("Registrar Cliente - Sesión de " + Sesion.getSesion().getUser().getNick());
		} catch (Exception e) {
			setTitle("Registrar Cliente - Sesión Prueba");
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
			lblIngreseLosDatos = new JLabel("Ingrese los datos del nuevo cliente");
			lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
			lblIngreseLosDatos.setForeground(Color.DARK_GRAY);
			lblIngreseLosDatos.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblIngreseLosDatos.setBounds(35, 20, 408, 26);
			contentPanel.add(lblIngreseLosDatos);
		}
		{
			lblNombre = new JLabel("Nombre", SwingConstants.CENTER);
			lblNombre.setForeground(Color.DARK_GRAY);
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNombre.setBounds(35, 83, 408, 15);
			contentPanel.add(lblNombre);
		}
		{
			lblEmail = new JLabel("Email", SwingConstants.CENTER);
			lblEmail.setForeground(Color.DARK_GRAY);
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblEmail.setBounds(35, 163, 189, 15);
			contentPanel.add(lblEmail);
		}
		{
			lblTelfono = new JLabel("Tel\u00E9fono", SwingConstants.CENTER);
			lblTelfono.setForeground(Color.DARK_GRAY);
			lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTelfono.setBounds(256, 163, 189, 15);
			contentPanel.add(lblTelfono);
		}
		{
			lblUsuario = new JLabel("Direcci\u00F3n", SwingConstants.CENTER);
			lblUsuario.setForeground(Color.DARK_GRAY);
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUsuario.setBounds(35, 243, 410, 15);
			contentPanel.add(lblUsuario);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setForeground(Color.DARK_GRAY);
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtNombre.setColumns(10);
			txtNombre.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtNombre.setBackground(new Color(245, 245, 245));
			txtNombre.setBounds(35, 109, 410, 35);
			contentPanel.add(txtNombre);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setForeground(Color.DARK_GRAY);
			txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtEmail.setColumns(10);
			txtEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtEmail.setBackground(new Color(245, 245, 245));
			txtEmail.setBounds(34, 189, 188, 35);
			contentPanel.add(txtEmail);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setForeground(Color.DARK_GRAY);
			txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtTelefono.setColumns(10);
			txtTelefono.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtTelefono.setBackground(new Color(245, 245, 245));
			txtTelefono.setBounds(255, 189, 188, 35);
			contentPanel.add(txtTelefono);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setForeground(Color.DARK_GRAY);
			txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtDireccion.setColumns(10);
			txtDireccion.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtDireccion.setBackground(new Color(245, 245, 245));
			txtDireccion.setBounds(35, 269, 408, 35);
			contentPanel.add(txtDireccion);
		}
		{
			btnRegistrar = new JButton("REGISTRAR");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnRegistrarJButton(e);
				}
			});
			btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegistrar.setForeground(new Color(220, 220, 220));
			btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnRegistrar.setFocusable(false);
			btnRegistrar.setBorder(new LineBorder(Color.WHITE));
			btnRegistrar.setBackground(new Color(40, 79, 79));
			btnRegistrar.setBounds(34, 364, 189, 40);
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
			btnVolver.setBounds(255, 364, 189, 40);
			contentPanel.add(btnVolver);
		}

	}

	// EVENTOS

	protected void actionPerformedBtnVolverJButton(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnRegistrarJButton(ActionEvent arg0) {
		if (!txtNombre.getText().trim().isEmpty()) {
			String patron = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			if (Pattern.matches(patron, txtEmail.getText().trim())) {
				if (txtTelefono.getText().trim().length() > 4) {
					if (!txtDireccion.getText().trim().isEmpty()) {

						Factory dao = Factory.getDAOFactory(Factory.MYSQL5);
						clsClient c = new clsClient();
						c.setidClient(0);
						c.setName(txtNombre.getText().trim());
						c.setEmail(txtEmail.getText().trim());
						c.setPhone(txtTelefono.getText().trim());
						c.setDirection(txtDireccion.getText().trim());
						try {
							c.setChange(Sesion.getSesion().getUser().getName());
						} catch (Exception e) {
							c.setChange("Prueba");
						}

						dao.getClientDAO().addClient(c);
						JOptionPane.showMessageDialog(null, "Cliente registrado !", "Éxito", 1);
						dispose();

					} else
						changeColor(txtDireccion, "Ingrese una dirección");
				} else
					changeColor(txtTelefono, "Ingrese un número de teléfono válido");
			} else
				changeColor(txtEmail, "Ingrese un correo válido");
		} else
			changeColor(txtNombre, "Ingrese un nombre válido");
	}

	// METODOS

	private void changeColor(JTextField txt, String msg) {
		txt.setBackground(Color.RED);
		JOptionPane.showMessageDialog(null, msg, "Advertencia !", 2);
		txt.setBackground(new Color(245, 245, 245));
		txt.requestFocus();
	}
}
