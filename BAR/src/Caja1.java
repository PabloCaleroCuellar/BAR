import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.ConectarBBDD;
import java.awt.SystemColor;
import java.awt.Font;

@SuppressWarnings("serial")
public class Caja1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ConectarBBDD Prueba;
	private JTable table_1;
	private JTable table_2;

	public Caja1() {

		setBounds(100, 100, 450, 308);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCajaDelDa = new JLabel("Caja del d\u00EDa");
		lblCajaDelDa.setBounds(36, 21, 92, 14);
		lblCajaDelDa.setForeground(Color.WHITE);
		lblCajaDelDa.setFont(new Font("Ebrima", Font.BOLD, 13));
		getContentPane().add(lblCajaDelDa);
		
		Prueba = new ConectarBBDD();
		table_1 = new JTable();
		table_1.setBounds(144, 54, 52, 14);
		table_1.setFont(new Font("Ebrima", Font.BOLD, 13));
		table_1.setForeground(Color.BLACK);
		table_1.setBorder(new LineBorder(SystemColor.inactiveCaption));
		table_1.setBackground(SystemColor.inactiveCaption);
		contentPane.add(table_1);
		table_1.setModel(Prueba.NumPedidos());
		
		JLabel label = new JLabel("\u20AC");
		label.setBounds(169, 22, 46, 14);
		getContentPane().add(label);
		
		JLabel lblNmeroDePedidos = new JLabel("Pedidos totales");
		lblNmeroDePedidos.setBounds(36, 53, 116, 14);
		lblNmeroDePedidos.setFont(new Font("Ebrima", Font.BOLD, 13));
		lblNmeroDePedidos.setForeground(Color.WHITE);
		getContentPane().add(lblNmeroDePedidos);
		
		JButton btnNewButton = new JButton("Fin D\u00EDa");
		btnNewButton.setBounds(317, 21, 86, 68);
		btnNewButton.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(204, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean tienealgo = true;
				for(int i = 1; i < 4; i++) {
				if(Prueba.ConsultarContieneProductos(i) == false) {
					tienealgo = false;
					break;
				}
				}
				if(tienealgo == true) {
				Prueba.BorrarPedidos();
				Inicio1 ven = new Inicio1();
				ven.setVisible(true);
				dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Tenemos un pedido en curso, vamos a finalizarlo");
					PedidoActual1 ven = new PedidoActual1();
					ven.setVisible(true);
					dispose();
				}
			}
		});
		getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(36, 127, 367, 96);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Producto", "Cantidad almac\u00E9n"
			}
		));
		table.setModel(Prueba.PocosProductos());
		table.getColumnModel().getColumn(0).setPreferredWidth(175);
		getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("Queda poco en almac\u00E9n, encargar  productos cuanto antes");
		lblNewLabel.setBounds(36, 98, 388, 28);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Ebrima", Font.BOLD, 13));
		getContentPane().add(lblNewLabel);
		
		table_2 = new JTable();
		table_2.setBounds(123, 21, 46, 14);
		table_2.setFont(new Font("Ebrima", Font.BOLD, 13));
		table_2.setBackground(SystemColor.inactiveCaption);
		table_2.setBorder(new LineBorder(SystemColor.inactiveCaption));
		contentPane.add(table_2);
		table_2.setModel(Prueba.TotalDia());
		
		JButton btnNewButton_1 = new JButton("Encargar");
		btnNewButton_1.setBounds(206, 21, 92, 68);
		btnNewButton_1.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(204, 255, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0; i < table.getRowCount(); i++) {
				Prueba.PedirProductos((String) table.getValueAt(i, 0));
				}
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Atr\u00E1s");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pedidos1 ven = new Pedidos1();
				ven.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(204, 255, 0));
		btnNewButton_2.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton_2.setBounds(314, 234, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
