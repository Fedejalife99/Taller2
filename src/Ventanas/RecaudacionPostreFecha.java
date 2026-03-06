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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SpinnerDateModel;

import Controladores.ControladorRecaudacionPostreFecha;
import Logica.Objetos.IFachada;
import Logica.Objetos.Exceptions.FechaInvalidaException;
import Logica.Objetos.Exceptions.PostreNoExisteException;
import Logica.Objetos.VObjects.VORecaudacionPostreFecha;

public class RecaudacionPostreFecha {

	JFrame frame;
	private JTextField txtCodigo;
	private JSpinner spinnerFecha;
	private JTextArea txtAreaResultado;
	private ControladorRecaudacionPostreFecha controlador;

	public RecaudacionPostreFecha(IFachada fachada) {
		this.controlador = new ControladorRecaudacionPostreFecha(fachada);
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(35, 42, 64));
		frame.setBounds(100, 100, 480, 380);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Recaudación por postre y fecha");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(10, 11, 350, 20);
		frame.getContentPane().add(lblTitulo);

		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(10, 50, 70, 20);
		frame.getContentPane().add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(85, 47, 355, 25);
		frame.getContentPane().add(txtCodigo);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFecha.setBounds(10, 95, 70, 20);
		frame.getContentPane().add(lblFecha);

		spinnerFecha = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy");
		spinnerFecha.setEditor(editor);
		spinnerFecha.setBounds(85, 92, 150, 25);
		frame.getContentPane().add(spinnerFecha);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(32, 90, 140));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setOpaque(true);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBounds(10, 140, 100, 27);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		frame.getContentPane().add(btnBuscar);

		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setForeground(Color.WHITE);
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResultado.setBounds(10, 180, 100, 20);
		frame.getContentPane().add(lblResultado);

		txtAreaResultado = new JTextArea();
		txtAreaResultado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAreaResultado.setEditable(false);
		txtAreaResultado.setBackground(Color.WHITE);
		txtAreaResultado.setForeground(new Color(35, 42, 64));
		txtAreaResultado.setLineWrap(true);
		txtAreaResultado.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(txtAreaResultado);
		scrollPane.setBounds(10, 205, 440, 110);
		frame.getContentPane().add(scrollPane);
	}

	private void buscar() {
		// convertir Date del spinner a LocalDate
		Date fechaSeleccionada = (Date) spinnerFecha.getValue();
		LocalDate fecha = fechaSeleccionada.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();

		try {
			VORecaudacionPostreFecha resultado = controlador.recaudacionPostreFecha(
				txtCodigo.getText().trim(),
				fecha
			);
			mostrarResultado(resultado);
		} catch (PostreNoExisteException e) {
			JOptionPane.showMessageDialog(frame, "Error: No existe un postre con ese código.", "Error", JOptionPane.ERROR_MESSAGE);
			txtAreaResultado.setText("");
		} catch (FechaInvalidaException e) {
			JOptionPane.showMessageDialog(frame, "Error: La fecha ingresada no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
			txtAreaResultado.setText("");
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			txtAreaResultado.setText("");
		}
	}

	private void mostrarResultado(VORecaudacionPostreFecha resultado) {
		StringBuilder sb = new StringBuilder();
		sb.append("Monto total:     ").append(resultado.getMontoTotal()).append("\n\n");
		sb.append("Cantidad total:  ").append(resultado.getCantidadTotal());
		txtAreaResultado.setText(sb.toString());
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}