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

public class IngresarPostre {

	private JFrame frame;
	private JLabel lblDescripcion;
	private JLabel lblEndulzante;
	private JTextField txtDescripcion;
	private JTextField txtEndulzante;
	private JRadioButton rdbtnLight;
	private JRadioButton rdbtnComun;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresarPostre window = new IngresarPostre();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IngresarPostre() {
		initialize();
		configurarVisibilidad();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(35, 42, 64));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 655, 826);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblTitulo = new JLabel("Ingresar postre");
		lblTitulo.setForeground(new Color(0, 128, 192));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTitulo.setBounds(92, 43, 198, 23);
		frame.getContentPane().add(lblTitulo);

		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		lblCodigo.setForeground(new Color(32, 90, 140));
		lblCodigo.setBounds(92, 144, 77, 36);
		frame.getContentPane().add(lblCodigo);

		JTextField txtCodigo = new JTextField();
		txtCodigo.setBounds(270, 144, 191, 36);
		frame.getContentPane().add(txtCodigo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(32, 90, 140));
		lblNombre.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		lblNombre.setBounds(92, 234, 77, 36);
		frame.getContentPane().add(lblNombre);

		JTextField txtNombre = new JTextField();
		txtNombre.setBounds(270, 234, 191, 36);
		frame.getContentPane().add(txtNombre);

		JLabel lblPrecioUnitario = new JLabel("Precio unitario:");
		lblPrecioUnitario.setForeground(new Color(32, 90, 140));
		lblPrecioUnitario.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		lblPrecioUnitario.setBounds(92, 317, 132, 36);
		frame.getContentPane().add(lblPrecioUnitario);

		JTextField txtPrecioUnitario = new JTextField();
		txtPrecioUnitario.setBounds(270, 317, 191, 36);
		frame.getContentPane().add(txtPrecioUnitario);

		JLabel lblTipoPostre = new JLabel("Tipo de postre:");
		lblTipoPostre.setForeground(new Color(32, 90, 140));
		lblTipoPostre.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
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
		lblDescripcion.setForeground(new Color(32, 90, 140));
		lblDescripcion.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		lblDescripcion.setBounds(92, 496, 132, 36);
		frame.getContentPane().add(lblDescripcion);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(270, 496, 191, 36);
		frame.getContentPane().add(txtDescripcion);

		lblEndulzante = new JLabel("Endulzante:");
		lblEndulzante.setForeground(new Color(32, 90, 140));
		lblEndulzante.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		lblEndulzante.setBounds(92, 584, 132, 36);
		frame.getContentPane().add(lblEndulzante);

		txtEndulzante = new JTextField();
		txtEndulzante.setBounds(270, 584, 191, 36);
		frame.getContentPane().add(txtEndulzante);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(188, 690, 191, 60);
		frame.getContentPane().add(btnNewButton);
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
}