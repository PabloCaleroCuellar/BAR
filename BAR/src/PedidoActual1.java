import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.ConectarBBDD;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class PedidoActual1 extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ConectarBBDD Prueba;

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PedidoActual1() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", ""},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Producto", "Cantidad"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.setBounds(34, 70, 222, 133);		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prueba = new ConectarBBDD();
				table.setModel(Prueba.ConsultarProductosMesa(comboBox.getSelectedIndex()+1));
				table.getColumnModel().getColumn(0).setPreferredWidth(110);
				table.getColumnModel().getColumn(1).setPreferredWidth(30);
				table.getColumnModel().getColumn(2).setPreferredWidth(50);
			}
		});
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(162, 8, 179, 20);
		getContentPane().add(comboBox);
		
		JButton btnAadirProducto = new JButton("Modificar Pedido");
		btnAadirProducto.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnAadirProducto.setBackground(new Color(204, 255, 0));
		btnAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Prueba.ConsultarExisteMesa(comboBox.getSelectedIndex()+1) == true) {
					Prueba.AñadirMesa(comboBox.getSelectedIndex()+1);
				}
				if(Prueba.ConsultarContieneProductos(comboBox.getSelectedIndex()+1) == true) {
					Prueba.AñadirNuevoPedido(Prueba.GeneradorIdPedido(), comboBox.getSelectedIndex()+1);
				}
				AñadirProductoPedido1 ven = new AñadirProductoPedido1(comboBox.getSelectedIndex()+1);
				ven.setVisible(true);
				dispose();
			}
		});
		btnAadirProducto.setBounds(266, 49, 145, 85);
		getContentPane().add(btnAadirProducto);
		
		JButton btnNewButton = new JButton("Finalizar pedido");
		btnNewButton.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(204, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConectarBBDD Prueba = new ConectarBBDD();
				Prueba.Total(comboBox.getSelectedIndex()+1);
				FinalizarPedido1 ven = new FinalizarPedido1(comboBox.getSelectedIndex()+1);
				ven.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(266, 145, 145, 85);
		getContentPane().add(btnNewButton);
		
		JLabel lblPedidoActual = new JLabel("N\u00FAmero de mesa");
		lblPedidoActual.setForeground(Color.WHITE);
		lblPedidoActual.setFont(new Font("Ebrima", Font.BOLD, 13));
		lblPedidoActual.setBounds(34, 11, 118, 14);
		getContentPane().add(lblPedidoActual);
		
		JButton btnVolverAPedidos = new JButton("Volver a pedidos");
		btnVolverAPedidos.setBackground(new Color(204, 255, 0));
		btnVolverAPedidos.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnVolverAPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedidos1 ven = new Pedidos1();
				ven.setVisible(true);
				dispose();
			}
		});
		btnVolverAPedidos.setBounds(21, 214, 145, 36);
		getContentPane().add(btnVolverAPedidos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 49, 225, 154);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
	}

}
