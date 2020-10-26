package com.mrrobot.viewAdmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.mrrobot.model.Sesion;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class game extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVolver;
	private JLabel lblCar1;
	private JLabel lblCar2;
	private JLabel lblCar3;
	private JLabel lblCar4;
	private JButton btnGo;
	private JButton btnBack;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JLabel label;

	public static void main(String[] args) {
		try {
			game dialog = new game(null, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public game(JFrame frame, boolean modal) {
		super(frame, modal);
		try {
			setTitle("Juego - Sesión de " + Sesion.getSesion().getUser().getNick());
		} catch (Exception e) {
			setTitle("Juego - Sesión Prueba");
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/com/mrrobot/images/icono.png")));
		setBounds(100, 100, 500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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
			btnVolver.setForeground(Color.WHITE);
			btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnVolver.setFocusable(false);
			btnVolver.setBorder(new LineBorder(Color.WHITE));
			btnVolver.setBackground(Color.DARK_GRAY);
			btnVolver.setBounds(319, 408, 150, 30);
			contentPanel.add(btnVolver);
		}
		{
			lblCar1 = new JLabel("");
			lblCar1.setIcon(new ImageIcon(game.class.getResource("/com/mrrobot/images/carB.png")));
			lblCar1.setBounds(20, 58, 40, 20);
			contentPanel.add(lblCar1);
		}
		{
			lblCar2 = new JLabel("");
			lblCar2.setIcon(new ImageIcon(game.class.getResource("/com/mrrobot/images/carM.png")));
			lblCar2.setBounds(20, 108, 40, 20);
			contentPanel.add(lblCar2);
		}
		{
			lblCar3 = new JLabel("");
			lblCar3.setIcon(new ImageIcon(game.class.getResource("/com/mrrobot/images/carC.png")));
			lblCar3.setBounds(20, 158, 40, 20);
			contentPanel.add(lblCar3);
		}
		{
			lblCar4 = new JLabel("");
			lblCar4.setIcon(new ImageIcon(game.class.getResource("/com/mrrobot/images/carL.png")));
			lblCar4.setBounds(20, 208, 40, 20);
			contentPanel.add(lblCar4);
		}
		{
			btnGo = new JButton("INICIAR");
			btnGo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnGo.setBackground(Color.GRAY);
			btnGo.setForeground(Color.WHITE);
			btnGo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnGo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actionPerformedBtnNewButtonJButton(arg0);
				}
			});
			btnGo.setBounds(319, 326, 150, 30);
			contentPanel.add(btnGo);
		}
		{
			btnBack = new JButton("REINICIAR");
			btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnBack.setBackground(Color.GRAY);
			btnBack.setForeground(Color.WHITE);
			btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnBack.setEnabled(false);
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actionPerformedBtnNewButton_1JButton(arg0);
				}
			});
			btnBack.setBounds(319, 367, 150, 30);
			contentPanel.add(btnBack);
		}
		{
			textArea = new JTextArea();
			textArea.setBackground(Color.LIGHT_GRAY);
			textArea.setEditable(false);
			textArea.setForeground(Color.BLACK);
			textArea.setFont(new Font("Californian FB", Font.PLAIN, 15));
			textArea.setBounds(20, 248, 245, 76);
			contentPanel.add(textArea);
		}
		{
			textArea_1 = new JTextArea();
			textArea_1.setBackground(Color.LIGHT_GRAY);
			textArea_1.setEditable(false);
			textArea_1.setForeground(Color.BLACK);
			textArea_1.setFont(new Font("Californian FB", Font.PLAIN, 15));
			textArea_1.setBounds(20, 346, 245, 92);
			contentPanel.add(textArea_1);
		}
		{
			label = new JLabel(" ");
			label.setIcon(new ImageIcon(game.class.getResource("/com/mrrobot/images/campo.png")));
			label.setBackground(Color.WHITE);
			label.setBounds(0, 0, 494, 239);
			contentPanel.add(label);
		}
		{
			lblRonda = new JLabel("Ronda 1 de 5");
			lblRonda.setForeground(Color.BLACK);
			lblRonda.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblRonda.setHorizontalAlignment(SwingConstants.CENTER);
			lblRonda.setBounds(20, 326, 245, 20);
			contentPanel.add(lblRonda);
		}

	}

	// EVENTOS

	protected void actionPerformedBtnVolverJButton(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnNewButton_1JButton(ActionEvent arg0) {

		contador++;
		lblRonda.setText("Ronda " + contador + " de 5");
		if (contador == 6)
			lblRonda.setText("Resultado final");
		sumarPuntos(textArea, textArea_1);
		textArea.setText("");
		reiniciar();
		btnBack.setEnabled(false);
		btnGo.setEnabled(true);
	}

	protected void actionPerformedBtnNewButtonJButton(ActionEvent arg0) {

		if (contador == 6) {
			for (int i = 0; i < 4; i++) {
				tiempo[i] = 0;
				puntos[i] = 0;
			}
			contador = 1;
			lblRonda.setText("Ronda 1 de 5");
			textArea.setText("");
			textArea_1.setText("");
		}
		btnBack.setEnabled(false);
		btnGo.setEnabled(false);

		Runnable[] x = { new Carro("Bugatti", lblCar1, textArea, btnBack),
				new Carro("Mercedes", lblCar2, textArea, btnBack), new Carro("Chevrolet", lblCar3, textArea, btnBack),
				new Carro("Lamborghini", lblCar4, textArea, btnBack) };
		hilos = new Thread[x.length];

		for (int i = 0; i < hilos.length; i++) {
			hilos[i] = new Thread(x[i]);
			hilos[i].start();
		}

	}

	// METODOS

	private void reiniciar() {

		lblCar1.setLocation(20, lblCar1.getY());
		lblCar2.setLocation(20, lblCar2.getY());
		lblCar3.setLocation(20, lblCar3.getY());
		lblCar4.setLocation(20, lblCar4.getY());
	}

	private void sumarPuntos(JTextArea t1, JTextArea t2) {
		double tiempo1 = Double.parseDouble(t1.getText().substring(9, 14));
		double tiempo2 = Double.parseDouble(t1.getText().substring(45, 50));
		double tiempo3 = Double.parseDouble(t1.getText().substring(81, 86));
		double tiempo4 = Double.parseDouble(t1.getText().substring(117, 122));

		switch (t1.getText().substring(24, 25)) {
		case "B":
			tiempo[0] += tiempo1;
			puntos[0] += 4;
			break;
		case "M":
			tiempo[1] += tiempo1;
			puntos[1] += 4;
			break;
		case "C":
			tiempo[2] += tiempo1;
			puntos[2] += 4;
			break;
		case "L":
			tiempo[3] += tiempo1;
			puntos[3] += 4;
			break;
		}
		switch (t1.getText().substring(60, 61)) {
		case "B":
			tiempo[0] += tiempo2;
			puntos[0] += 3;
			break;
		case "M":
			tiempo[1] += tiempo2;
			puntos[1] += 3;
			break;
		case "C":
			tiempo[2] += tiempo2;
			puntos[2] += 3;
			break;
		case "L":
			tiempo[3] += tiempo2;
			puntos[3] += 3;
			break;
		}
		switch (t1.getText().substring(96, 97)) {
		case "B":
			tiempo[0] += tiempo3;
			puntos[0] += 2;
			break;
		case "M":
			tiempo[1] += tiempo3;
			puntos[1] += 2;
			break;
		case "C":
			tiempo[2] += tiempo3;
			puntos[2] += 2;
			break;
		case "L":
			tiempo[3] += tiempo3;
			puntos[3] += 2;
			break;
		}
		switch (t1.getText().substring(132, 133)) {
		case "B":
			tiempo[0] += tiempo4;
			puntos[0] += 1;
			break;
		case "M":
			tiempo[1] += tiempo4;
			puntos[1] += 1;
			break;
		case "C":
			tiempo[2] += tiempo4;
			puntos[2] += 1;
			break;
		case "L":
			tiempo[3] += tiempo4;
			puntos[3] += 1;
			break;
		}

		t2.setText("Ranking :");
		t2.append("\nBuggati --- " + puntos[0] + " ptos. --- " + tiempo[0] + "ms");
		t2.append("\nMercedes --- " + puntos[1] + " ptos. --- " + tiempo[1] + "ms");
		t2.append("\nChevrolet --- " + puntos[2] + " ptos. --- " + tiempo[2] + "ms");
		t2.append("\nLamborghini --- " + puntos[3] + " ptos. --- " + tiempo[3] + "ms");

	}

	int contador = 1;
	double[] tiempo = new double[4];
	int[] puntos = new int[4]; // b-m-c-l
	Thread[] hilos;
	private JLabel lblRonda;
}

// CLASE AYUDA

class Carro implements Runnable {
	public Carro(String name, Component componente, JTextArea textArea, JButton boton) {
		this.boton = boton;
		this.area = textArea;
		this.name = name;
		this.componente = componente;
	}

	public void run() {

		long tiempoInicio = System.currentTimeMillis();

		while (componente.getX() < 434) {

			int cantidad = componente.getX() + (int) (Math.random() * 5);
			componente.setLocation(cantidad, componente.getY());

			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

		}

		long totalTiempo = System.currentTimeMillis() - tiempoInicio;
		area.append(
				"Tiempo : " + String.format("%05d", totalTiempo) + " ms  ---  " + String.format("%-11s", name) + "\n");

		boton.setEnabled(true);

	}

	public String getName() {
		return name;
	}

	private JButton boton;
	private JTextArea area;
	private String name;
	private Component componente;
}
