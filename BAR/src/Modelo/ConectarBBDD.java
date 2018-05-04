package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ConectarBBDD {

	private String bd;
	private String url= "jdbc:oracle:thin:@localhost:1521:XE";
	private String usr = "SYSTEM";
	private String pwd = "Pablo1802";
	private Connection conexion;
	

	public int GeneradorId() {
		ArrayList<Producto> personas = new ArrayList<Producto>();
		
		String query = "SELECT ENAME, JOB, SAL FROM Pablo.emp WHERE DEPTNO = (select deptno from Pablo.dept WHERE DNAME = '"+ NombreDpt +"' )";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 String sNombre = rset.getString("ENAME");
				 String sPuesto = rset.getString("JOB");
				 String sSalario = rset.getString("SAL");
				 Producto p = new Producto(sNombre, sPuesto, sSalario);
		         personas.add(p);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		
		return personas;
		
	}
	
	public ConectarBBDD()  {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, usr, pwd);	

		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	
	public DefaultTableModel ConsultarProductosBebidas() {
		String [] columnas={"NOMBRE"};
		String [] registro=new String[1];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT Nombre_producto FROM Pablo.Producto WHERE Id_Categoria=1";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("Nombre_Producto");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}
	
	public DefaultTableModel ConsultarProductosComida() {
		String [] columnas={"NOMBRE"};
		String [] registro=new String[1];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT Nombre_producto FROM Pablo.Producto WHERE Id_Categoria=2";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("Nombre_Producto");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}
	
	public DefaultTableModel ConsultarProductosPostres() {
		String [] columnas={"NOMBRE"};
		String [] registro=new String[1];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT Nombre_producto FROM Pablo.Producto WHERE Id_Categoria=3";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("Nombre_Producto");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}
	
	public int AñadirProducto(int id, String nombre, String precio, int cantidad, int idcategoria) {
		
		String query = "INSERT INTO Pablo.Producto VALUES ("+id+", '"+nombre+"', '"+precio+"', "+cantidad+", "+idcategoria+")";
		System.out.println(query);
		try {
			Statement stmt = conexion.createStatement();
			int rset = stmt.executeUpdate(query);
			
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return 0;
	}

}

