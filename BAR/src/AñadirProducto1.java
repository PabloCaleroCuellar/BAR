import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Modelo.ConectarBBDD;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class AñadirProducto1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int generadorid = 0;
	private JTextField textField_1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AñadirProducto1 frame = new AñadirProducto1();
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
	public AñadirProducto1() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDelProducto = new JLabel("Nombre del Producto");
		lblNombreDelProducto.setBounds(35, 55, 121, 14);
		getContentPane().add(lblNombreDelProducto);
		
		JLabel lblCategoraDelProducto = new JLabel("Categor\u00EDa del producto");
		lblCategoraDelProducto.setBounds(35, 102, 137, 14);
		getContentPane().add(lblCategoraDelProducto);
		
		JLabel lblPrecioDelProducto = new JLabel("Precio del producto");
		lblPrecioDelProducto.setBounds(35, 152, 121, 14);
		getContentPane().add(lblPrecioDelProducto);
		
		textField = new JTextField();
		textField.setBounds(176, 52, 202, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		String NombreProducto = textField.getText();
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 149, 202, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(176, 99, 202, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bebidas", "Comida", "Postres"}));
		getContentPane().add(comboBox);
		
		JButton btnAadirProducto = new JButton("A\u00F1adir producto");
		btnAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConectarBBDD Prueba = new ConectarBBDD();
				Prueba.AñadirProducto(generadorid, textField.getText(), textField_1.getText(), 1000, (comboBox.getSelectedIndex())+1);
			}
		});
		btnAadirProducto.setBounds(10, 191, 137, 45);
		getContentPane().add(btnAadirProducto);
		
		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos del producto que vamos a a\u00F1adir");
		lblIntroduzcaLosDatos.setBounds(37, 11, 375, 14);
		lblIntroduzcaLosDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblIntroduzcaLosDatos);
		
		JButton btnNewButton = new JButton("Borrar datos");
		btnNewButton.setBounds(165, 191, 137, 45);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atr\u00E1s");
		btnNewButton_1.setBounds(323, 191, 89, 45);
		getContentPane().add(btnNewButton_1);
	}

}
