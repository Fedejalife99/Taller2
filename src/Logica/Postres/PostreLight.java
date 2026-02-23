package Logica.Postres;

import Logica.Objetos.TipoPostre;

public class PostreLight extends Postre{


	private String endulzante;
	private String descripcion;
	
	public PostreLight(String cod, String nom, double pre, String end, String desc) {
		super(cod, nom, pre);
		this.endulzante = end;
		this.descripcion = desc;
		
	}
	
	public String getEndulzante() {
		return endulzante;
	}
	
	public void setEndulzante(String endulzante) {
		this.endulzante = endulzante;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public TipoPostre darTipo()
	{
		return TipoPostre.LIGHT;
	}
}
