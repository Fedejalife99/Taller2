package Logica.Objetos;
import Logica.Postres.Postre;

public class CantPostre {
	
	private Postre postre;
	private int cantidad;
	
	public CantPostre(Postre p, int cant) {
		super();
		this.postre = p;
		this.cantidad = cant;
	}
	
	public Postre getPostre() {
		return postre;
	}
	
	public void setPostre(Postre postre) {
		this.postre = postre;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
