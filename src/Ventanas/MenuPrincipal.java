package Ventanas;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MenuPrincipal {
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPrincipal() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(35, 42, 64));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNewButton = new JButton("Recaudacion por fecha");
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(30, 58, 92));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnNewButton_3 = new JButton("Ingresar postre");
		btnNewButton_3.setOpaque(true);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBackground(new Color(30, 58, 92));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Nueva venta");
		btnNewButton_4.setOpaque(true);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBackground(new Color(30, 58, 92));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});
		frame.getContentPane().add(btnNewButton_4);

		JButton btnNewButton_2 = new JButton("Detalle postre");
		btnNewButton_2.setOpaque(true);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(new Color(30, 58, 92));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("Listar postres");
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(30, 58, 92));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_7 = new JButton("Agregar postre a venta");
		btnNewButton_7.setOpaque(true);
		btnNewButton_7.setBorderPainted(false);
		btnNewButton_7.setBackground(new Color(30, 58, 92));
		btnNewButton_7.setForeground(Color.WHITE);
		frame.getContentPane().add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("Eliminar postres de Venta");
		btnNewButton_8.setOpaque(true);
		btnNewButton_8.setBorderPainted(false);
		btnNewButton_8.setBackground(new Color(30, 58, 92));
		btnNewButton_8.setForeground(Color.WHITE);
		frame.getContentPane().add(btnNewButton_8);

		JButton btnNewButton_5 = new JButton("Finalizar Venta");
		btnNewButton_5.setOpaque(true);
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setBackground(new Color(30, 58, 92));
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});
		frame.getContentPane().add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Listar ventas");
		btnNewButton_6.setOpaque(true);
		btnNewButton_6.setBorderPainted(false);
		btnNewButton_6.setBackground(new Color(30, 58, 92));
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});
		frame.getContentPane().add(btnNewButton_6);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_9 = new JButton("Respaldar datos");
		btnNewButton_9.setOpaque(true);
		btnNewButton_9.setBorderPainted(false);
		btnNewButton_9.setBackground(new Color(30, 58, 92));
		btnNewButton_9.setForeground(Color.WHITE);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});
		frame.getContentPane().add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton("Postres de una venta");
		btnNewButton_10.setOpaque(true);
		btnNewButton_10.setBorderPainted(false);
		btnNewButton_10.setBackground(new Color(30, 58, 92));
		btnNewButton_10.setForeground(Color.WHITE);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});
		frame.getContentPane().add(btnNewButton_10);
	}
}