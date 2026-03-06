package Ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Controladores.ControladorIngresarPostre;
import Logica.Objetos.IFachada;

public class IngresarPostre {

	JFrame frame;
	private JLabel lblDescripcion;
	private JLabel lblEndulzante;
	private JTextField txtDescripcion;
	private JTextField txtEndulzante;
	private JRadioButton rdbtnLight;
	private JRadioButton rdbtnComun;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecioUnitario;
	private ControladorIngresarPostre controlador;

	public IngresarPostre(IFachada fachada) {
		this.controlador = new ControladorIngresarPostre(fachada);
		initialize();
		configurarVisibilidad();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(35, 42, 64));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 655, 826);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel lblTitulo = new JLabel("Ingresar postre");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 22));
		lblTitulo.setBounds(92, 43, 198, 23);
		frame.getContentPane().add(lblTitulo);

		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		lblCodigo.setForeground(new Color(255, 255, 255));
		lblCodigo.setBounds(92, 144, 77, 36);
		frame.getContentPane().add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(270, 144, 191, 36);
		frame.getContentPane().add(txtCodigo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		lblNombre.setBounds(92, 234, 77, 36);
		frame.getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(270, 234, 191, 36);
		frame.getContentPane().add(txtNombre);

		JLabel lblPrecioUnitario = new JLabel("Precio unitario:");
		lblPrecioUnitario.setForeground(new Color(255, 255, 255));
		lblPrecioUnitario.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		lblPrecioUnitario.setBounds(92, 317, 132, 36);
		frame.getContentPane().add(lblPrecioUnitario);

		txtPrecioUnitario = new JTextField();
		txtPrecioUnitario.setBounds(270, 317, 191, 36);
		frame.getContentPane().add(txtPrecioUnitario);

		JLabel lblTipoPostre = new JLabel("Tipo de postre:");
		lblTipoPostre.setForeground(new Color(255, 255, 255));
		lblTipoPostre.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		lblTipoPostre.setBounds(92, 402, 132, 36);
		frame.getContentPane().add(lblTipoPostre);

		rdbtnComun = new JRadioButton("Comun");
		rdbtnComun.setBounds(270, 413, 109, 23);
		rdbtnComun.setBackground(new Color(35, 42, 64));
		rdbtnComun.setForeground(Color.WHITE);
		frame.getContentPane().add(rdbtnComun);

		rdbtnLight = new JRadioButton("Light");
		rdbtnLight.setBounds(420, 413, 109, 23);
		rdbtnLight.setBackground(new Color(35, 42, 64));
		rdbtnLight.setForeground(Color.WHITE);
		frame.getContentPane().add(rdbtnLight);

		ButtonGroup grupoPosible = new ButtonGroup();
		grupoPosible.add(rdbtnComun);
		grupoPosible.add(rdbtnLight);

		lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setForeground(new Color(255, 255, 255));
		lblDescripcion.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		lblDescripcion.setBounds(92, 496, 132, 36);
		frame.getContentPane().add(lblDescripcion);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(270, 496, 191, 36);
		frame.getContentPane().add(txtDescripcion);

		lblEndulzante = new JLabel("Endulzante:");
		lblEndulzante.setForeground(new Color(255, 255, 255));
		lblEndulzante.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		lblEndulzante.setBounds(92, 584, 132, 36);
		frame.getContentPane().add(lblEndulzante);

		txtEndulzante = new JTextField();
		txtEndulzante.setBounds(270, 584, 191, 36);
		frame.getContentPane().add(txtEndulzante);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnConfirmar.setBackground(new Color(32, 90, 140));
		btnConfirmar.setForeground(new Color(64, 0, 128));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resultado = controlador.ingresarPostre(
					txtCodigo.getText(),
					txtNombre.getText(),
					txtPrecioUnitario.getText(),
					rdbtnLight.isSelected(),
					txtEndulzante.getText(),
					txtDescripcion.getText()
				);

				if (resultado.equals("ok")) {
					JOptionPane.showMessageDialog(frame, "Postre ingresado correctamente.");
					limpiarCampos();
				} else {
					JOptionPane.showMessageDialog(frame, resultado, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnConfirmar.setBounds(188, 690, 191, 60);
		frame.getContentPane().add(btnConfirmar);
	}

	private void configurarVisibilidad() {
		lblDescripcion.setVisible(false);
		txtDescripcion.setVisible(false);
		lblEndulzante.setVisible(false);
		txtEndulzante.setVisible(false);

		rdbtnLight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDescripcion.setVisible(true);
				txtDescripcion.setVisible(true);
				lblEndulzante.setVisible(true);
				txtEndulzante.setVisible(true);
			}
		});

		rdbtnComun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDescripcion.setVisible(false);
				txtDescripcion.setVisible(false);
				lblEndulzante.setVisible(false);
				txtEndulzante.setVisible(false);
			}
		});
	}

	private void limpiarCampos() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtPrecioUnitario.setText("");
		txtDescripcion.setText("");
		txtEndulzante.setText("");
		rdbtnComun.setSelected(false);
		rdbtnLight.setSelected(false);
		lblDescripcion.setVisible(false);
		txtDescripcion.setVisible(false);
		lblEndulzante.setVisible(false);
		txtEndulzante.setVisible(false);
	}
}