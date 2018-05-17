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
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.ConectarBBDD;
import java.awt.SystemColor;
import java.awt.Font;


public class ListaProductos1 extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ConectarBBDD Prueba;

	public ListaProductos1() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTable table = new JTable();
		table.setBounds(20, 90, 226, 107);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"Producto"
			}));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(171, 18, 212, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Prueba = new ConectarBBDD();
				table.setModel(Prueba.ConsultarProductosCategoria(comboBox.getSelectedIndex()+1));
				table.getColumnModel().getColumn(0).setPreferredWidth(120);
				table.getColumnModel().getColumn(1).setPreferredWidth(40);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bebidas", "Comida", "Postres"}));
		comboBox.setSelectedIndex(0);
		getContentPane().add(comboBox);

		
		JLabel lblNewLabel = new JLabel("Seleccione categor\u00EDa: ");
		lblNewLabel.setFont(new Font("Ebrima", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(20, 21, 173, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnAadirProducto = new JButton("A\u00F1adir producto");
		btnAadirProducto.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnAadirProducto.setBackground(new Color(204, 255, 0));
		btnAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirProducto1 ven = new AñadirProducto1();
				ven.setVisible(true);
				dispose();
			}
		});
		btnAadirProducto.setBounds(256, 58, 168, 41);
		getContentPane().add(btnAadirProducto);
		
		JButton btnNewButton = new JButton("Modificar producto");
		btnNewButton.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(204, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Escoja producto");
				}
				else {
				ModificarProducto1 ven = new ModificarProducto1((String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()), comboBox.getSelectedIndex()+1);
				ven.setVisible(true);
				dispose();
				}
			}
		});
		btnNewButton.setBounds(256, 110, 168, 41);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar producto");
		btnNewButton_1.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(204, 255, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Escoja producto");
				}
				else {
				Prueba.BorrarProducto((String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
				dispose();
				ListaProductos1 ven = new ListaProductos1();
				ven.setVisible(true);	
				}
			}
		});
		btnNewButton_1.setBounds(256, 162, 168, 41);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblListaDeProductos = new JLabel("Productos de categor\u00EDa seleccionada");
		lblListaDeProductos.setFont(new Font("Ebrima", Font.BOLD, 13));
		lblListaDeProductos.setForeground(Color.WHITE);
		lblListaDeProductos.setBounds(20, 53, 226, 14);
		getContentPane().add(lblListaDeProductos);
		
		JButton btnNewButton_2 = new JButton("Volver a Inicio");
		btnNewButton_2.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton_2.setBackground(new Color(204, 255, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio1 ven = new Inicio1();
				ven.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(20, 209, 180, 41);
		getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 78, 226, 120);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
	}
}
