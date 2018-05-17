import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.ConectarBBDD;

import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.Font;

@SuppressWarnings("serial")
public class AñadirProductoPedido1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static int mesa;

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AñadirProductoPedido1(int mesa) {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 64, 226, 146);
		contentPane.add(scrollPane);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(343, 87, 74, 20);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		contentPane.add(comboBox_1);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa del producto a a\u00F1adir");
		lblCategora.setFont(new Font("Ebrima", Font.BOLD, 13));
		lblCategora.setForeground(Color.WHITE);
		lblCategora.setBounds(18, 22, 226, 14);
		getContentPane().add(lblCategora);
		
		table = new JTable();
		table.setBounds(18, 109, 187, 100);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"New column"
			}
		));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(237, 19, 180, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConectarBBDD Prueba = new ConectarBBDD();
				table.setModel(Prueba.ConsultarProductosCategoria(comboBox.getSelectedIndex()+1));
				table.getColumnModel().getColumn(0).setPreferredWidth(110);
				table.getColumnModel().getColumn(1).setPreferredWidth(40);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bebidas", "Comida", "Postres"}));
		comboBox.setSelectedIndex(0);
		getContentPane().add(comboBox);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(SystemColor.text);
		lblCantidad.setBackground(SystemColor.inactiveCaption);
		lblCantidad.setFont(new Font("Ebrima", Font.BOLD, 13));
		lblCantidad.setBounds(265, 90, 62, 14);
		getContentPane().add(lblCantidad);
		
		JButton btnAadirAPedido = new JButton("A\u00F1adir a pedido");
		btnAadirAPedido.setBackground(new Color(204, 255, 0));
		btnAadirAPedido.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnAadirAPedido.setBounds(265, 163, 152, 88);
		btnAadirAPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Escoja producto");
				}
				else {
				ConectarBBDD Prueba = new ConectarBBDD();
				Prueba.AñadirAPedido((String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()), comboBox_1.getSelectedIndex()+1, mesa);
			}
			}
		});
		getContentPane().add(btnAadirAPedido);
		
		JButton btnAPedidos = new JButton("Volver a pedidos");
		btnAPedidos.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnAPedidos.setBackground(new Color(204, 255, 0));
		btnAPedidos.setBounds(20, 220, 143, 31);
		btnAPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PedidoActual1 ven = new PedidoActual1();
				ven.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(btnAPedidos);
		
		scrollPane.setViewportView(table);
		
	}


	public static int getMesa() {
		return mesa;
	}


	public static void setMesa(int mesa) {
		AñadirProductoPedido1.mesa = mesa;
	}
}
