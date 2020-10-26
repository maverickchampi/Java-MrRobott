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
import com.mrrobot.dao.Factory;
import com.mrrobot.model.Sesion;
import com.mrrobot.model.clsUser;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class gestionUser extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JLabel lblSeleccioneUsuarioPara;
	private JScrollPane scrollPane;
	private JTable tbUser;
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
			gestionUser dialog = new gestionUser(null, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public gestionUser(JFrame frame, boolean modal) {
		super(frame, modal);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				windowActivatedThisJDialog(arg0);
			}
		});
		try {
			setTitle("Gestion de usuarios - Sesión de " + Sesion.getSesion().getUser().getNick());
		} catch (Exception e) {
			setTitle("Gestion de usuarios - Sesión Prueba");
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
			lblSeleccioneUsuarioPara = new JLabel("Seleccione usuario para m\u00E1s informaci\u00F3n");
			lblSeleccioneUsuarioPara.setHorizontalAlignment(SwingConstants.CENTER);
			lblSeleccioneUsuarioPara.setForeground(Color.DARK_GRAY);
			lblSeleccioneUsuarioPara.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblSeleccioneUsuarioPara.setBounds(30, 20, 434, 26);
			contentPanel.add(lblSeleccioneUsuarioPara);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(30, 75, 434, 293);
			contentPanel.add(scrollPane);
			{
				tbUser = new JTable(model);
				tbUser.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						mousePressedTbUserJTable(arg0);
					}
				});
				tbUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				tbUser.setSelectionBackground(Color.LIGHT_GRAY);
				tbUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tbUser.setForeground(Color.BLACK);
				tbUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
				model.addColumn("Id");
				model.addColumn("Nombre");
				model.addColumn("Usuario");
				model.addColumn("Nivel");
				model.addColumn("Estado");
				scrollPane.setViewportView(tbUser);
			}
		}
		adjustTable(scrollPane, tbUser);
		loadUsers();
	}

	// EVENTOS

	protected void actionPerformedBtnVolverJButton(ActionEvent e) {
		dispose();
	}

	protected void mousePressedTbUserJTable(MouseEvent e) {
		int fila_point = tbUser.rowAtPoint(e.getPoint());
		int columna_point = 2;

		if (fila_point > -1) {

			String nickname = (String) model.getValueAt(fila_point, columna_point);

			Factory dao = Factory.getDAOFactory(
					Factory.MYSQL5);/* Base de datos con la cual trabajar */
			clsUser u = dao.getUserDAO().searchUser(nickname);

			new informationUser(this, true, u).setVisible(true);

		}
	}
	// MÉTODOS

	private void adjustTable(JScrollPane scroll, JTable table) {

		Dimension tableSize = scroll.getPreferredSize();
		table.getColumnModel().getColumn(0).setPreferredWidth(Math.round(tableSize.width * 0.05f));
		table.getColumnModel().getColumn(1).setPreferredWidth(Math.round(tableSize.width * 0.30f));
		table.getColumnModel().getColumn(2).setPreferredWidth(Math.round(tableSize.width * 0.24f));
		table.getColumnModel().getColumn(3).setPreferredWidth(Math.round(tableSize.width * 0.20f));
		table.getColumnModel().getColumn(4).setPreferredWidth(Math.round(tableSize.width * 0.11f));

		DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
		tcr1.setHorizontalAlignment(SwingConstants.CENTER);
		tcr1.setBackground(Color.BLACK);
		tcr1.setForeground(Color.white);
		for (int i = 0; i < 5; i++) {
			table.getColumnModel().getColumn(i).setHeaderRenderer(tcr1);
		}
	}

	private void loadUsers() {
		model.setRowCount(0);
		List<clsUser> lista = new ArrayList<>();

		try {
			Factory dao = Factory
					.getDAOFactory(Factory.MYSQL5);/* Bd con la cual trabajar */

			lista = dao.getUserDAO().listadoUser();

			for (clsUser u : lista) {

				String nivel = "";
				switch (u.getNivel()) {
				case 0:
					nivel = "Administrador";
					break;
				case 1:
					nivel = "Capturista";
					break;
				default:
					nivel = "Técnico";
					break;
				}

				String estado = "Inactivo";
				if (u.isStatus())
					estado = "Activo";

				Object[] fila = { u.getidUser(), u.getName(), u.getNick(), nivel, estado };
				model.addRow(fila);
			}
		} catch (Exception e) {
			// System.out.println("Usuarios");
		}
	}

	protected void windowActivatedThisJDialog(WindowEvent arg0) {
		if (informationUser.info) {
			loadUsers();
			informationUser.info = false;
//			System.out.println("Actualizando usuarios");
		}
	}
}
