import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.ConectarBBDD;
import java.awt.SystemColor;
import java.awt.Font;


@SuppressWarnings("serial")
public class FinalizarPedido1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTable table;
	private JLabel lblProducto;
	private JTable table_1;
	private ConectarBBDD Prueba;
	private static int mesa;

	
	public FinalizarPedido1(int mesa) {
		Prueba = new ConectarBBDD();
		
		setBounds(100, 100, 437, 302);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(23, 44, 201, 133);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Producto", "Cantidad", "Total"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Object.class, Integer.class, Double.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setModel(Prueba.ConsultarProductosMesa(mesa));
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		
		table_1 = new JTable();
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setBounds(331, 39, 65, 14);
		table_1.setModel(Prueba.MostrarTotal(mesa));
		contentPane.add(table_1);
		
		JLabel lblNewLabel = new JLabel("Total");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Ebrima", Font.BOLD, 13));
		lblNewLabel.setBounds(275, 39, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPagado = new JLabel("Pagado");
		lblPagado.setForeground(Color.WHITE);
		lblPagado.setFont(new Font("Ebrima", Font.BOLD, 13));
		lblPagado.setBounds(275, 83, 46, 14);
		getContentPane().add(lblPagado);
		
		textField_1 = new JTextField();
		textField_1.setBounds(331, 83, 65, 14);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Imprimir ticket");
		btnNewButton.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(204, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Introduzca dinero pagado");
		}
				else {
				double vueltas = Double.parseDouble(textField_1.getText()) - (Double.parseDouble((String)table_1.getValueAt(0, 0)));
				if(vueltas < 0) {
					JOptionPane.showMessageDialog(null, "No ha pagado lo suficiente, vuelva a introducir lo que ha pagado");
					textField_1.setText(" ");
				}
				else {
				Prueba = new ConectarBBDD();
				if(table.getRowCount() == 1) {
					Prueba.CambiarCantidad(mesa, (String) table.getValueAt(0, 0));
				}
				else {
				for(int i = 0; i < table.getRowCount(); i++) {
				Prueba.CambiarCantidad(mesa, (String) table.getValueAt(i, 0));
				}
				}
				Prueba.BorrarContiene(mesa);
				JOptionPane.showMessageDialog(null, "Tienes que devolver " + String.format("%.2f",vueltas) + " euros");
				PedidoActual1 ven = new PedidoActual1();
				ven.setVisible(true);
				dispose();
				}
				}
			}
		});
		btnNewButton.setBounds(264, 144, 145, 101);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver a Pedido");
		btnNewButton_1.setBackground(new Color(204, 255, 0));
		btnNewButton_1.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton_1.setBounds(23, 188, 162, 57);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PedidoActual1 ven = new PedidoActual1();
				ven.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 22, 226, 144);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		lblProducto = new JLabel("Producto");
		scrollPane.setColumnHeaderView(lblProducto);
	}


	public static int getMesa() {
		return mesa;
	}


	public static void setMesa(int mesa) {
		FinalizarPedido1.mesa = mesa;
	}
}
