package Ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import Logica.Objetos.IFachada;

public class MenuPrincipal {

	JFrame frame;
	private IFachada fachada;

	public MenuPrincipal(IFachada fachada) {
		this.fachada = fachada;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(35, 42, 64));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnIngresarPostre = new JButton("Ingresar postre");
		btnIngresarPostre.setOpaque(true);
		btnIngresarPostre.setBorderPainted(false);
		btnIngresarPostre.setBackground(new Color(32, 90, 140));
		btnIngresarPostre.setForeground(Color.WHITE);
		btnIngresarPostre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresarPostre ventana = new IngresarPostre(fachada);
				ventana.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnIngresarPostre);

		JButton btnNuevaVenta = new JButton("Nueva venta");
		btnNuevaVenta.setOpaque(true);
		btnNuevaVenta.setBorderPainted(false);
		btnNuevaVenta.setBackground(new Color(32, 90, 140));
		btnNuevaVenta.setForeground(Color.WHITE);
		btnNuevaVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresarVenta ventana = new IngresarVenta(fachada);
				ventana.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnNuevaVenta);

		JButton btnDetallePostre = new JButton("Detalle postre");
		btnDetallePostre.setOpaque(true);
		btnDetallePostre.setBorderPainted(false);
		btnDetallePostre.setBackground(new Color(32, 90, 140));
		btnDetallePostre.setForeground(Color.WHITE);
		btnDetallePostre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetallePostre ventana = new DetallePostre(fachada);
				ventana.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnDetallePostre);

		JButton btnListarPostres = new JButton("Listar postres");
		btnListarPostres.setOpaque(true);
		btnListarPostres.setBorderPainted(false);
		btnListarPostres.setBackground(new Color(32, 90, 140));
		btnListarPostres.setForeground(Color.WHITE);
		btnListarPostres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPostres ventana = new ListarPostres(fachada);
				ventana.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnListarPostres);

		JButton btnAgregarPostreVenta = new JButton("Agregar postre a venta");
		btnAgregarPostreVenta.setOpaque(true);
		btnAgregarPostreVenta.setBorderPainted(false);
		btnAgregarPostreVenta.setBackground(new Color(32, 90, 140));
		btnAgregarPostreVenta.setForeground(Color.WHITE);
		btnAgregarPostreVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarPostreVenta ventana = new AgregarPostreVenta(fachada);
				ventana.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnAgregarPostreVenta);

		JButton btnEliminarPostresVenta = new JButton("Eliminar postres de Venta");
		btnEliminarPostresVenta.setOpaque(true);
		btnEliminarPostresVenta.setBorderPainted(false);
		btnEliminarPostresVenta.setBackground(new Color(32, 90, 140));
		btnEliminarPostresVenta.setForeground(Color.WHITE);
		btnEliminarPostresVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarPostresVenta ventana = new EliminarPostresVenta(fachada);
				ventana.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnEliminarPostresVenta);

		JButton btnFinalizarVenta = new JButton("Finalizar Venta");
		btnFinalizarVenta.setOpaque(true);
		btnFinalizarVenta.setBorderPainted(false);
		btnFinalizarVenta.setBackground(new Color(32, 90, 140));
		btnFinalizarVenta.setForeground(Color.WHITE);
		btnFinalizarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinalizarVenta ventana = new FinalizarVenta(fachada);
				ventana.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnFinalizarVenta);

		JButton btnListarVentas = new JButton("Listar ventas");
		btnListarVentas.setOpaque(true);
		btnListarVentas.setBorderPainted(false);
		btnListarVentas.setBackground(new Color(32, 90, 140));
		btnListarVentas.setForeground(Color.WHITE);
		btnListarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarVentas ventana = new ListarVentas(fachada);
				ventana.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnListarVentas);

		JButton btnPostresDeVenta = new JButton("Postres de una venta");
		btnPostresDeVenta.setOpaque(true);
		btnPostresDeVenta.setBorderPainted(false);
		btnPostresDeVenta.setBackground(new Color(32, 90, 140));
		btnPostresDeVenta.setForeground(Color.WHITE);
		btnPostresDeVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostresDeVenta ventana = new PostresDeVenta(fachada);
				ventana.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnPostresDeVenta);

		JButton btnRecaudacion = new JButton("Recaudacion por fecha");
		btnRecaudacion.setOpaque(true);
		btnRecaudacion.setBorderPainted(false);
		btnRecaudacion.setBackground(new Color(32, 90, 140));
		btnRecaudacion.setForeground(Color.WHITE);
		btnRecaudacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecaudacionPostreFecha ventana = new RecaudacionPostreFecha(fachada);
				ventana.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnRecaudacion);

		JButton btnRespaldarDatos = new JButton("Respaldar datos");
		btnRespaldarDatos.setOpaque(true);
		btnRespaldarDatos.setBorderPainted(false);
		btnRespaldarDatos.setBackground(new Color(32, 90, 140));
		btnRespaldarDatos.setForeground(Color.WHITE);
		btnRespaldarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fachada.RespaldarDatos();
					javax.swing.JOptionPane.showMessageDialog(frame, "Datos respaldados correctamente.");
				} catch (Exception ex) {
					javax.swing.JOptionPane.showMessageDialog(frame, "Error al respaldar: " + ex.getMessage());
				}
			}
		});
		frame.getContentPane().add(btnRespaldarDatos);
	}
	public void setVisible(boolean visible) {
	    frame.setVisible(visible);
	}
}