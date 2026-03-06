package Logica.Objetos.VObjects;

import java.io.Serializable;

public class VOPostreIngreso implements Serializable{
	private String codigo;
	private String nombre;
	private double precioUnitario;
	
	public VOPostreIngreso(String codigo, String nombre, double precioUnitario) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}
	
	
}
