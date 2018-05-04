import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.ConectarBBDD;

import javax.swing.JTable;

public class AñadirProductoPedido1 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AñadirProductoPedido1 frame = new AñadirProductoPedido1();
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
	public AñadirProductoPedido1() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblCategora = new JLabel("Categor\u00EDa del producto a a\u00F1adir");
		lblCategora.setBounds(18, 26, 187, 14);
		getContentPane().add(lblCategora);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"New column"
			}
		));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(18, 86, 187, 123);
		contentPane.add(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(215, 23, 187, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConectarBBDD Prueba = new ConectarBBDD();
				if(comboBox.getSelectedIndex() == 0) {
					table.setModel(Prueba.ConsultarProductosBebidas());
			}
				if(comboBox.getSelectedIndex() == 1) {
					table.setModel(Prueba.ConsultarProductosComida());
			}
				if(comboBox.getSelectedIndex() == 2) {
					table.setModel(Prueba.ConsultarProductosPostres());
			}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bebidas", "Comida", "Postres"}));
		comboBox.setSelectedIndex(0);
		getContentPane().add(comboBox);
		
		JLabel lblListaDeProductos = new JLabel("Productos de la categor\u00EDa seleccionada");
		lblListaDeProductos.setBounds(20, 61, 226, 14);
		getContentPane().add(lblListaDeProductos);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(209, 86, 17, 123);
		getContentPane().add(scrollBar);
		
		JLabel lblCantidad = new JLabel("Cantidad: ");
		lblCantidad.setBounds(236, 106, 62, 14);
		getContentPane().add(lblCantidad);
		
		JButton btnAadirAPedido = new JButton("A\u00F1adir a pedido");
		btnAadirAPedido.setBounds(257, 162, 145, 66);
		getContentPane().add(btnAadirAPedido);
		
		JButton btnAPedidos = new JButton("Volver a pedidos");
		btnAPedidos.setBounds(20, 220, 132, 31);
		getContentPane().add(btnAPedidos);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox_1.setBounds(296, 103, 106, 20);
		contentPane.add(comboBox_1);
		
	}
}
