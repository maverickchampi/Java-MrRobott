package com.mrrobot.viewCapturist;

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
import java.awt.HeadlessException;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mrrobot.dao.Factory;
import com.mrrobot.model.Sesion;
import com.mrrobot.model.clsClient;
import com.mrrobot.viewAdmin.index;

public class sesion_capturist extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTitle;
	private JButton btnRegisterClient;
	private JButton btnGestionClient;
	private JButton btnPrintClient;
	private JLabel lblRegClient;
	private JLabel lblGestionarClientes;
	private JLabel lblImprimirClientes;
	private JButton btnOff;
	private JButton btnVolver;

	public static void main(String[] args) {
		try {
			sesion_capturist dialog = new sesion_capturist(null, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public sesion_capturist(JFrame frame, boolean modal) {
		super(frame, modal);
		try {
			setTitle("Capturista - Sesión de " + Sesion.getSesion().getUser().getNick());
		} catch (Exception e) {
			setTitle("Capturista - Sesión Prueba");
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
			lblTitle = new JLabel("");
			lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
			lblTitle.setForeground(Color.DARK_GRAY);
			lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblTitle.setBounds(33, 33, 383, 35);
			contentPanel.add(lblTitle);

			try {
				lblTitle.setText("Bienvenido " + Sesion.getSesion().getUser().getName());
			} catch (Exception e) {
				lblTitle.setText("BIENVENIDO");
			}
		}
		{
			btnRegisterClient = new JButton("");
			btnRegisterClient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actionPerformedBtnRegisterClientJButton(arg0);
				}
			});
			btnRegisterClient.setIcon(
					new ImageIcon(sesion_capturist.class.getResource("/com/mrrobot/images/registerclient.png")));
			btnRegisterClient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegisterClient.setFocusable(false);
			btnRegisterClient.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnRegisterClient.setBackground(new Color(245, 245, 245));
			btnRegisterClient.setBounds(33, 160, 120, 120);
			contentPanel.add(btnRegisterClient);
		}
		{
			btnGestionClient = new JButton("");
			btnGestionClient.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnGestionClientJButton(e);
				}
			});
			btnGestionClient.setIcon(
					new ImageIcon(sesion_capturist.class.getResource("/com/mrrobot/images/gestionclient.png")));
			btnGestionClient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnGestionClient.setFocusable(false);
			btnGestionClient.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnGestionClient.setBackground(new Color(245, 245, 245));
			btnGestionClient.setBounds(186, 160, 120, 120);
			contentPanel.add(btnGestionClient);
		}
		{
			btnPrintClient = new JButton("");
			btnPrintClient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnPrintClientJButton(e);
				}
			});
			btnPrintClient
					.setIcon(new ImageIcon(sesion_capturist.class.getResource("/com/mrrobot/images/printclient.png")));
			btnPrintClient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnPrintClient.setFocusable(false);
			btnPrintClient.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnPrintClient.setBackground(new Color(245, 245, 245));
			btnPrintClient.setBounds(339, 160, 120, 120);
			contentPanel.add(btnPrintClient);
		}

		{
			lblRegClient = new JLabel("Registrar Cliente");
			lblRegClient.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegClient.setForeground(Color.DARK_GRAY);
			lblRegClient.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblRegClient.setBounds(33, 291, 120, 21);
			contentPanel.add(lblRegClient);
		}
		{
			lblGestionarClientes = new JLabel("Gesti\u00F3n Clientes");
			lblGestionarClientes.setHorizontalAlignment(SwingConstants.CENTER);
			lblGestionarClientes.setForeground(Color.DARK_GRAY);
			lblGestionarClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblGestionarClientes.setBounds(186, 291, 120, 21);
			contentPanel.add(lblGestionarClientes);
		}
		{
			lblImprimirClientes = new JLabel("Imprimir Clientes");
			lblImprimirClientes.setHorizontalAlignment(SwingConstants.CENTER);
			lblImprimirClientes.setForeground(Color.DARK_GRAY);
			lblImprimirClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblImprimirClientes.setBounds(339, 291, 120, 21);
			contentPanel.add(lblImprimirClientes);
		}
		{
			btnOff = new JButton("");
			btnOff.setVisible(false);
			btnOff.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actionPerformedBtnOffJButton(arg0);
				}
			});
			btnOff.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnOff.setIcon(new ImageIcon(sesion_capturist.class.getResource("/com/mrrobot/images/admin.off.png")));
			btnOff.setFocusable(false);
			btnOff.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnOff.setBackground(new Color(245, 245, 245));
			btnOff.setBounds(426, 33, 33, 33);
			contentPanel.add(btnOff);
		}
		{
			btnVolver = new JButton("VOLVER");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actionPerformedBtnVolverJButton(arg0);
				}
			});
			btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnVolver.setForeground(new Color(220, 220, 220));
			btnVolver.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnVolver.setFocusable(false);
			btnVolver.setBorder(new LineBorder(Color.WHITE));
			btnVolver.setBackground(Color.DARK_GRAY);
			btnVolver.setBounds(147, 389, 200, 40);
			contentPanel.add(btnVolver);
		}
		if (Sesion.getSesion().getUser() != null)
			if (Sesion.getSesion().getUser().getNivel() == 1) {
				btnOff.setVisible(true);
				btnVolver.setVisible(false);
			}
	}

	// EVENTOS

	protected void actionPerformedBtnRegisterClientJButton(ActionEvent arg0) {
		new registerClient(this, true).setVisible(true);
	}

	protected void actionPerformedBtnGestionClientJButton(ActionEvent e) {
		new gestionClient(this, true).setVisible(true);
	}

	protected void actionPerformedBtnOffJButton(ActionEvent arg0) {
		new index().setVisible(true);
		dispose();
	}

	protected void actionPerformedBtnPrintClientJButton(ActionEvent e) {
		// IMPRESION DE TEXTO PDF DE CLIENTES REGISTRADOS
		Document doc = new Document();

		try {

			// ---DIRECCION A ENVIAR EL PDF---
			PdfWriter.getInstance(doc, new FileOutputStream("Clientes.pdf"));

			// CÓDIGO DE IMAGEN EN PDF
			Image head = Image.getInstance("src/com/mrrobot/images/fondo.png");
			head.scaleToFit(650, 1000);
			head.setAlignment(Chunk.ALIGN_CENTER);

			// CÓDIGO DE TÍTULO Y FUENTE EN PDF
			Paragraph p = new Paragraph();
			p.setAlignment(Paragraph.ALIGN_CENTER);
//			p.add("Formado por Maverick \n\n");
			p.setFont(FontFactory.getFont("Arial", 18, Font.BOLD, BaseColor.RED));
			p.add("\n\nCLIENTES REGISTRADOS \n\n\n");

			// ---SE ABRE DOC---
			doc.open();

			// ACTIVACIÓN DE LOS 2 CÓDIGOS ANTERIORES
			doc.add(head);
			doc.add(p);

			// CANTIDAD Y NOMBRE DE LAS TABLAS DENTRO DEL PDF
			PdfPTable tabla = new PdfPTable(5);
			tabla.addCell("ID");
			tabla.addCell("Nombre");
			tabla.addCell("Email");
			tabla.addCell("Télefono");
			tabla.addCell("Dirección");

			Factory dao = Factory.getDAOFactory(
					Factory.MYSQL5);/*
									 * Base de datosd con la cual trabajar
									 */
			ArrayList<clsClient> lista = dao.getClientDAO().listadoCLient();

			// LLENADO DE TABLAS RESPECTO A BASE DE
			// DATOS(ORDEN)
			for (clsClient c : lista) {
				tabla.addCell(c.getidClient() + "");
				tabla.addCell(c.getName());
				tabla.addCell(c.getEmail());
				tabla.addCell(c.getPhone());
				tabla.addCell(c.getDirection());
			}
			doc.add(tabla);

			doc.close();
			JOptionPane.showMessageDialog(null, "Reporte listo!", "Éxito", 1);

		} catch (DocumentException | HeadlessException | FileNotFoundException e2) {

			JOptionPane.showMessageDialog(null, "Reporte fallido!", "Inténtelo nuevamente", 2);
		} catch (MalformedURLException e2) {

			e2.printStackTrace();
		} catch (IOException e2) {

			e2.printStackTrace();
		}
	}

	protected void actionPerformedBtnVolverJButton(ActionEvent arg0) {
		dispose();
	}
}
