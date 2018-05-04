import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
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
	public Inicio() {
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
		
		JButton btnNewButton = new JButton("Administraci\u00F3n productos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaProductos1 ven = new ListaProductos1();
				ven.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 58, 199, 180);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Restaurante");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedidos1 ven = new Pedidos1();
				ven.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(225, 58, 199, 180);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblRestaurantenombre = new JLabel("RESTAURANTE *NOMBRE*");
		lblRestaurantenombre.setBounds(10, 11, 159, 36);
		frame.getContentPane().add(lblRestaurantenombre);
		
		JLabel lblimagenDelRestaurante = new JLabel("*LOGO*");
		lblimagenDelRestaurante.setBounds(179, 8, 76, 42);
		frame.getContentPane().add(lblimagenDelRestaurante);
	}
}
