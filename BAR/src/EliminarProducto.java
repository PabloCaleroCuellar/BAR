import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;

public class EliminarProducto {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarProducto window = new EliminarProducto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EliminarProducto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbleliminarProducto = new JLabel("\u00BFEliminar producto?");
		lbleliminarProducto.setBounds(46, 41, 158, 14);
		frame.getContentPane().add(lbleliminarProducto);
		
		JRadioButton rdbtnSi = new JRadioButton("  SI");
		rdbtnSi.setFont(new Font("Tahoma", Font.BOLD, 26));
		rdbtnSi.setSelected(true);
		rdbtnSi.setBounds(76, 108, 109, 23);
		frame.getContentPane().add(rdbtnSi);
		
		JRadioButton rdbtnNo = new JRadioButton("  NO");
		rdbtnNo.setFont(new Font("Tahoma", Font.BOLD, 26));
		rdbtnNo.setBounds(254, 108, 109, 23);
		frame.getContentPane().add(rdbtnNo);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(142, 161, 117, 59);
		frame.getContentPane().add(btnConfirmar);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(182, 35, 181, 20);
		frame.getContentPane().add(textPane);
	}
}
