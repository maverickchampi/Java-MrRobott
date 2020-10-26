package com.mrrobot.viewTechnical;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.mrrobot.dao.Factory;
import com.mrrobot.model.Sesion;
import com.mrrobot.model.clsDevice;

public class gestionEquipo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JLabel lblSeleccioneEquipo;
	private JScrollPane scrollPane;
	private JTable tbDevice;
	DefaultTableModel model = new DefaultTableModel() {
		private static final long serialVersionUID = 1L;

		@Override
		// CELDAS NO EDITABLES
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private JComboBox<String> cbFiltro;

	public static void main(String[] args) {
		try {
			gestionEquipo dialog = new gestionEquipo(null, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public gestionEquipo(JDialog frame, boolean modal) {
		super(frame, modal);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				windowActivatedThisJDialog(arg0);
			}
		});
		try {
			setTitle("Gestion de equipos - Sesión de " + Sesion.getSesion().getUser().getNick());
		} catch (Exception e) {
			setTitle("Gestion de equipos - Sesión Prueba");
		}

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(sesion_technical.class.getResource("/com/mrrobot/images/icono.png")));
		setBounds(100, 100, 500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(220, 220, 220));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
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
			btnVolver.setBounds(147, 400, 200, 40);
			contentPanel.add(btnVolver);
		}
		{
			lblSeleccioneEquipo = new JLabel("Seleccione equipo ");
			lblSeleccioneEquipo.setHorizontalAlignment(SwingConstants.LEFT);
			lblSeleccioneEquipo.setForeground(Color.DARK_GRAY);
			lblSeleccioneEquipo.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblSeleccioneEquipo.setBounds(30, 20, 217, 26);
			contentPanel.add(lblSeleccioneEquipo);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(30, 75, 434, 293);
			contentPanel.add(scrollPane);
			{
				tbDevice = new JTable(model);
				tbDevice.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						mousePressedTbUserJTable(arg0);
					}
				});
				tbDevice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				tbDevice.setSelectionBackground(Color.LIGHT_GRAY);
				tbDevice.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tbDevice.setForeground(Color.BLACK);
				tbDevice.setFont(new Font("Tahoma", Font.PLAIN, 15));
				model.addColumn("Id");
				model.addColumn("Tipo");
				model.addColumn("Marca");
				model.addColumn("Estado");
				scrollPane.setViewportView(tbDevice);
			}
		}
		adjustTable(scrollPane, tbDevice);
		{
			cbFiltro = new JComboBox<String>();
			cbFiltro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedCbFiltroJComboBox(e);
				}
			});
			cbFiltro.setModel(new DefaultComboBoxModel<String>(new String[] { "Todos", "Nuevo Ingreso", "No Reparado",
					"En Revisi\u00F3n", "Reparado", "Entregado" }));
			cbFiltro.setForeground(Color.DARK_GRAY);
			cbFiltro.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cbFiltro.setFocusable(false);
			cbFiltro.setBorder(new LineBorder(new Color(0, 0, 0)));
			cbFiltro.setBackground(new Color(245, 245, 245));
			cbFiltro.setBounds(276, 20, 188, 35);
			contentPanel.add(cbFiltro);
		}
		loadDevices();
	}

	// EVENTOS

	protected void actionPerformedBtnVolverJButton(ActionEvent e) {
		dispose();
	}

	protected void mousePressedTbUserJTable(MouseEvent e) {
		int fila_point = tbDevice.rowAtPoint(e.getPoint());
		int columna_point = 0;

		if (fila_point > -1) {

			int id = (int) model.getValueAt(fila_point, columna_point);

			Factory dao = Factory
					.getDAOFactory(Factory.MYSQL5);/* Bd con la cual trabajar */
			clsDevice d = dao.getDeviceDAO().search(id);

			new informationDevice(this, true, d).setVisible(true);

		}
	}

	protected void actionPerformedCbFiltroJComboBox(ActionEvent e) {
		// FILTRO EN JTABLE DESDE JCOMBO BOX

		String query;
		switch (cbFiltro.getSelectedIndex()) {
		case 1:
			query = "Nuevo Ingreso";
			break;
		case 2:
			query = "No Reparado";
			break;
		case 3:
			query = "En Revisión";
			break;
		case 4:
			query = "Reparado";
			break;
		case 5:
			query = "Entregado";
			break;
		default:
			query = "Todos";
		}

		TableRowSorter<TableModel> tr = new TableRowSorter<TableModel>(model);
		tbDevice.setRowSorter(tr);

		if (query != "Todos") {
			tr.setRowFilter(RowFilter.regexFilter(query));
		} else {
			tbDevice.setRowSorter(tr);
		}
	}
	// MÉTODOS

	private void adjustTable(JScrollPane scroll, JTable table) {

		Dimension tableSize = scroll.getPreferredSize();
		table.getColumnModel().getColumn(0).setPreferredWidth(Math.round(tableSize.width * 0.10f));
		table.getColumnModel().getColumn(1).setPreferredWidth(Math.round(tableSize.width * 0.37f));
		table.getColumnModel().getColumn(2).setPreferredWidth(Math.round(tableSize.width * 0.37f));
		table.getColumnModel().getColumn(3).setPreferredWidth(Math.round(tableSize.width * 0.36f));

		DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
		tcr1.setHorizontalAlignment(SwingConstants.CENTER);
		tcr1.setBackground(Color.BLACK);
		tcr1.setForeground(Color.white);
		for (int i = 0; i < 4; i++) {
			table.getColumnModel().getColumn(i).setHeaderRenderer(tcr1);
		}
	}

	private void loadDevices() {
		model.setRowCount(0);
		List<clsDevice> lista = new ArrayList<>();

		try {
			Factory dao = Factory
					.getDAOFactory(Factory.MYSQL5);/* Bd con la cual trabajar */

			lista = dao.getDeviceDAO().listadoDevice();

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
				Object[] fila = { d.getIdDevice(), tipo, marca, estado };
				model.addRow(fila);
			}

		} catch (Exception e) {
			// System.out.println("Equipoa");
		}
	}

	protected void windowActivatedThisJDialog(WindowEvent arg0) {
		if (informationDevice.equipo) {
			loadDevices();
			informationDevice.equipo = false;
			// System.out.println("Actualizando clientes");
		}
	}
}
