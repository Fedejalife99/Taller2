package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controladores.ControladorFinalizarVenta;
import Logica.Objetos.IFachada;

public class FinalizarVenta {

	JFrame frame;
	private JTextField txtNumVenta;
	private JCheckBox chkCancela;
	private ControladorFinalizarVenta controlador;

	public FinalizarVenta(IFachada fachada) {
		this.controlador = new ControladorFinalizarVenta(fachada);
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(35, 42, 64));
		frame.setBounds(100, 100, 450, 260);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Finalizar venta");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(10, 11, 200, 20);
		frame.getContentPane().add(lblTitulo);

		JLabel lblNumVenta = new JLabel("Núm. venta:");
		lblNumVenta.setForeground(Color.WHITE);
		lblNumVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumVenta.setBounds(10, 55, 100, 20);
		frame.getContentPane().add(lblNumVenta);

		txtNumVenta = new JTextField();
		txtNumVenta.setBounds(115, 52, 295, 25);
		frame.getContentPane().add(txtNumVenta);

		chkCancela = new JCheckBox("¿Cancela?");
		chkCancela.setBackground(new Color(35, 42, 64));
		chkCancela.setForeground(Color.WHITE);
		chkCancela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkCancela.setBounds(10, 100, 150, 25);
		frame.getContentPane().add(chkCancela);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(new Color(32, 90, 140));
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setOpaque(true);
		btnConfirmar.setBorderPainted(false);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConfirmar.setBounds(100, 155, 120, 30);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resultado = controlador.finalizarVenta(
					txtNumVenta.getText().trim(),
					chkCancela.isSelected()
				);
				if (resultado.startsWith("ok:")) {
					double total = Double.parseDouble(resultado.substring(3));
					JOptionPane.showMessageDialog(frame, "Venta finalizada correctamente.\nMonto total: $" + total);
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
		btnLimpiar.setBounds(240, 155, 120, 30);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		frame.getContentPane().add(btnLimpiar);
	}

	private void limpiarCampos() {
		txtNumVenta.setText("");
		chkCancela.setSelected(false);
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}