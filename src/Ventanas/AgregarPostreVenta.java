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

import Controladores.ControladorAgregarPostresVenta;
import Logica.Objetos.IFachada;

public class AgregarPostreVenta {

	JFrame frame;
	private JTextField txtCodigoVenta;
	private JTextField txtCodigoPostre;
	private JTextField txtCantidad;
	private ControladorAgregarPostresVenta controlador;

	public AgregarPostreVenta(IFachada fachada) {
		this.controlador = new ControladorAgregarPostresVenta(fachada);
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(35, 42, 64));
		frame.setBounds(100, 100, 450, 320);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Agregar postre a venta");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(10, 11, 300, 20);
		frame.getContentPane().add(lblTitulo);

		JLabel lblCodigoVenta = new JLabel("Cód. venta:");
		lblCodigoVenta.setForeground(Color.WHITE);
		lblCodigoVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigoVenta.setBounds(10, 55, 90, 20);
		frame.getContentPane().add(lblCodigoVenta);

		txtCodigoVenta = new JTextField();
		txtCodigoVenta.setBounds(110, 52, 300, 25);
		frame.getContentPane().add(txtCodigoVenta);

		JLabel lblCodigoPostre = new JLabel("Cód. postre:");
		lblCodigoPostre.setForeground(Color.WHITE);
		lblCodigoPostre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigoPostre.setBounds(10, 100, 90, 20);
		frame.getContentPane().add(lblCodigoPostre);

		txtCodigoPostre = new JTextField();
		txtCodigoPostre.setBounds(110, 97, 300, 25);
		frame.getContentPane().add(txtCodigoPostre);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidad.setBounds(10, 145, 90, 20);
		frame.getContentPane().add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(110, 142, 300, 25);
		frame.getContentPane().add(txtCantidad);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(new Color(32, 90, 140));
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setOpaque(true);
		btnConfirmar.setBorderPainted(false);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConfirmar.setBounds(100, 200, 120, 30);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resultado = controlador.agregarPostreVenta(
					txtCodigoVenta.getText().trim(),
					txtCodigoPostre.getText().trim(),
					txtCantidad.getText().trim()
				);
				if (resultado.equals("ok")) {
					JOptionPane.showMessageDialog(frame, "Postre agregado correctamente.");
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
		txtCodigoVenta.setText("");
		txtCodigoPostre.setText("");
		txtCantidad.setText("");
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}










