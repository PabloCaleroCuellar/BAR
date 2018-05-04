import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarProducto1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarProducto1 frame = new ModificarProducto1();
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
	public ModificarProducto1() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNombreDelProducto = new JLabel("Nombre actual");
		lblNombreDelProducto.setBounds(10, 46, 121, 14);
		getContentPane().add(lblNombreDelProducto);
		
		JLabel lblCategoraDelProducto = new JLabel("Categor\u00EDa actual");
		lblCategoraDelProducto.setBounds(10, 91, 137, 14);
		getContentPane().add(lblCategoraDelProducto);
		
		JLabel lblPrecioDelProducto = new JLabel("Precio actual");
		lblPrecioDelProducto.setBounds(10, 140, 121, 14);
		getContentPane().add(lblPrecioDelProducto);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(287, 43, 137, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(287, 137, 137, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAadirProducto = new JButton("Modificar producto");
		btnAadirProducto.setBounds(10, 191, 153, 45);
		getContentPane().add(btnAadirProducto);
		
		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos del producto que vamos a modificar");
		lblIntroduzcaLosDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIntroduzcaLosDatos.setBounds(36, 13, 375, 14);
		getContentPane().add(lblIntroduzcaLosDatos);
		
		JButton btnNewButton = new JButton("Borrar datos");
		btnNewButton.setBounds(173, 191, 109, 45);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Administraci\u00F3n");
		btnNewButton_1.setBounds(287, 191, 125, 45);
		getContentPane().add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bebidas", "Comida", "Postres"}));
		comboBox.setBounds(287, 88, 137, 20);
		getContentPane().add(comboBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Cambiar");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					textField.setEnabled(true);
				}
				else {
					textField.setEnabled(false);
				}
			}
		});
		chckbxNewCheckBox.setBounds(208, 42, 73, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox("Cambiar");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected()) {
					comboBox.setEnabled(true);
				}
				else {
					comboBox.setEnabled(false);
				}
			}
		});
		checkBox.setBounds(208, 87, 73, 23);
		getContentPane().add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Cambiar");
		checkBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_1.isSelected()) {
					textField_2.setEnabled(true);
				}
				else {
					textField_2.setEnabled(false);
				}
			}
		});
		checkBox_1.setBounds(208, 136, 73, 23);
		getContentPane().add(checkBox_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(99, 43, 103, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(113, 88, 89, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(99, 137, 103, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
	}

}
