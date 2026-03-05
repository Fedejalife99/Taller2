package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;

public class ListarVentas {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarVentas window = new ListarVentas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListarVentas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de ventas");
		lblNewLabel.setBounds(10, 11, 84, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Todas");
		rdbtnNewRadioButton.setBounds(6, 32, 73, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("En proceso");
		rdbtnNewRadioButton_1.setBounds(81, 32, 95, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Finalizadas");
		rdbtnNewRadioButton_2.setBounds(178, 32, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton = new JButton("Listar");
		btnNewButton.setBounds(10, 62, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(10, 96, 414, 154);
		frame.getContentPane().add(table);
	}

}
