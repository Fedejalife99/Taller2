package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.TextField;
import java.awt.Font;

public class IngresarPostre {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public IngresarPostre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(35, 42, 64));
		frame.getContentPane().setLayout(null);
		
		TextField textField = new TextField();
		textField.setBounds(270, 51, 191, 36);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel = new JLabel("Código");
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(32, 90, 140));
		lblNewLabel.setBounds(92, 51, 77, 36);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 596, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
