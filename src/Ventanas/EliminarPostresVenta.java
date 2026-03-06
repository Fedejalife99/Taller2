package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controladores.ControladorEliminarPostresVenta;
import Logica.Objetos.IFachada;

public class EliminarPostresVenta {

	JFrame frame;
	private JTextField txtCodigoPostre;
	private JTextField txtCantidad;
	private JTextField txtNumVenta;
	private ControladorEliminarPostresVenta controlador;

	public EliminarPostresVenta(IFachada fachada) {
		this.controlador = new ControladorEliminarPostresVenta(fachada);
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(35, 42, 64));
		frame.setBounds(100, 100, 450, 320);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Eliminar postres de venta");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(10, 11, 350, 20);
		frame.getContentPane().add(lblTitulo);

		JLabel lblCodigoPostre = new JLabel("Cód. postre:");
		lblCodigoPostre.setForeground(Color.WHITE);
		lblCodigoPostre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigoPostre.setBounds(10, 55, 100, 20);
		frame.getContentPane().add(lblCodigoPostre);

		txtCodigoPostre = new JTextField();
		txtCodigoPostre.setBounds(115, 52, 295, 25);
		frame.getContentPane().add(txtCodigoPostre);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidad.setBounds(10, 100, 100, 20);
		frame.getContentPane().add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(115, 97, 295, 25);
		frame.getContentPane().add(txtCantidad);

		JLabel lblNumVenta = new JLabel("Núm. venta:");
		lblNumVenta.setForeground(Color.WHITE);
		lblNumVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumVenta.setBounds(10, 145, 100, 20);
		frame.getContentPane().add(lblNumVenta);

		txtNumVenta = new JTextField();
		txtNumVenta.setBounds(115, 142, 295, 25);
		frame.getContentPane().add(txtNumVenta);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(new Color(32, 90, 140));
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setOpaque(true);
		btnConfirmar.setBorderPainted(false);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConfirmar.setBounds(100, 200, 120, 30);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resultado = controlador.eliminarPostresVenta(
					txtCodigoPostre.getText().trim(),
					txtCantidad.getText().trim(),
					txtNumVenta.getText().trim()
				);
				if (resultado.equals("ok")) {
					JOptionPane.showMessageDialog(frame, "Postres eliminados correctamente.");
					limpiarCampos();
				} else {
					JOptionPane.showMessageDialog(frame, resultado, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		frame.getContentPane().add(btnConfirmar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(new Color(32, 90, 140));
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setOpaque(true);
		btnLimpiar.setBorderPainted(false);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpiar.setBounds(240, 200, 120, 30);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		frame.getContentPane().add(btnLimpiar);
	}

	private void limpiarCampos() {
		txtCodigoPostre.setText("");
		txtCantidad.setText("");
		txtNumVenta.setText("");
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}