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

public class Caja1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caja1 frame = new Caja1();
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
	public Caja1() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCajaDelDa = new JLabel("Caja del d\u00EDa");
		lblCajaDelDa.setBounds(36, 21, 92, 14);
		getContentPane().add(lblCajaDelDa);
		
		textField = new JTextField();
		textField.setBounds(127, 18, 122, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u20AC");
		label.setBounds(254, 21, 46, 14);
		getContentPane().add(label);
		
		JLabel lblNmeroDePedidos = new JLabel("Pedidos totales");
		lblNmeroDePedidos.setBounds(36, 53, 116, 14);
		getContentPane().add(lblNmeroDePedidos);
		
		textField_1 = new JTextField();
		textField_1.setBounds(162, 50, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Volver a inicio");
		btnNewButton.setBounds(277, 11, 134, 76);
		getContentPane().add(btnNewButton);
		
		table = new JTable();
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
		table.getColumnModel().getColumn(0).setPreferredWidth(175);
		table.setBounds(36, 127, 358, 123);
		getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("Queda poco en almac\u00E9n, encargar  productos cuanto antes");
		lblNewLabel.setBounds(36, 98, 358, 28);
		getContentPane().add(lblNewLabel);
	}

}
