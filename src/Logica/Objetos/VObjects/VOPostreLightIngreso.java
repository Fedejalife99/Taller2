package Logica.Objetos.VObjects;

import java.io.Serializable;

public class VOPostreLightIngreso extends VOPostreIngreso implements Serializable{
	private String endulzante;
	private String descripcion;
	
	public VOPostreLightIngreso(String codigo, String nombre, double precioUnitario, String endulzante,
			String descripcion) {
		super(codigo, nombre, precioUnitario);
		this.endulzante = endulzante;
		this.descripcion = descripcion;
	}

	public String getEndulzante() {
		return endulzante;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
}
