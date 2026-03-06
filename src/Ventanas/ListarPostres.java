package Ventanas;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controladores.ControladorListarPostres;
import Logica.Objetos.IFachada;
import Logica.Objetos.Exceptions.NoHayPostresException;
import Logica.Objetos.VObjects.VOPostreGeneral;

public class ListarPostres {

	JFrame frame;
	private JTable table;
	private ControladorListarPostres controlador;

	public ListarPostres(IFachada fachada) {
		this.controlador = new ControladorListarPostres(fachada);
		initialize();
		cargarTabla();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(35, 42, 64));
		frame.setBounds(100, 100, 574, 472);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Listado de postres");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(10, 11, 200, 14);
		frame.getContentPane().add(lblTitulo);

		// Modelo de tabla con columnas definidas y no editable
		DefaultTableModel modelo = new DefaultTableModel(
			new String[]{"Código", "Nombre", "Precio", "Tipo"}, 0
		) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(modelo);
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(35, 42, 64));
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.getTableHeader().setBackground(new Color(32, 90, 140));
		table.getTableHeader().setForeground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 36, 538, 350);
		frame.getContentPane().add(scrollPane);

		JButton btnRefrescar = new JButton("Refrescar");
		btnRefrescar.setBackground(new Color(32, 90, 140));
		btnRefrescar.setForeground(Color.WHITE);
		btnRefrescar.setOpaque(true);
		btnRefrescar.setBorderPainted(false);
		btnRefrescar.setBounds(10, 400, 120, 30);
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTabla();
			}
		});
		frame.getContentPane().add(btnRefrescar);
	}

	private void cargarTabla() {
		try {
			List<VOPostreGeneral> postres = controlador.listarPostres();
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setRowCount(0); // limpiar filas anteriores

			for (VOPostreGeneral p : postres) {
				modelo.addRow(new Object[]{
					p.getCodigo(),
					p.getNombre(),
					p.getPrecioUnitario(),
					p.getTipo()
				});
			}
		} catch (NoHayPostresException e) {
			JOptionPane.showMessageDialog(frame, "No hay postres registrados.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}