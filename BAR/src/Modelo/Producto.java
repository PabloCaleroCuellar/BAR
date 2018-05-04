package Modelo;

public class Producto {
	
	private String Nombre;
	private int Categoria;
	private int Cantidad;
	private String Precio;
	private int Id;
	
	
	public Producto(int id, String nombre, String precio2, int cantidad, int idcategoria) {
		super();
		Id = id;
		Nombre = nombre;
		Categoria = idcategoria;
		Cantidad = cantidad;
		Precio = precio2;
	}

	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getCategoria() {
		return Categoria;
	}

	public void setCategoria(int categoria) {
		Categoria = categoria;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public String getPrecio() {
		return Precio;
	}

	public void setPrecio(String precio) {
		Precio = precio;
	}	

}
