import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inicio1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel frame;

	public Inicio1() {
		setBounds(100, 100, 450, 300);
		getContentPane().setBackground(SystemColor.inactiveCaption);
		getContentPane().setLayout(null);		
		JLabel lblRestauranteBle = new JLabel("RESTAURANTE BLE");
		lblRestauranteBle.setForeground(Color.WHITE);
		lblRestauranteBle.setFont(new Font("Ebrima", Font.BOLD, 24));
		lblRestauranteBle.setBounds(20, 26, 245, 32);
		getContentPane().add(lblRestauranteBle);
		
		JButton btnNewButton = new JButton("Administraci\u00F3n productos");
		btnNewButton.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(204, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaProductos1 ven = new ListaProductos1();
				ven.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 76, 199, 115);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Restaurante");
		btnNewButton_1.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(204, 255, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedidos1 ven = new Pedidos1();
				ven.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(225, 76, 199, 115);
		getContentPane().add(btnNewButton_1);
		
	}

	public JPanel getFrame() {
		return frame;
	}

	public void setFrame(JPanel frame) {
		this.frame = frame;
	}
	}


