import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PedidoActual1 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PedidoActual1 frame = new PedidoActual1();
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
	public PedidoActual1() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnAadirProducto = new JButton("A\u00F1adir producto");
		btnAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirProductoPedido1 ven = new AñadirProductoPedido1();
				ven.setVisible(true);
			}
		});
		btnAadirProducto.setBounds(266, 49, 145, 85);
		getContentPane().add(btnAadirProducto);
		
		JButton btnNewButton = new JButton("Finalizar pedido");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinalizarPedido1 ven = new FinalizarPedido1();
				ven.setVisible(true);
			}
		});
		btnNewButton.setBounds(266, 145, 145, 85);
		getContentPane().add(btnNewButton);
		
		JLabel lblPedidoActual = new JLabel("N\u00FAmero de mesa");
		lblPedidoActual.setBounds(34, 11, 118, 14);
		getContentPane().add(lblPedidoActual);
		
		JButton btnVolverAPedidos = new JButton("Volver a pedidos");
		btnVolverAPedidos.setBounds(34, 214, 129, 23);
		getContentPane().add(btnVolverAPedidos);
		
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
		table.setBounds(34, 70, 201, 133);
		getContentPane().add(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "L", "3"}));
		comboBox.setBounds(162, 8, 179, 20);
		getContentPane().add(comboBox);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(78, 49, 62, 14);
		getContentPane().add(lblProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(172, 49, 77, 14);
		getContentPane().add(lblCantidad);
	}

}
