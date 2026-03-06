package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.awt.Label;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class RecaudacionPostreFecha {

	private JFrame frame;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecaudacionPostreFecha window = new RecaudacionPostreFecha();
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
	public RecaudacionPostreFecha() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(35, 42, 64));
		frame.setBounds(100, 100, 450, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Label label = new Label("Recaudación postre fecha");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(10, 0, 239, 22);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Código de postre: ");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBounds(10, 38, 143, 22);
		frame.getContentPane().add(label_1);
		
		TextField textField = new TextField();
		textField.setBounds(10, 66, 414, 22);
		frame.getContentPane().add(textField);
		
		JSpinner spinnerFecha = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy");
		spinnerFecha.setEditor(editor);
		spinnerFecha.setBounds(10, 134, 414, 36);
		frame.getContentPane().add(spinnerFecha);
		
		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 104, 81, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBackground(new Color(35, 42, 64));
		btnNewButton.setBounds(10, 193, 103, 36);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(32, 90, 140));
		textField_1.setEditable(false);
		textField_1.setBounds(10, 240, 414, 123);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
