import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pedidos1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedidos1 frame = new Pedidos1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pedidos1() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JButton btnRealizarPedido = new JButton("Realizar pedido");
		btnRealizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PedidoActual1 ven = new PedidoActual1();
				ven.setVisible(true);
			}
		});
		btnRealizarPedido.setBounds(24, 33, 220, 130);
		getContentPane().add(btnRealizarPedido);
		
		JButton btnNewButton = new JButton("Finalizar d\u00EDa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Caja1 ven = new Caja1();
				ven.setVisible(true);
			}
		});
		btnNewButton.setBounds(250, 190, 145, 44);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Volver a inicio");
		btnNewButton_2.setBounds(24, 190, 145, 44);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("*imagen*");
		lblNewLabel.setBounds(273, 50, 91, 97);
		getContentPane().add(lblNewLabel);
	}

}
