package com.mrrobot.viewCapturist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.mrrobot.dao.Factory;
import com.mrrobot.model.Sesion;
import com.mrrobot.model.clsClient;
import com.mrrobot.model.clsDevice;

public class informationClient extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblInformacinDeUsuario;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblTelefono;
	private JTextField txtPhone;
	private JLabel lblDireccion;
	private JTextField txtDirection;
	private JLabel lblltimaModificacipn;
	private JTextField txtChange;
	private JButton btnUpdate;
	private JButton btnVolver;
	private JScrollPane scrollPane;
	private JTable tbDevice;
	private JButton btnRegistrarEquipo;
	private JButton btnImprimir;

	protected static boolean info = false;
	protected static boolean equipo = false;

	DefaultTableModel model = new DefaultTableModel() {
		private static final long serialVersionUID = 1L;

		@Override
		// CELDAS NO EDITABLES
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

	public static void main(String[] args) {
		try {
			informationClient dialog = new informationClient(null, false, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public informationClient(JDialog frame, boolean modal, clsClient c) {
		super(frame, modal);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				windowActivatedThisJDialog(arg0, c);
			}
		});
		try {
			setTitle("Información de cliente - Sesión de " + Sesion.getSesion().getUser().getNick());
		} catch (Exception e) {
			setTitle("Información de cliente - Sesión Prueba");
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
			lblInformacinDeUsuario = new JLabel("Informaci\u00F3n de cliente");
			lblInformacinDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			lblInformacinDeUsuario.setForeground(Color.DARK_GRAY);
			lblInformacinDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblInformacinDeUsuario.setBounds(50, 21, 394, 20);
			contentPanel.add(lblInformacinDeUsuario);
		}
		{
			lblNombre = new JLabel("Nombre", SwingConstants.CENTER);
			lblNombre.setForeground(Color.DARK_GRAY);
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNombre.setBounds(27, 73, 189, 15);
			contentPanel.add(lblNombre);
		}
		{
			lblEmail = new JLabel("Email", SwingConstants.CENTER);
			lblEmail.setForeground(Color.DARK_GRAY);
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblEmail.setBounds(26, 145, 189, 15);
			contentPanel.add(lblEmail);
		}
		{
			lblTelefono = new JLabel("Tel\u00E9fono", SwingConstants.CENTER);
			lblTelefono.setForeground(Color.DARK_GRAY);
			lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTelefono.setBounds(27, 217, 189, 15);
			contentPanel.add(lblTelefono);
		}
		{
			lblDireccion = new JLabel("Direccion", SwingConstants.CENTER);
			lblDireccion.setForeground(Color.DARK_GRAY);
			lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblDireccion.setBounds(27, 289, 189, 15);
			contentPanel.add(lblDireccion);
		}
		{
			lblltimaModificacipn = new JLabel("\u00DAltima modificaci\u00F3n", SwingConstants.CENTER);
			lblltimaModificacipn.setForeground(Color.DARK_GRAY);
			lblltimaModificacipn.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblltimaModificacipn.setBounds(27, 361, 189, 15);
			contentPanel.add(lblltimaModificacipn);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setForeground(Color.DARK_GRAY);
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtNombre.setColumns(10);
			txtNombre.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtNombre.setBackground(new Color(245, 245, 245));
			txtNombre.setBounds(26, 99, 188, 35);
			contentPanel.add(txtNombre);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setForeground(Color.DARK_GRAY);
			txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtEmail.setColumns(10);
			txtEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtEmail.setBackground(new Color(245, 245, 245));
			txtEmail.setBounds(25, 171, 188, 35);
			contentPanel.add(txtEmail);
		}
		{
			txtPhone = new JTextField();
			txtPhone.setForeground(Color.DARK_GRAY);
			txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtPhone.setColumns(10);
			txtPhone.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtPhone.setBackground(new Color(245, 245, 245));
			txtPhone.setBounds(26, 243, 188, 35);
			contentPanel.add(txtPhone);
		}
		{
			txtDirection = new JTextField();
			txtDirection.setForeground(Color.DARK_GRAY);
			txtDirection.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtDirection.setColumns(10);
			txtDirection.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtDirection.setBackground(new Color(245, 245, 245));
			txtDirection.setBounds(26, 315, 188, 35);
			contentPanel.add(txtDirection);
		}
		{
			txtChange = new JTextField();
			txtChange.setEditable(false);
			txtChange.setForeground(Color.DARK_GRAY);
			txtChange.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtChange.setColumns(10);
			txtChange.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtChange.setBackground(new Color(245, 245, 245));
			txtChange.setBounds(26, 387, 188, 35);
			contentPanel.add(txtChange);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(236, 74, 238, 169);
			contentPanel.add(scrollPane);
			{
				tbDevice = new JTable(model);
				tbDevice.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						mousePressedTbDeviceJTable(arg0);
					}
				});
				tbDevice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				tbDevice.setSelectionBackground(Color.LIGHT_GRAY);
				tbDevice.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tbDevice.setForeground(Color.BLACK);
				tbDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
				scrollPane.setViewportView(tbDevice);
				model.addColumn("Id");
				model.addColumn("Tipo");
				model.addColumn("Estado");
			}

			{
				btnUpdate = new JButton("ACTUALIZAR");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actionPerformedBtnUpdateJButton(e, c);
					}
				});
				btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnUpdate.setForeground(new Color(220, 220, 220));
				btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnUpdate.setFocusable(false);
				btnUpdate.setBorder(new LineBorder(Color.WHITE));
				btnUpdate.setBackground(new Color(47, 79, 79));
				btnUpdate.setBounds(256, 342, 188, 38);
				contentPanel.add(btnUpdate);
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
				btnRegistrarEquipo.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnRegistrarEquipo.setFocusable(false);
				btnRegistrarEquipo.setBorder(new LineBorder(Color.WHITE));
				btnRegistrarEquipo.setBackground(new Color(20, 100, 100));
				btnRegistrarEquipo.setBounds(256, 257, 188, 38);
				contentPanel.add(btnRegistrarEquipo);
			}
			{
				btnImprimir = new JButton("IMPRIMIR");
				btnImprimir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actionPerformedBtnImprimirJButton(e, c);
					}
				});
				btnImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnImprimir.setForeground(new Color(220, 220, 220));
				btnImprimir.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnImprimir.setFocusable(false);
				btnImprimir.setBorder(new LineBorder(Color.WHITE));
				btnImprimir.setBackground(new Color(37, 99, 99));
				btnImprimir.setBounds(256, 300, 188, 38);
				contentPanel.add(btnImprimir);
			}
			btnVolver = new JButton("VOLVER");
			btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnVolverJButton(e);
				}
			});
			btnVolver.setForeground(new Color(220, 220, 220));
			btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnVolver.setFocusable(false);
			btnVolver.setBorder(new LineBorder(Color.WHITE));
			btnVolver.setBackground(Color.DARK_GRAY);
			btnVolver.setBounds(256, 384, 188, 38);
			contentPanel.add(btnVolver);
		}
		adjustTable(scrollPane, tbDevice);
		if (c != null)
			loadClient(c);
		loadDevice(c);
	}

	// EVENTOS

	protected void actionPerformedBtnRegistrarEquipoJButton(ActionEvent e, clsClient c) {
		new registerDevice(this, true, c).setVisible(true);
	}

	protected void actionPerformedBtnImprimirJButton(ActionEvent e, clsClient c) {
		// IMPRESION DE TEXTO PDF DE CLIENTES REGISTRADOS

		Document doc = new Document();

		try {

			// ---DIRECCION A ENVIAR EL PDF---
			PdfWriter.getInstance(doc, new FileOutputStream("ReporteEquiposDe" + c.getName() + ".pdf"));

			// CÓDIGO DE IMAGEN EN PDF
			Image head = Image.getInstance("src/com/mrrobot/images/fondo.png");
			head.scaleToFit(650, 1000);
			head.setAlignment(Chunk.ALIGN_CENTER);

			// CÓDIGO DE TÍTULO Y FUENTE EN PDF
			Paragraph p = new Paragraph();
			p.setAlignment(Paragraph.ALIGN_CENTER);
//			p.add("Formado por Maverick \n\n");
			p.setFont(FontFactory.getFont("Arial", 18, Font.BOLD, BaseColor.DARK_GRAY));
			p.add("\n\nCLIENTE REGISTRADO \n\n\n");

			// ------------CÓDIGO DE SALTO TEXTO EN PDF-------------SALTO DE
			// SEPARACION DE LAS TABLAS
			Paragraph p1 = new Paragraph();
			p1.setAlignment(Paragraph.ALIGN_CENTER);
			p1.setFont(FontFactory.getFont("Arial", 18, Font.BOLD, BaseColor.DARK_GRAY));
			p1.add("\n\n EQUIPO REGISTRADO/S \n\n\n");

			// ---SE ABRE DOC---
			doc.open();

			// ACTIVACIÓN DE LOS 2 CÓDIGOS ANTERIORES
			doc.add(head);
			doc.add(p);

			// CANTIDAD Y NOMBRE DE LAS TABLAS DENTRO DEL PDF
			PdfPTable tabla = new PdfPTable(5);
			tabla.addCell("ID de Cliente");
			tabla.addCell("Nombre");
			tabla.addCell("Email");
			tabla.addCell("Télefono");
			tabla.addCell("Dirección");

			// CANTIDAD Y NOMBRE DE LAS SEGUNDAS TABLAS DENTRO DEL PDF
			PdfPTable tabla1 = new PdfPTable(4);
			tabla1.addCell("ID Equipo");
			tabla1.addCell("Tipo");
			tabla1.addCell("Marca");
			tabla1.addCell("Estatus");

			// ***********************TABLA 1

			tabla.addCell(c.getidClient() + "");
			tabla.addCell(c.getName());
			tabla.addCell(c.getEmail());
			tabla.addCell(c.getPhone());
			tabla.addCell(c.getDirection());

			doc.add(tabla);
			doc.add(p1);

			// **********************TABLA 2

			Factory dao = Factory
					.getDAOFactory(Factory.MYSQL5);/*
													 * Bd con la cual trabajar
													 */
			ArrayList<clsDevice> lista = dao.getDeviceDAO().listadoDevice(c);
			// LLENADO DE TABLAS RESPECTO A BASE DE
			// DATOS(ORDEN)
			for (clsDevice d : lista) {
				String estado = "", tipo = "", marca = "";

				switch (d.getType()) {
				case 0:
					tipo = "Celular";
					break;
				case 1:
					tipo = "Laptop";
					break;
				case 2:
					tipo = "Computadora";
					break;
				case 3:
					tipo = "Tablet";
					break;
				case 4:
					tipo = "Impresora";
					break;
				}
				switch (d.getStatus()) {
				case 0:
					estado = "Nuevo Ingreso";
					break;
				case 1:
					estado = "No Reparado";
					break;
				case 2:
					estado = "En Revisión";
					break;
				case 3:
					estado = "Reparado";
					break;
				case 4:
					estado = "Entregado";
					break;
				}
				switch (d.getBrand()) {
				case 0:
					marca = "Acer";
					break;
				case 1:
					marca = "Alcatel";
					break;
				case 2:
					marca = "Alienware";
					break;
				case 3:
					marca = "Apple";
					break;
				case 4:
					marca = "Asus";
					break;
				case 5:
					marca = "BlackBerry";
					break;
				case 6:
					marca = "Canon";
					break;
				case 7:
					marca = "Dell";
					break;
				case 8:
					marca = "Epson";
					break;
				case 9:
					marca = "Honor";
					break;
				case 10:
					marca = "HP";
					break;
				case 11:
					marca = "Huawei";
					break;
				case 12:
					marca = "Lenovo";
					break;
				case 13:
					marca = "LG";
					break;
				case 14:
					marca = "Microsoft";
					break;
				case 15:
					marca = "Motorola";
					break;
				case 16:
					marca = "MSI";
					break;
				case 17:
					marca = "Nokia";
					break;
				case 18:
					marca = "OnePlus";
					break;
				case 19:
					marca = "OPPO";
					break;
				case 20:
					marca = "Razer";
					break;
				case 21:
					marca = "Realme";
					break;
				case 22:
					marca = "Samsung";
					break;
				case 23:
					marca = "Sony";
					break;
				case 24:
					marca = "Toshiba";
					break;
				case 25:
					marca = "Vivo";
					break;
				case 26:
					marca = "Xiaomi";
					break;
				case 27:
					marca = "ZTE";
					break;
				}
				tabla1.addCell(d.getIdDevice() + "");
				tabla1.addCell(tipo);
				tabla1.addCell(marca);
				tabla1.addCell(estado);
			}
			doc.add(tabla1);

			JOptionPane.showMessageDialog(null, "Reporte de cliente listo!", "Éxito !", 1);
			
		} catch (Exception e2) {

			JOptionPane.showMessageDialog(null, "Reporte de cliente fallido!", "Advertencia !", 2);
		} finally {
			doc.close();
		}

	}

	protected void actionPerformedBtnVolverJButton(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnUpdateJButton(ActionEvent arg0, clsClient c) {
		if (!txtNombre.getText().trim().isEmpty()) {
			String patron = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			if (Pattern.matches(patron, txtEmail.getText().trim())) {
				if (txtPhone.getText().trim().length() > 4) {
					if (!txtDirection.getText().trim().isEmpty()) {

						Factory dao = Factory.getDAOFactory(Factory.MYSQL5);

						c.setName(txtNombre.getText().trim());
						c.setEmail(txtEmail.getText().trim());
						c.setPhone(txtPhone.getText().trim());
						c.setDirection(txtDirection.getText().trim());

						try {
							c.setChange(Sesion.getSesion().getUser().getName());
						} catch (Exception e) {
							c.setChange("Prueba");
						}

						info = true;/* sirve para actualizar tabla de gestion */

						dao.getClientDAO().updateClient(c);
						JOptionPane.showMessageDialog(null, "Cliente actualizado !", "Éxito", 1);
						dispose();

					} else
						changeColor(txtDirection, "Ingrese una dirección");
				} else
					changeColor(txtPhone, "Ingrese un número de teléfono válido");
			} else
				changeColor(txtEmail, "Ingrese un correo válido");
		} else
			changeColor(txtNombre, "Ingrese un nombre válido");
	}

	protected void windowActivatedThisJDialog(WindowEvent arg0, clsClient c) {
		if (equipo) {
			loadDevice(c);
			equipo = false;
			// System.out.println("Actualizando equipos");
		}
	}

	protected void mousePressedTbDeviceJTable(MouseEvent e) {
		int fila_point = tbDevice.rowAtPoint(e.getPoint());
		int columna_point = 0;

		if (fila_point > -1) {

			int id = (int) model.getValueAt(fila_point, columna_point);

			Factory dao = Factory.getDAOFactory(
					Factory.MYSQL5);/* Base de datos con la cual trabajar */
			clsDevice d = dao.getDeviceDAO().search(id);

			new informationDevice(this, true, d).setVisible(true);

		}
	}
	// METODOS

	private void changeColor(JTextField txt, String msg) {
		txt.setBackground(Color.RED);
		JOptionPane.showMessageDialog(null, msg, "Advertencia !", 2);
		txt.setBackground(new Color(245, 245, 245));
		txt.requestFocus();
	}

	private void loadClient(clsClient c) {
		txtNombre.setText(c.getName());
		txtEmail.setText(c.getEmail());
		txtPhone.setText(c.getPhone());
		txtDirection.setText(c.getDirection());
		txtChange.setText(c.getChange());
	}

	private void loadDevice(clsClient c) {
		model.setRowCount(0);
		List<clsDevice> lista = new ArrayList<>();

		try {
			Factory dao = Factory
					.getDAOFactory(Factory.MYSQL5);/* Bd con la cual trabajar */

			lista = dao.getDeviceDAO().listadoDevice(c);

			for (clsDevice d : lista) {

				String estado, tipo;

				switch (d.getStatus()) {
				case 0:
					estado = "Nuevo Ingreso";
					break;
				case 1:
					estado = "No Reparado";
					break;
				case 2:
					estado = "En Revisión";
					break;
				case 3:
					estado = "Reparado";
					break;
				case 4:
					estado = "Entregado";
					break;
				default:
					estado = "ERROR";
					break;
				}

				switch (d.getType()) {
				case 0:
					tipo = "Celular";
					break;
				case 1:
					tipo = "Laptop";
					break;
				case 2:
					tipo = "Computadora";
					break;
				case 3:
					tipo = "Tablet";
					break;
				case 4:
					tipo = "Impresora";
					break;
				default:
					tipo = "ERROR";
					break;
				}

				Object[] fila = { d.getIdDevice(), tipo, estado };
				model.addRow(fila);
			}
		} catch (Exception e) {
			System.out.println("Error lista equipos");
		}
	}

	private void adjustTable(JScrollPane scroll, JTable table) {

		Dimension tableSize = scroll.getPreferredSize();
		table.getColumnModel().getColumn(0).setPreferredWidth(Math.round(tableSize.width * 0.10f));
		table.getColumnModel().getColumn(1).setPreferredWidth(Math.round(tableSize.width * 0.45f));
		table.getColumnModel().getColumn(2).setPreferredWidth(Math.round(tableSize.width * 0.45f));

		DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
		tcr1.setHorizontalAlignment(SwingConstants.CENTER);
		tcr1.setBackground(Color.BLACK);
		tcr1.setForeground(Color.white);
		for (int i = 0; i < 3; i++) {
			table.getColumnModel().getColumn(i).setHeaderRenderer(tcr1);
		}
	}
}
