package com.mrrobot.viewTechnical;

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
import java.awt.Cursor;
import com.mrrobot.model.Sesion;
import com.mrrobot.viewAdmin.index;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sesion_technical extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTitle;
	private JButton btnGestionEquipo;
	private JButton btnGraficoStatus;
	private JButton btnGraficoMarca;
	private JLabel lblGestEquip;
	private JLabel lblGrafEstad;
	private JLabel lblGrafMarc;
	private JButton btnOff;
	private JButton btnVolver;

	public static void main(String[] args) {
		try {
			sesion_technical dialog = new sesion_technical(null, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public sesion_technical(JFrame frame, boolean modal) {
		super(frame, modal);
		try {
			setTitle("Técnico - Sesión de " + Sesion.getSesion().getUser().getNick());
		} catch (Exception e) {
			setTitle("Técnico - Sesión Prueba");
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
			btnGestionEquipo = new JButton("");
			btnGestionEquipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnGestionEquipoJButton(e);
				}
			});
			btnGestionEquipo.setIcon(
					new ImageIcon(sesion_technical.class.getResource("/com/mrrobot/images/gestinodevice.png")));
			btnGestionEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnGestionEquipo.setFocusable(false);
			btnGestionEquipo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnGestionEquipo.setBackground(new Color(245, 245, 245));
			btnGestionEquipo.setBounds(33, 160, 120, 120);
			contentPanel.add(btnGestionEquipo);
		}
		{
			btnGraficoStatus = new JButton("");
			btnGraficoStatus.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnGraficoStatusJButton(e);
				}
			});
			btnGraficoStatus
					.setIcon(new ImageIcon(sesion_technical.class.getResource("/com/mrrobot/images/graficobarra.png")));
			btnGraficoStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnGraficoStatus.setFocusable(false);
			btnGraficoStatus.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnGraficoStatus.setBackground(new Color(245, 245, 245));
			btnGraficoStatus.setBounds(186, 160, 120, 120);
			contentPanel.add(btnGraficoStatus);
		}
		{
			btnGraficoMarca = new JButton("");
			btnGraficoMarca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnGraficoMarcaJButton(e);
				}
			});
			btnGraficoMarca.setIcon(
					new ImageIcon(sesion_technical.class.getResource("/com/mrrobot/images/graficocircular.png")));
			btnGraficoMarca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnGraficoMarca.setFocusable(false);
			btnGraficoMarca.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnGraficoMarca.setBackground(new Color(245, 245, 245));
			btnGraficoMarca.setBounds(339, 160, 120, 120);
			contentPanel.add(btnGraficoMarca);
		}

		{
			lblGestEquip = new JLabel("Gesti\u00F3n Equipos");
			lblGestEquip.setHorizontalAlignment(SwingConstants.CENTER);
			lblGestEquip.setForeground(Color.DARK_GRAY);
			lblGestEquip.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblGestEquip.setBounds(33, 291, 120, 21);
			contentPanel.add(lblGestEquip);
		}
		{
			lblGrafEstad = new JLabel("Gr\u00E1ficos Estados");
			lblGrafEstad.setHorizontalAlignment(SwingConstants.CENTER);
			lblGrafEstad.setForeground(Color.DARK_GRAY);
			lblGrafEstad.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblGrafEstad.setBounds(186, 291, 120, 21);
			contentPanel.add(lblGrafEstad);
		}
		{
			lblGrafMarc = new JLabel("Gr\u00E1ficos Marcas");
			lblGrafMarc.setHorizontalAlignment(SwingConstants.CENTER);
			lblGrafMarc.setForeground(Color.DARK_GRAY);
			lblGrafMarc.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblGrafMarc.setBounds(339, 291, 120, 21);
			contentPanel.add(lblGrafMarc);
		}
		{
			btnOff = new JButton("");
			btnOff.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actionPerformedBtnOffJButton(arg0);
				}
			});
			btnOff.setVisible(false);
			btnOff.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnOff.setIcon(new ImageIcon(sesion_technical.class.getResource("/com/mrrobot/images/admin.off.png")));
			btnOff.setFocusable(false);
			btnOff.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnOff.setBackground(new Color(245, 245, 245));
			btnOff.setBounds(426, 33, 33, 33);
			contentPanel.add(btnOff);
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
			btnVolver.setBounds(147, 389, 200, 40);
			contentPanel.add(btnVolver);
		}
		if (Sesion.getSesion().getUser() != null)
			if (Sesion.getSesion().getUser().getNivel() == 2) {
				btnOff.setVisible(true);
				btnVolver.setVisible(false);
			}
	}

	// EVENTOS

	protected void actionPerformedBtnGestionEquipoJButton(ActionEvent e) {
		new gestionEquipo(this, true).setVisible(true);
	}

	protected void actionPerformedBtnGraficoStatusJButton(ActionEvent e) {
		new graficoStatus(this, true).setVisible(true);
	}

	protected void actionPerformedBtnGraficoMarcaJButton(ActionEvent e) {
		new graficoBrand(this, true).setVisible(true);
	}

	protected void actionPerformedBtnOffJButton(ActionEvent arg0) {
		new index().setVisible(true);
		dispose();
	}

	protected void actionPerformedBtnVolverJButton(ActionEvent e) {
		dispose();
	}
}
