package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controladores.ControladorPostresDeVenta;
import Logica.Objetos.IFachada;
import Logica.Objetos.Exceptions.VentaNoExisteException;
import Logica.Objetos.VObjects.VOPostresCant;

public class PostresDeVenta {

	JFrame frame;
	private JTextField txtNumVenta;
	private JTable table;
	private ControladorPostresDeVenta controlador;

	public PostresDeVenta(IFachada fachada) {
		this.controlador = new ControladorPostresDeVenta(fachada);
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(35, 42, 64));
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Postres de venta");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(10, 11, 250, 20);
		frame.getContentPane().add(lblTitulo);

		JLabel lblNumVenta = new JLabel("Núm. venta:");
		lblNumVenta.setForeground(Color.WHITE);
		lblNumVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumVenta.setBounds(10, 45, 100, 20);
		frame.getContentPane().add(lblNumVenta);

		txtNumVenta = new JTextField();
		txtNumVenta.setBounds(115, 42, 200, 25);
		frame.getContentPane().add(txtNumVenta);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(32, 90, 140));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setOpaque(true);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBounds(325, 41, 100, 27);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTabla();
			}
		});
		frame.getContentPane().add(btnBuscar);

		DefaultTableModel modelo = new DefaultTableModel(
			new String[]{"Código", "Nombre", "Precio unitario", "Tipo", "Cantidad"}, 0
		) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(modelo);
		table.setBackground(Color.WHITE);
		table.setForeground(new Color(35, 42, 64));
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.getTableHeader().setBackground(new Color(32, 90, 140));
		table.getTableHeader().setForeground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 80, 560, 360);
		frame.getContentPane().add(scrollPane);
	}

	private void cargarTabla() {
		try {
			List<VOPostresCant> postres = controlador.postresDeVenta(txtNumVenta.getText().trim());
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setRowCount(0);

			for (VOPostresCant p : postres) {
				modelo.addRow(new Object[]{
					p.getCodigo(),
					p.getNombre(),
					p.getPrecioUnitario(),
					p.getTipoPostre(),
					p.getCantidad()
				});
			}
		} catch (VentaNoExisteException e) {
			JOptionPane.showMessageDialog(frame, "Error: No existe una venta con ese número.", "Error", JOptionPane.ERROR_MESSAGE);
			((DefaultTableModel) table.getModel()).setRowCount(0);
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			((DefaultTableModel) table.getModel()).setRowCount(0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			((DefaultTableModel) table.getModel()).setRowCount(0);
		}
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}