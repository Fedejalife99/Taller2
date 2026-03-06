package Logica.Objetos.VObjects;

import java.io.Serializable;

public class VORecaudacionPostreFecha implements Serializable{
	private double montoTotal;
	private int cantidadTotal;
	
	public VORecaudacionPostreFecha(double montoTotal, int cantidadTotal) {
		super();
		this.montoTotal = montoTotal;
		this.cantidadTotal = cantidadTotal;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public int getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}
	
	
	
}
