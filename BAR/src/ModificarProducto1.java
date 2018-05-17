import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Modelo.ConectarBBDD;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class ModificarProducto1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NombreNuevo;
	private JTextField PrecioNuevo;
	private static String nombre;
	static int categoria;
	private JTable table;
	private ConectarBBDD Prueba;
	private JTable PrecioActual;
	String nombre1;
	Object precio;
	int categoria1;

	public ModificarProducto1(String nombre, int categoria) {
		Prueba = new ConectarBBDD();
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(81, 46, 109, 14);
		table.setBackground(Color.WHITE);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(Prueba.CogerNombre(nombre));
		contentPane.add(table);
		
		PrecioActual = new JTable();
		PrecioActual.setBounds(81, 140, 109, 14);
		PrecioActual.setBorder(new LineBorder(new Color(0, 0, 0)));
		PrecioActual.setBackground(Color.WHITE);
		PrecioActual.setModel(Prueba.CogerPrecio(nombre));
		contentPane.add(PrecioActual);
		
		JLabel lblNombreDelProducto = new JLabel("Nombre");
		lblNombreDelProducto.setForeground(Color.WHITE);
		lblNombreDelProducto.setFont(new Font("Ebrima", Font.BOLD, 13));
		lblNombreDelProducto.setBounds(10, 46, 121, 14);
		getContentPane().add(lblNombreDelProducto);
		
		JLabel lblCategoraDelProducto = new JLabel("Categor\u00EDa");
		lblCategoraDelProducto.setForeground(Color.WHITE);
		lblCategoraDelProducto.setFont(new Font("Ebrima", Font.BOLD, 13));
		lblCategoraDelProducto.setBounds(10, 91, 137, 14);
		getContentPane().add(lblCategoraDelProducto);
		
		JLabel lblPrecioDelProducto = new JLabel("Precio");
		lblPrecioDelProducto.setFont(new Font("Ebrima", Font.BOLD, 13));
		lblPrecioDelProducto.setForeground(Color.WHITE);
		lblPrecioDelProducto.setBounds(10, 140, 121, 14);
		getContentPane().add(lblPrecioDelProducto);
		
		NombreNuevo = new JTextField();
		NombreNuevo.setBounds(287, 43, 137, 20);
		NombreNuevo.setEnabled(false);
		getContentPane().add(NombreNuevo);
		NombreNuevo.setColumns(10);
		
		PrecioNuevo = new JTextField();
		PrecioNuevo.setBounds(287, 137, 137, 20);
		PrecioNuevo.setEnabled(false);
		getContentPane().add(PrecioNuevo);
		PrecioNuevo.setColumns(10);
		
		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos del producto que vamos a modificar");
		lblIntroduzcaLosDatos.setForeground(Color.WHITE);
		lblIntroduzcaLosDatos.setBounds(36, 13, 375, 14);
		lblIntroduzcaLosDatos.setFont(new Font("Ebrima", Font.BOLD, 13));
		getContentPane().add(lblIntroduzcaLosDatos);
		
		JButton btnNewButton = new JButton("Borrar datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NombreNuevo.setText("");
				PrecioNuevo.setText("");
			}
		});
		btnNewButton.setBackground(new Color(204, 255, 0));
		btnNewButton.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton.setBounds(184, 191, 121, 45);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atr\u00E1s");
		btnNewButton_1.setBackground(new Color(204, 255, 0));
		btnNewButton_1.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnNewButton_1.setBounds(327, 191, 85, 45);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaProductos1 ven = new ListaProductos1();
				ven.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(287, 88, 137, 20);
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bebidas", "Comida", "Postres"}));
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Bebidas", "Comidas", "Postres"}));
		comboBox_1.setBounds(81, 88, 109, 20);
		comboBox_1.setSelectedIndex(categoria-1);
		contentPane.add(comboBox_1);
		
		JCheckBox checkNombre = new JCheckBox("Cambiar");
		checkNombre.setForeground(Color.WHITE);
		checkNombre.setFont(new Font("Ebrima", Font.BOLD, 13));
		checkNombre.setBackground(SystemColor.inactiveCaption);
		checkNombre.setBounds(196, 42, 85, 23);
		checkNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkNombre.isSelected()) {
					NombreNuevo.setEnabled(true);
				}
				else {
					NombreNuevo.setEnabled(false);
				}
			}
		});
		getContentPane().add(checkNombre);
		
		JCheckBox checkCategoria = new JCheckBox("Cambiar");
		checkCategoria.setFont(new Font("Ebrima", Font.BOLD, 13));
		checkCategoria.setForeground(Color.WHITE);
		checkCategoria.setBackground(SystemColor.inactiveCaption);
		checkCategoria.setBounds(196, 87, 85, 23);
		checkCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkCategoria.isSelected()) {
					comboBox.setEnabled(true);
				}
				else {
					comboBox.setEnabled(false);
				}
			}
		});
		getContentPane().add(checkCategoria);
		
		JCheckBox checkPrecio = new JCheckBox("Cambiar");
		checkPrecio.setFont(new Font("Ebrima", Font.BOLD, 13));
		checkPrecio.setForeground(Color.WHITE);
		checkPrecio.setBackground(SystemColor.inactiveCaption);
		checkPrecio.setBounds(196, 136, 85, 23);
		checkPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkPrecio.isSelected()) {
					PrecioNuevo.setEnabled(true);
				}
				else {
					PrecioNuevo.setEnabled(false);
				}
			}
		});
		getContentPane().add(checkPrecio);
		
		JButton btnAadirProducto = new JButton("Modificar producto");
		btnAadirProducto.setBackground(new Color(204, 255, 0));
		btnAadirProducto.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnAadirProducto.setBounds(10, 191, 153, 45);
		btnAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Prueba.ConsultarExisteCategoria(comboBox.getSelectedIndex()+1) == true) {
					Prueba.AñadirCategoria(comboBox.getSelectedIndex()+1);
				}
				
				if(checkCategoria.isSelected()) {
					categoria1 = comboBox.getSelectedIndex()+1;
				}
				else {
					categoria1 = comboBox_1.getSelectedIndex()+1;
				}
				
				if(checkPrecio.isSelected()) {
					precio = Double.parseDouble(PrecioNuevo.getText());
				}
				else {
					precio = PrecioActual.getValueAt(0, 0);
				}

				if(checkNombre.isSelected()) {
					nombre1 = NombreNuevo.getText();
				}
				else {
					nombre1 = (String) table.getValueAt(0, 0);
				}
				
				Prueba.ModificarProducto(nombre1, precio, categoria1, nombre);
				dispose();
				ListaProductos1 ven = new ListaProductos1();
				ven.setVisible(true);
			}
		});
		getContentPane().add(btnAadirProducto);
	}

	public static String getNombre() {
		return nombre;
	}

	public static void setNombre(String nombre) {
		ModificarProducto1.nombre = nombre;
	}
}
