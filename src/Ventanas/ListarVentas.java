package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controladores.ControladorListarVentas;
import Logica.Objetos.IFachada;
import Logica.Objetos.TipoIndice;
import Logica.Objetos.Exceptions.ErrorIndiceException;
import Logica.Objetos.VOVenta;

public class ListarVentas {

	JFrame frame;
	private JTable table;
	private JRadioButton rdbtnTodas;
	private JRadioButton rdbtnEnProceso;
	private JRadioButton rdbtnFinalizadas;
	private ControladorListarVentas controlador;

	public ListarVentas(IFachada fachada) {
		this.controlador = new ControladorListarVentas(fachada);
		initialize();
		cargarTabla();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(35, 42, 64));
		frame.setBounds(100, 100, 574, 520);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Listado de ventas");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(10, 11, 200, 14);
		frame.getContentPane().add(lblTitulo);

		// Radio buttons para TipoIndice
		rdbtnTodas = new JRadioButton("Todas");
		rdbtnTodas.setBackground(new Color(35, 42, 64));
		rdbtnTodas.setForeground(Color.WHITE);
		rdbtnTodas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnTodas.setSelected(true);
		rdbtnTodas.setBounds(10, 36, 80, 20);
		frame.getContentPane().add(rdbtnTodas);

		rdbtnEnProceso = new JRadioButton("En proceso");
		rdbtnEnProceso.setBackground(new Color(35, 42, 64));
		rdbtnEnProceso.setForeground(Color.WHITE);
		rdbtnEnProceso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnEnProceso.setBounds(100, 36, 100, 20);
		frame.getContentPane().add(rdbtnEnProceso);

		rdbtnFinalizadas = new JRadioButton("Finalizadas");
		rdbtnFinalizadas.setBackground(new Color(35, 42, 64));
		rdbtnFinalizadas.setForeground(Color.WHITE);
		rdbtnFinalizadas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnFinalizadas.setBounds(210, 36, 110, 20);
		frame.getContentPane().add(rdbtnFinalizadas);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnTodas);
		grupo.add(rdbtnEnProceso);
		grupo.add(rdbtnFinalizadas);

		DefaultTableModel modelo = new DefaultTableModel(
			new String[]{"Número de venta", "Monto total", "Finalizado"}, 0
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
		scrollPane.setBounds(10, 65, 538, 350);
		frame.getContentPane().add(scrollPane);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(32, 90, 140));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setOpaque(true);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBounds(10, 430, 120, 30);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTabla();
			}
		});
		frame.getContentPane().add(btnBuscar);
	}

	private void cargarTabla() {
		TipoIndice tipo;
		if (rdbtnEnProceso.isSelected()) {
			tipo = TipoIndice.P;
		} else if (rdbtnFinalizadas.isSelected()) {
			tipo = TipoIndice.F;
		} else {
			tipo = TipoIndice.T;
		}

		try {
			List<VOVenta> ventas = controlador.listarVentas(tipo);
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setRowCount(0);

			for (VOVenta v : ventas) {
				modelo.addRow(new Object[]{
					v.getNumeroVenta(),
					v.getMontoTotal(),
					v.isFinalizado() ? "Sí" : "No"
				});
			}
		} catch (ErrorIndiceException e) {
			JOptionPane.showMessageDialog(frame, "Error al obtener las ventas.", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}