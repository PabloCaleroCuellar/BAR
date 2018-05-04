import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class FinalizarPedido1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JLabel lblProducto;
	private JLabel lblCantidad;
	private JLabel lblTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalizarPedido1 frame = new FinalizarPedido1();
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
	public FinalizarPedido1() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Total");
		lblNewLabel.setBounds(303, 20, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPagado = new JLabel("Pagado");
		lblPagado.setBounds(303, 76, 46, 14);
		getContentPane().add(lblPagado);
		
		JLabel lblDevolver = new JLabel("Devolver");
		lblDevolver.setBounds(303, 132, 70, 14);
		getContentPane().add(lblDevolver);
		
		textField = new JTextField();
		textField.setText("32.00");
		textField.setBounds(275, 45, 121, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("40.00");
		textField_1.setBounds(275, 101, 121, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("8.00");
		textField_2.setColumns(10);
		textField_2.setBounds(275, 157, 121, 20);
		getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("Imprimir ticket");
		btnNewButton.setBounds(23, 193, 162, 57);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver a Pedido");
		btnNewButton_1.setBounds(247, 193, 162, 57);
		getContentPane().add(btnNewButton_1);
		
		table = new JTable();
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
			Class[] columnTypes = new Class[] {
				Object.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(140);
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.setBounds(23, 44, 201, 133);
		getContentPane().add(table);
		
		lblProducto = new JLabel("Producto");
		lblProducto.setBounds(58, 20, 70, 14);
		getContentPane().add(lblProducto);
		
		lblCantidad = new JLabel("Cant.");
		lblCantidad.setBounds(144, 20, 46, 14);
		getContentPane().add(lblCantidad);
		
		lblTotal = new JLabel("Total");
		lblTotal.setBounds(187, 20, 51, 14);
		getContentPane().add(lblTotal);
	}

}
