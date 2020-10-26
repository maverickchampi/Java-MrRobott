package com.mrrobot.viewTechnical;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.mrrobot.dao.Factory;
import com.mrrobot.model.Sesion;
import com.mrrobot.model.clsDevice;

public class graficoStatus extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JLabel lblGrficaDeEstados;

	public static void main(String[] args) {
		try {
			graficoStatus dialog = new graficoStatus(null, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public graficoStatus(JDialog frame, boolean modal) {
		super(frame, modal);
		try {
			setTitle("Gráfico de Estados - Sesión de " + Sesion.getSesion().getUser().getNick());
		} catch (Exception e) {
			setTitle("Gráfico de Estados - Sesión Prueba");
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
			btnVolver.setBounds(147, 390, 200, 40);
			contentPanel.add(btnVolver);
		}
		{
			lblGrficaDeEstados = new JLabel("Gr\u00E1fica de Estados");
			lblGrficaDeEstados.setHorizontalAlignment(SwingConstants.CENTER);
			lblGrficaDeEstados.setForeground(Color.DARK_GRAY);
			lblGrficaDeEstados.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblGrficaDeEstados.setBounds(43, 24, 408, 26);
			contentPanel.add(lblGrficaDeEstados);
		}

	}

	// EVENTOS

	protected void actionPerformedBtnVolverJButton(ActionEvent e) {
		dispose();
	}

	// METODO PARA HALLAR EL VALOR MAYOR

	public int MayorValor(int nuevo_ingreso, int no_reparado, int en_revision, int reparado, int entregado) {
		if (nuevo_ingreso > no_reparado && nuevo_ingreso > en_revision && nuevo_ingreso > reparado
				&& nuevo_ingreso > entregado) {
			return nuevo_ingreso;
		} else if (no_reparado > en_revision && no_reparado > reparado && no_reparado > entregado) {
			return no_reparado;
		} else if (en_revision > reparado && en_revision > entregado) {
			return en_revision;
		} else if (reparado > entregado) {
			return reparado;
		} else {
			return entregado;
		}
	}

	public void paint(Graphics g) {
		super.paint(g);

		int nuevo_ingreso = 0;
		int no_reparado = 0;
		int en_revision = 0;
		int reparado = 0;
		int entregado = 0;

		Factory dao = Factory
				.getDAOFactory(Factory.MYSQL5);/* Bd con la cual trabajar */
		ArrayList<clsDevice> lista = dao.getDeviceDAO().listadoDevice();

		if (lista != null) {
			for (clsDevice d : lista) {
				switch (d.getStatus()) {
				case 0:
					nuevo_ingreso++;
					break;
				case 1:
					no_reparado++;
					break;
				case 2:
					en_revision++;
					break;
				case 3:
					reparado++;
					break;
				case 4:
					entregado++;
					break;
				}
			}

			// PROCESO DE GRAFICO DE BARRAS

			int valor_Mayor = MayorValor(nuevo_ingreso, no_reparado, en_revision, reparado, entregado);

			int l1 = nuevo_ingreso * 380 / valor_Mayor;
			int l2 = no_reparado * 380 / valor_Mayor;
			int l3 = en_revision * 380 / valor_Mayor;
			int l4 = reparado * 380 / valor_Mayor;
			int l5 = entregado * 380 / valor_Mayor;

			g.setColor(Color.BLUE);
			g.fillRect(100, 120, l1, 40);
			g.drawString("Nuevo Ingreso", 15, 140);
			g.drawString("Cantidad : " + nuevo_ingreso, 20, 155);

			g.setColor(Color.MAGENTA);
			g.fillRect(100, 170, l2, 40);
			g.drawString("No Reparado", 15, 190);
			g.drawString("Cantidad : " + no_reparado, 20, 205);

			g.setColor(new Color(0, 150, 150));
			g.fillRect(100, 220, l3, 40);
			g.drawString("En Revisión", 15, 240);
			g.drawString("Cantidad : " + en_revision, 20, 255);

			g.setColor(new Color(0, 150, 0));
			g.fillRect(100, 270, l4, 40);
			g.drawString("Reparado", 15, 290);
			g.drawString("Cantidad : " + reparado, 20, 305);

			g.setColor(Color.RED);
			g.fillRect(100, 320, l5, 40);
			g.drawString("Entregado", 15, 340);
			g.drawString("Cantidad : " + entregado, 20, 355);
		}
	}

}
