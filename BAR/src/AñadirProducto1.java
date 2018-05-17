import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Modelo.ConectarBBDD;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.Color;


public class AñadirProducto1 extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;
	private JTextField textField_1;
	private JTable table;
	private ConectarBBDD Prueba;

	public AñadirProducto1() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDelProducto = new JLabel("Nombre del Producto");
		lblNombreDelProducto.setForeground(Color.WHITE);
		lblNombreDelProducto.setFont(new Font("Ebrima", Font.BOLD, 13));
		lblNombreDelProducto.setBounds(10, 55, 146, 14);
		getContentPane().add(lblNombreDelProducto);
		
		JLabel lblCategoraDelProducto = new JLabel("Categor\u00EDa del producto");
		lblCategoraDelProducto.setForeground(Color.WHITE);
		lblCategoraDelProducto.setFont(new Font("Ebrima", Font.BOLD, 13));
		lblCategoraDelProducto.setBounds(10, 102, 162, 14);
		getContentPane().add(lblCategoraDelProducto);
		
		JLabel lblPrecioDelProducto = new JLabel("Precio del producto");
		lblPrecioDelProducto.setForeground(Color.WHITE);
		lblPrecioDelProducto.setFont(new Font("Ebrima", Font.BOLD, 13));
		lblPrecioDelProducto.setBounds(10, 152, 146, 14);
		getContentPane().add(lblPrecioDelProducto);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setBounds(176, 52, 202, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 149, 202, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(176, 99, 202, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bebidas", "Comida", "Postres"}));
		getContentPane().add(comboBox);
		
		JButton btnAadirProducto = new JButton("A\u00F1adir producto");
		btnAadirProducto.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnAadirProducto.setBackground(new Color(204, 255, 0));
		btnAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prueba = new ConectarBBDD();
				if(Prueba.ConsultarExisteCategoria(comboBox.getSelectedIndex()+1) == true) {
					Prueba.AñadirCategoria(comboBox.getSelectedIndex()+1);
				}
				
				if(textField_1.getText().isEmpty() || textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Has dejado un campo vacío, rellénalo");
				}
				else {
					boolean ble = true;
					for(int i = 0; i < textField_1.getText().length(); i++) {
						if(textField_1.getText().contains(".")) {
							continue;
						}
						for(int x = 0; x < 11; x++) {
						if(textField_1.getText().charAt(i) == (x + '0')) {
							break;
						}
						if(x == 10) {
							ble = false;
							break;
						}
						}
					}
					
					if(ble == true) {
						Double precio = Double.valueOf(textField_1.getText());
						Prueba.AñadirProducto(Prueba.GeneradorId(), textField.getText(), precio, 1000, (comboBox.getSelectedIndex())+1);
						textField.setText("");
						textField_1.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null, "Por favor, no introduzca letras");
					}
					}
				}		
		});
		
		btnAadirProducto.setBounds(10, 191, 137, 45);
		getContentPane().add(btnAadirProducto);
		
		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos del producto que vamos a a\u00F1adir");
		lblIntroduzcaLosDatos.setForeground(Color.WHITE);
		lblIntroduzcaLosDatos.setBounds(37, 11, 375, 14);
		lblIntroduzcaLosDatos.setFont(new Font("Ebrima", Font.BOLD, 13));
		getContentPane().add(lblIntroduzcaLosDatos);
		
		JButton btnNewButton = new JButton("Borrar datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnNewButton.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(204, 255, 0));
		btnNewButton.setBounds(165, 191, 137, 45);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atr\u00E1s");
		btnNewButton_1.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(204, 255, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaProductos1 ven = new ListaProductos1();
				ven.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(323, 191, 89, 45);
		getContentPane().add(btnNewButton_1);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
