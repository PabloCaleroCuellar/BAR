import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;

public class Pedidos1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Pedidos1() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
				
		JButton btnRealizarPedido = new JButton("Realizar pedido");
		btnRealizarPedido.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnRealizarPedido.setBackground(new Color(204, 255, 0));
		btnRealizarPedido.setBounds(24, 33, 220, 130);
		btnRealizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PedidoActual1 ven = new PedidoActual1();
				ven.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		getContentPane().add(btnRealizarPedido);
		
		JButton btnNewButton = new JButton("Finalizar d\u00EDa");
		btnNewButton.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(204, 255, 0));
		btnNewButton.setBounds(250, 190, 145, 44);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Caja1 ven = new Caja1();
				ven.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Volver a inicio");
		btnNewButton_2.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton_2.setBackground(new Color(204, 255, 0));
		btnNewButton_2.setBounds(24, 190, 145, 44);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio1 ven = new Inicio1();
				ven.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Pedidos1.class.getResource("/imagen/52239.png")));
		lblNewLabel.setBounds(267, 33, 157, 130);
		contentPane.add(lblNewLabel);
	}
}
