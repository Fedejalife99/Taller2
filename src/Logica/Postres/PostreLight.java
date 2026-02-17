package Logica.Postres;

public class PostreLight extends Postre{


	private String endulzante;
	private String descripcion;
	
	public PostreLight(String cod, String nom, float pre, String end, String desc) {
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
	
	public String darTipo()
	{
		return "Light";
	}
}
