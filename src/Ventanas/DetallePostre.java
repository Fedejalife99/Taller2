package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controladores.ControladorPostreDetallado;
import Logica.Objetos.IFachada;
import Logica.Objetos.VObjects.VOPostreDetallado;
import Logica.Objetos.VObjects.VOPostreGeneral;

public class DetallePostre {

	JFrame frame;
	private JTextField txtCodigo;
	private JTextArea txtAreaResultado;
	private ControladorPostreDetallado controlador;

	public DetallePostre(IFachada fachada) {
		this.controlador = new ControladorPostreDetallado(fachada);
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(35, 42, 64));
		frame.setBounds(100, 100, 500, 420);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Detalle de postre");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(10, 11, 250, 20);
		frame.getContentPane().add(lblTitulo);

		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(10, 50, 60, 20);
		frame.getContentPane().add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(75, 47, 280, 25);
		frame.getContentPane().add(txtCodigo);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(32, 90, 140));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setOpaque(true);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBounds(365, 46, 100, 27);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		frame.getContentPane().add(btnBuscar);

		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setForeground(Color.WHITE);
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResultado.setBounds(10, 90, 100, 20);
		frame.getContentPane().add(lblResultado);

		txtAreaResultado = new JTextArea();
		txtAreaResultado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAreaResultado.setEditable(false);
		txtAreaResultado.setBackground(new Color(255, 255, 255));
		txtAreaResultado.setForeground(new Color(35, 42, 64));
		txtAreaResultado.setLineWrap(true);
		txtAreaResultado.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(txtAreaResultado);
		scrollPane.setBounds(10, 115, 455, 240);
		frame.getContentPane().add(scrollPane);
	}

	private void buscar() {
		try {
			VOPostreGeneral postre = controlador.buscarPostre(txtCodigo.getText().trim());
			mostrarResultado(postre);
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			txtAreaResultado.setText("");
		}
	}

	private void mostrarResultado(VOPostreGeneral postre) {
		StringBuilder sb = new StringBuilder();
		sb.append("Código:").append(postre.getCodigo()).append("\n\n");
		sb.append("Nombre:").append(postre.getNombre()).append("\n\n");
		sb.append("Precio:").append(postre.getPrecioUnitario()).append("\n\n");
		sb.append("Tipo:").append(postre.getTipo()).append("\n\n");

		if (postre instanceof VOPostreDetallado) {
			VOPostreDetallado detalle = (VOPostreDetallado) postre;
			sb.append("Endulzante:   ").append(detalle.getEndulzante()).append("\n\n");
			sb.append("Descripción:  ").append(detalle.getDescripcion());
		}

		txtAreaResultado.setText(sb.toString());
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}
