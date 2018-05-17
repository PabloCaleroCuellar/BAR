package Modelo;

public class Pedido {
	
	private int ID_PEDIDO;
	private double TOTAL_PEDIDO;
	private int NUM_MESA;
	
	
	public Pedido(int iD_PEDIDO, double tOTAL_PEDIDO, int nUM_MESA) {
		super();
		ID_PEDIDO = iD_PEDIDO;
		TOTAL_PEDIDO = tOTAL_PEDIDO;
		NUM_MESA = nUM_MESA;
	}

	public int getID_PEDIDO() {
		return ID_PEDIDO;
	}

	public void setID_PEDIDO(int iD_PEDIDO) {
		ID_PEDIDO = iD_PEDIDO;
	}

	public double getTOTAL_PEDIDO() {
		return TOTAL_PEDIDO;
	}

	public void setTOTAL_PEDIDO(double tOTAL_PEDIDO) {
		TOTAL_PEDIDO = tOTAL_PEDIDO;
	}

	public int getNUM_MESA() {
		return NUM_MESA;
	}

	public void setNUM_MESA(int nUM_MESA) {
		NUM_MESA = nUM_MESA;
	}
	
}
