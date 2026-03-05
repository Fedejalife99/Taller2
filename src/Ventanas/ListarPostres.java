package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class ListarPostres {

	private JFrame frame;
	private JTable table;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarPostres window = new ListarPostres();
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
	public ListarPostres() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 574, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 31, 538, 260);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBounds(0, 0, 1, 1);
		frame.getContentPane().add(table);
		
		lblNewLabel = new JLabel("Listado de postres");
		lblNewLabel.setBounds(10, 11, 114, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
