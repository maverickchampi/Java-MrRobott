package com.mrrobot.viewCapturist;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.mrrobot.dao.Factory;
import com.mrrobot.model.Sesion;
import com.mrrobot.model.clsClient;

public class gestionClient extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JLabel lblSeleccioneCliente;
	private JScrollPane scrollPane;
	private JTable tbClient;
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
			gestionClient dialog = new gestionClient(null, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public gestionClient(JDialog frame, boolean modal) {
		super(frame, modal);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				windowActivatedThisJDialog(arg0);
			}
		});
		try {
			setTitle("Gestion de clientes - Sesión de " + Sesion.getSesion().getUser().getNick());
		} catch (Exception e) {
			setTitle("Gestion de clientes - Sesión Prueba");
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
			lblSeleccioneCliente = new JLabel("Seleccione cliente para m\u00E1s informaci\u00F3n");
			lblSeleccioneCliente.setHorizontalAlignment(SwingConstants.CENTER);
			lblSeleccioneCliente.setForeground(Color.DARK_GRAY);
			lblSeleccioneCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblSeleccioneCliente.setBounds(30, 20, 434, 26);
			contentPanel.add(lblSeleccioneCliente);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(30, 75, 434, 293);
			contentPanel.add(scrollPane);
			{
				tbClient = new JTable(model);
				tbClient.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						mousePressedTbUserJTable(arg0);
					}
				});
				tbClient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				tbClient.setSelectionBackground(Color.LIGHT_GRAY);
				tbClient.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tbClient.setForeground(Color.BLACK);
				tbClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
				model.addColumn("Id");
				model.addColumn("Nombre");
				model.addColumn("Correo");
				model.addColumn("Teléfono");
				scrollPane.setViewportView(tbClient);
			}
		}
		adjustTable(scrollPane, tbClient);
		loadClients();
	}

	// EVENTOS

	protected void actionPerformedBtnVolverJButton(ActionEvent e) {
		dispose();
	}

	protected void mousePressedTbUserJTable(MouseEvent e) {
		int fila_point = tbClient.rowAtPoint(e.getPoint());
		int columna_point = 0;

		if (fila_point > -1) {

			int id = (int) model.getValueAt(fila_point, columna_point);

			Factory dao = Factory.getDAOFactory(
					Factory.MYSQL5);/* Base de datos con la cual trabajar */
			clsClient c = dao.getClientDAO().searchClient(id);

			new informationClient(this, true, c).setVisible(true);

		}
	}

	// MÉTODOS

	private void adjustTable(JScrollPane scroll, JTable table) {

		Dimension tableSize = scroll.getPreferredSize();
		table.getColumnModel().getColumn(0).setPreferredWidth(Math.round(tableSize.width * 0.10f));
		table.getColumnModel().getColumn(1).setPreferredWidth(Math.round(tableSize.width * 0.35f));
		table.getColumnModel().getColumn(2).setPreferredWidth(Math.round(tableSize.width * 0.40f));
		table.getColumnModel().getColumn(3).setPreferredWidth(Math.round(tableSize.width * 0.25f));

		DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
		tcr1.setHorizontalAlignment(SwingConstants.CENTER);
		tcr1.setBackground(Color.BLACK);
		tcr1.setForeground(Color.white);
		for (int i = 0; i < 4; i++) {
			table.getColumnModel().getColumn(i).setHeaderRenderer(tcr1);
		}
	}

	private void loadClients() {
		model.setRowCount(0);
		List<clsClient> lista = new ArrayList<>();

		try {
			Factory dao = Factory
					.getDAOFactory(Factory.MYSQL5);/* Bd con la cual trabajar */

			lista = dao.getClientDAO().listadoCLient();

				for (clsClient c : lista) {

					Object[] fila = { c.getidClient(), c.getName(), c.getEmail(), c.getPhone() };
					model.addRow(fila);
				}
			
		} catch (Exception e) {
//			 System.out.println("Usuarios");
		}
	}

	protected void windowActivatedThisJDialog(WindowEvent arg0) {
		if (informationClient.info) {
			loadClients();
			informationClient.info = false;
			// System.out.println("Actualizando clientes");
		}
	}
}
