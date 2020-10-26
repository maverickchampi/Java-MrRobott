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

public class graficoBrand extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JLabel lblGrficaDeMarcas;

	public static void main(String[] args) {
		try {
			graficoBrand dialog = new graficoBrand(null, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public graficoBrand(JDialog frame, boolean modal) {
		super(frame, modal);
		try {
			setTitle("Gráfico de Marcas - Sesión de " + Sesion.getSesion().getUser().getNick());
		} catch (Exception e) {
			setTitle("Gráfico de Marcas - Sesión Prueba");
		}

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(sesion_technical.class.getResource("/com/mrrobot/images/icono.png")));
		setBounds(100, 100, 800, 500);
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
			btnVolver.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnVolver.setFocusable(false);
			btnVolver.setBorder(new LineBorder(Color.WHITE));
			btnVolver.setBackground(Color.DARK_GRAY);
			btnVolver.setBounds(111, 402, 150, 40);
			contentPanel.add(btnVolver);
		}
		{
			lblGrficaDeMarcas = new JLabel("Gr\u00E1fica de Marcas");
			lblGrficaDeMarcas.setHorizontalAlignment(SwingConstants.CENTER);
			lblGrficaDeMarcas.setForeground(Color.DARK_GRAY);
			lblGrficaDeMarcas.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblGrficaDeMarcas.setBounds(50, 25, 262, 26);
			contentPanel.add(lblGrficaDeMarcas);
		}

	}

	// EVENTOS

	protected void actionPerformedBtnVolverJButton(ActionEvent e) {
		dispose();
	}

	// METODOS

	public void paint(Graphics g) {
		super.paint(g);

		ArrayList<Integer> listamarca = new ArrayList<Integer>();
		int total = 0;

		Factory dao = Factory
				.getDAOFactory(Factory.MYSQL5);/* Bd con la cual trabajar */
		ArrayList<clsDevice> lista = dao.getDeviceDAO().listadoDevice();

		for (int i = 0; i < 28; i++) /* Crea los campos para las marcas */
			listamarca.add(0);

		if (lista != null)
			for (clsDevice d : lista)
				listamarca.set(d.getBrand(), listamarca.get(d.getBrand())
						+ 1);/* Agrega +1 por cada marca presente */

		for (int i : listamarca)
			total += i; /* Indica el total de equipos */

		// PROCESO DE GRAFICO DE BARRAS

		String[] marcas = { "Acer", "Alcatel", "Alienware", "Apple", "Asus", "BlackBerry", "Canon", "Dell", "Epson",
				"Honor", "HP", "Huawei", "Lenovo", "LG", "Microsoft", "Motorola", "MSI", "Nokia", "OnePlus", "OPPO",
				"Razer", "Realme", "Samsung", "Sony", "Toshiba", "Vivo", "Xiaomi", "ZTE" };
		Color[] colores = { Color.WHITE, new Color(200, 0, 0), new Color(120, 0, 0), new Color(160, 150, 10),
				new Color(200, 100, 0), new Color(200, 0, 100), Color.BLUE, new Color(50, 150, 80),
				new Color(50, 100, 200), new Color(140, 150, 250), new Color(170, 70, 30), new Color(200, 150, 160),
				new Color(30, 30, 30), new Color(80, 80, 80), new Color(80, 180, 160), new Color(90, 150, 100),
				new Color(180, 180, 40), new Color(20, 180, 0), new Color(144, 180, 206), new Color(240, 101, 48),
				new Color(242, 239, 26), Color.GRAY, Color.CYAN, new Color(203, 26, 242), new Color(254, 103, 238),
				new Color(254, 103, 128),new Color(254, 176, 103),new Color(40, 226, 155)};

		int grado = 0;
		int grado2 = 0;
		int xTitle = 400;
		int yTitle = 44;
		int xColor = 370;
		int yColor = 30;
		int contador = 0;

		for (int i : listamarca) {/*
									 * Agrega el circulo y las leyendas depende
									 * de cada marca con su color
									 */
			grado2 = i * 360 / total;

			g.setColor(Color.BLACK);
			g.drawString(i + " de " + marcas[contador], xTitle, yTitle += 40);
			g.setColor(colores[contador]);
			g.fillArc(40, 105, 300, 300, grado, grado2);
			g.fillRect(xColor, yColor += 40, 20, 20);

			grado += grado2;

			contador++;

			if (contador % 10 == 0) {
				xTitle += 140;
				yTitle = 44;
				xColor += 140;
				yColor = 30;
			}
		}
	}
}
