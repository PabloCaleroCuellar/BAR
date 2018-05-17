package Modelo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.table.DefaultTableModel;

public class ConectarBBDD {

	private String url;
	private String usr;
	private String pwd;
	private Connection conexion;
	private String esquema;
	
	public ConectarBBDD()  {
		FicheroINI();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, usr, pwd);	

		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public int GeneradorId() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		int generadorid = 0;
		String query = "SELECT * FROM "+esquema+".Producto";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 int sId = rset.getInt("Id_Producto");
				 String sNombre = rset.getString("Nombre_Producto");
				 String sPrecio = rset.getString("Precio");
				 int sCantidad = rset.getInt("Cantidad_Almacen");
				 int sIdCat = rset.getInt("Id_Categoria");
				 
				 Producto p = new Producto(sId, sNombre, sPrecio, sCantidad, sIdCat);
		         productos.add(p);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		for(int i = 0; i < productos.size(); i++) {
			generadorid++;
		}
		
		return generadorid+1;
		
	}
	
	public int GeneradorIdPedido() {
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		int generadorid = 0;
		String query = "SELECT * FROM "+esquema+".Pedido";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 int sId = rset.getInt("ID_PEDIDO");
				 double sTotal = rset.getDouble("TOTAL_PEDIDO");
				 int sMesa = rset.getInt("NUM_MESA");
				 
				 Pedido p = new Pedido(sId, sTotal, sMesa);
		         pedidos.add(p);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		for(int i = 0; i < pedidos.size(); i++) {
			generadorid++;
		}
		
		return generadorid+1;
		
	}
	
	public int CogerIDCategoria(String nombre) {
		new ArrayList<Pedido>();
		int generadorid = 0;
		String query = "SELECT ID_CATEGORIA FROM "+esquema+".Categoria WHERE Nombre_Categoria='"+nombre+"'";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return generadorid;
		
	}
	
	public DefaultTableModel ConsultarProductosCategoria(int num) {
		String [] columnas={"NOMBRE", "PRECIO €"};
		String [] registro=new String[2];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT Nombre_producto, Precio FROM "+esquema+".Producto WHERE Id_Categoria="+num+"";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				if(rset.getString("Nombre_Producto").equals(" ")) {
					continue;
				}
				else {
				registro[0]=rset.getString("Nombre_Producto");
				registro[1]=rset.getString("Precio");
				}
		         
				
				ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}
	
	public int AñadirProducto(int id, String nombre, Double precio, int cantidad, int idcategoria) {
		
		String query = "INSERT INTO "+esquema+".Producto VALUES ("+id+", '"+nombre+"', "+precio+", "+cantidad+", "+idcategoria+")";
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(query);
			
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return 0;
	}
	
	public int ModificarProducto(String nombre, Object precio, int idcategoria, String p) {
		String query = "UPDATE "+esquema+".Producto SET Nombre_Producto='"+nombre+"', Precio="+precio+", ID_CATEGORIA="+idcategoria+" WHERE Nombre_Producto='"+p+"'";
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return 0;
	}
	
	public DefaultTableModel ConsultarProductosMesa(int num) {
		
		String [] columnas={"NOMBRE", "CANT.", "PRECIO€"};
		String [] registro=new String[3];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT Producto.Nombre_Producto, Contiene.Cantidad_Producto, Contiene.Cantidad_Producto*Producto.Precio FROM "+esquema+".Contiene, "+esquema+".Producto WHERE Contiene.Id_Pedido = (SELECT MAX(Id_Pedido) FROM "+esquema+".Pedido WHERE Num_Mesa="+num+") AND Contiene.Id_producto = Producto.Id_Producto";

		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("Nombre_Producto");
				 registro[1]=rset.getString("Cantidad_Producto");
				 registro[2]=rset.getString("Contiene.Cantidad_Producto*Producto.Precio");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}
	
	public int AñadirAPedido(String nombre, int cantidad, int mesa) {
		
		String query = "INSERT INTO "+esquema+".Contiene (Id_Producto, Cantidad_Producto, Id_Pedido) VALUES((SELECT Id_Producto FROM "+esquema+".Producto WHERE Nombre_Producto = '"+nombre+"'), "+cantidad+", (SELECT MAX(Id_Pedido) FROM "+esquema+".Pedido WHERE Num_Mesa="+mesa+"))";
		
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(query);
			
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return 0;
	}
	
	public int AñadirNuevoPedido(int id, int mesa) {
		
		String query = "INSERT INTO "+esquema+".Pedido (Id_Pedido, Num_Mesa) VALUES ("+id+", "+mesa+")";
		
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(query);
			
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return 0;
	}
	
	public boolean ConsultarContieneProductos(int num) {
		boolean comprueba = true;
		
		String query = "SELECT Producto.Nombre_Producto, Contiene.Cantidad_Producto FROM "+esquema+".Contiene, "+esquema+".Producto WHERE Contiene.Id_Pedido = (SELECT MAX(Id_Pedido) FROM "+esquema+".Pedido WHERE Num_Mesa="+num+") AND Contiene.Id_producto = Producto.Id_Producto";
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
			if(rset.getString(1).contains("")) {
				comprueba = false;
			}
			}

			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return comprueba;	
	}
	
	public int Total(int mesa) {
		String query = "UPDATE "+esquema+".Pedido SET Total_Pedido = (SELECT SUM(P.Precio*C.Cantidad_Producto) FROM "+esquema+".Producto P, "+esquema+".Contiene C WHERE C.Id_Pedido = (SELECT MAX(Id_Pedido) FROM "+esquema+".Pedido WHERE Num_Mesa="+mesa+") AND C.Id_Producto = P.Id_Producto) WHERE Id_Pedido = (SELECT MAX(Id_Pedido) FROM "+esquema+".Pedido WHERE Num_Mesa="+mesa+")";
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return 0;
	}
	
	public DefaultTableModel MostrarTotal(int mesa) {	
		String [] columnas={"TOTAL"};
		String [] registro=new String[1];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		
		String query = "SELECT Total_Pedido FROM "+esquema+".Pedido WHERE Id_Pedido = (SELECT MAX(Id_Pedido) FROM "+esquema+".Pedido WHERE Num_Mesa="+mesa+")";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("Total_Pedido");
		         ModeloTabla.addRow(registro);
			}

			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
	}
	
	public int BorrarContiene(int mesa) {
		String query = "DELETE FROM "+esquema+".Contiene WHERE Id_Pedido = (SELECT MAX(Id_Pedido) FROM "+esquema+".Pedido WHERE Num_Mesa="+mesa+")";
		
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return 0;
	}
	
	public DefaultTableModel NumPedidos() {
		String [] columnas={"TOTAL"};
		String [] registro=new String[1];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);	
		
		String query = "SELECT COUNT(Id_Pedido) FROM "+esquema+".Pedido";
		
		try {
		Statement stmt = conexion.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		while(rset.next()) {
			 registro[0]=rset.getString("COUNT(Id_Pedido)");
	         ModeloTabla.addRow(registro);
		}

		rset.close();
		stmt.close();
		
	}catch (SQLException s){
		s.printStackTrace();
	}
	
	return ModeloTabla;
	}
	
	public DefaultTableModel TotalDia() {
		String [] columnas={"TOTAL"};
		String [] registro=new String[1];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);	
		
		String query = "SELECT SUM(Total_pedido) FROM "+esquema+".Pedido";
		
		try {
		Statement stmt = conexion.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		while(rset.next()) {
			 registro[0]=rset.getString("SUM(Total_pedido)");
	         ModeloTabla.addRow(registro);
		}

		rset.close();
		stmt.close();
		
	}catch (SQLException s){
		s.printStackTrace();
	}
	
	return ModeloTabla;
	}
	
	public DefaultTableModel PocosProductos() {
		String [] columnas={"PRODUCTO", "CANTIDAD"};
		String [] registro=new String[2];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);	
		
		String query = "SELECT Nombre_Producto, Cantidad_Almacen FROM "+esquema+".Producto WHERE Cantidad_Almacen <= 999";
		
		try {
		Statement stmt = conexion.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		while(rset.next()) {
			 registro[0]=rset.getString("Nombre_Producto");
			 registro[1]=rset.getString("Cantidad_Almacen");
	         ModeloTabla.addRow(registro);
		}

		rset.close();
		stmt.close();
		
	}catch (SQLException s){
		s.printStackTrace();
	}
	
	return ModeloTabla;
	}
	
	public int CambiarCantidad (int mesa, String nombre) {
		String query = "UPDATE "+esquema+".Producto SET Cantidad_Almacen = (Cantidad_Almacen - (SELECT COUNT(Cantidad_producto) FROM "+esquema+".Contiene WHERE Id_Producto = (SELECT Id_producto FROM "+esquema+".Producto WHERE Nombre_producto = '"+nombre+"' GROUP BY Id_producto) AND Id_Pedido = (SELECT MAX(Id_pedido) FROM "+esquema+".Pedido WHERE Num_Mesa = "+mesa+"))) WHERE Id_Producto = (SELECT Id_producto FROM "+esquema+".Producto WHERE Nombre_producto = '"+nombre+"')";
		
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return 0;
	}
	
	public int BorrarPedidos () {
		String query = "DELETE FROM "+esquema+".Pedido" ;
		
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return 0;
	}
	
	public int PedirProductos (String nombre) {
		String query = "UPDATE "+esquema+".Producto SET Cantidad_Almacen = 1000 WHERE Nombre_Producto = '"+nombre+"'";
		
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return 0;
	}
	
	public DefaultTableModel CogerNombre(String nombre) {
		String [] columnas={"PRODUCTO"};
		String [] registro=new String[1];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);	
		
		String query = "SELECT Nombre_Producto FROM "+esquema+".Producto WHERE Nombre_producto='"+nombre+"'";
		
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
	
	public DefaultTableModel CogerCategoria(String nombre) {
		String [] columnas={"CATEGORIA"};
		String [] registro=new String[1];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);	
		
		String query = "SELECT Nombre_Categoria FROM "+esquema+".Categoria C WHERE Id_Categoria=(SELECT Id_Categoria FROM "+esquema+".Producto WHERE Nombre_producto='"+nombre+"')";
		
		try {
		Statement stmt = conexion.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		while(rset.next()) {
			 registro[0]=rset.getString("Nombre_Categoria");
	         ModeloTabla.addRow(registro);
		}

		rset.close();
		stmt.close();
		
	}catch (SQLException s){
		s.printStackTrace();
	}
	
	return ModeloTabla;
	}
	
	public DefaultTableModel CogerPrecio(String nombre) {
		String [] columnas={"PRECIO"};
		String [] registro=new String[1];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);	
		
		String query = "SELECT Precio FROM "+esquema+".Producto WHERE Nombre_producto='"+nombre+"'";
		
		try {
		Statement stmt = conexion.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		while(rset.next()) {
			 registro[0]=rset.getString("Precio");
	         ModeloTabla.addRow(registro);
		}

		rset.close();
		stmt.close();
		
	}catch (SQLException s){
		s.printStackTrace();
	}
	
	return ModeloTabla;
	}
	
	public int BorrarProducto(String producto) {
		String query = "UPDATE "+esquema+".Producto SET Nombre_Producto=' ' WHERE Nombre_producto='"+producto+"'";
		
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return 0;
	}
	
	public void FicheroINI() {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("src/FicheroINI.ini");
			if(miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url = propiedades.getProperty("basedatos");
				usr=propiedades.getProperty("usuario");
				pwd=propiedades.getProperty("contraseña");
				esquema = propiedades.getProperty("esquema");
			}
			else {
				System.err.println("fichero no encontrado");
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			if(entrada != null) {
				try {
					entrada.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public boolean ConsultarExisteCategoria(int num) {
		boolean comprueba = true;
		
		String query = "SELECT Id_Categoria FROM "+esquema+".Categoria WHERE Id_Categoria="+num+"";
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
			if(rset.getString(1).contains("")) {
				comprueba = false;
			}
			}

			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return comprueba;	
	}
	
	public int AñadirCategoria(int id) {
		
		String query;
		
		if(id == 1) {
		query = "INSERT INTO "+esquema+".Categoria (Id_Categoria, Nombre_Categoria) VALUES ("+id+", 'Bebidas')";
		}		
		if(id == 2) {
			query = "INSERT INTO "+esquema+".Categoria (Id_Categoria, Nombre_Categoria) VALUES ("+id+", 'Comidas')";

		}
		else {
			query = "INSERT INTO "+esquema+".Categoria (Id_Categoria, Nombre_Categoria) VALUES ("+id+", 'Postres')";
		}
			try {
				Statement stmt = conexion.createStatement();
				stmt.executeUpdate(query);
				
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
		return 0;
	}
	
	public boolean ConsultarExisteMesa(int num) {
		boolean comprueba = true;
		
		String query = "SELECT Num_Mesa FROM "+esquema+".Mesa WHERE Num_Mesa="+num+"";
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
			if(rset.getString(1).contains("")) {
				comprueba = false;
			}
			}

			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return comprueba;	
	}
	
	public int AñadirMesa(int id) {		
		String query;
		
		query = "INSERT INTO "+esquema+".Mesa VALUES ("+id+")";	

			try {
				Statement stmt = conexion.createStatement();
				stmt.executeUpdate(query);
				
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
		return 0;
	}
}