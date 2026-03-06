package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import Controladores.ControladorIngresarVenta;
import Logica.Objetos.IFachada;

public class IngresarVenta {

	JFrame frame;
	private JTextField txtDireccion;
	private JSpinner spinnerFecha;
	private ControladorIngresarVenta controlador;

	public IngresarVenta(IFachada fachada) {
		this.controlador = new ControladorIngresarVenta(fachada);
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(35, 42, 64));
		frame.setBounds(100, 100, 450, 280);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Ingresar venta");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(10, 11, 200, 20);
		frame.getContentPane().add(lblTitulo);

		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDireccion.setBounds(10, 55, 80, 20);
		frame.getContentPane().add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(100, 52, 310, 25);
		frame.getContentPane().add(txtDireccion);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFecha.setBounds(10, 100, 80, 20);
		frame.getContentPane().add(lblFecha);

		// SpinnerDateModel para seleccionar fecha
		spinnerFecha = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy");
		spinnerFecha.setEditor(editor);
		spinnerFecha.setBounds(100, 97, 150, 25);
		frame.getContentPane().add(spinnerFecha);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(new Color(32, 90, 140));
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setOpaque(true);
		btnConfirmar.setBorderPainted(false);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConfirmar.setBounds(100, 155, 120, 30);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Convertir Date del spinner a LocalDate
				Date fechaSeleccionada = (Date) spinnerFecha.getValue();
				LocalDate fecha = fechaSeleccionada.toInstant()
						.atZone(ZoneId.systemDefault())
						.toLocalDate();

				String resultado = controlador.ingresarVenta(
					txtDireccion.getText().trim(),
					fecha
				);

				if (resultado.equals("ok")) {
					JOptionPane.showMessageDialog(frame, "Venta ingresada correctamente.");
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
		txtDireccion.setText("");
		spinnerFecha.setValue(new Date());
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}