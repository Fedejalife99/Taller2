package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class FinalizarVenta {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalizarVenta window = new FinalizarVenta();
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
	public FinalizarVenta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(35, 42, 64));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Finalizar venta");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 11, 131, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Número de venta:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 36, 112, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 61, 414, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 89, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Confirmar");
		rdbtnNewRadioButton.setForeground(new Color(35, 42, 64));
		rdbtnNewRadioButton.setBounds(13, 99, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Cancelar venta");
		rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setForeground(new Color(35, 42, 64));
		rdbtnNewRadioButton_1.setBounds(175, 99, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(10, 131, 414, 72);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Finalizar");
		btnNewButton.setBackground(new Color(32, 90, 140));
		btnNewButton.setBounds(10, 214, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBackground(new Color(32, 90, 140));
		btnNewButton_1.setBounds(122, 214, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
