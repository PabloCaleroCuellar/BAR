import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import Modelo.ConectarBBDD;

public class ListaProductos1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaProductos1 frame = new ListaProductos1();
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
	public ListaProductos1() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione categor\u00EDa: ");
		lblNewLabel.setBounds(20, 21, 126, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnAadirProducto = new JButton("A\u00F1adir producto");
		btnAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirProducto1 ven = new AñadirProducto1();
				ven.setVisible(true);
			}
		});
		btnAadirProducto.setBounds(256, 58, 145, 41);
		getContentPane().add(btnAadirProducto);
		
		JButton btnNewButton = new JButton("Modificar producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProducto1 ven = new ModificarProducto1();
				ven.setVisible(true);
			}
		});
		btnNewButton.setBounds(256, 110, 145, 41);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar producto");
		btnNewButton_1.setBounds(256, 162, 145, 41);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblListaDeProductos = new JLabel("Productos de la categor\u00EDa seleccionada");
		lblListaDeProductos.setBounds(20, 46, 226, 14);
		getContentPane().add(lblListaDeProductos);
		
		JButton btnNewButton_2 = new JButton("Volver a Inicio");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setBounds(20, 209, 180, 41);
		getContentPane().add(btnNewButton_2);
		
		JTable table = new JTable();
		table.setBounds(20, 66, 226, 131);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"Producto"
			}));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(157, 18, 226, 20);
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
		getContentPane().add(table);
	}

}
