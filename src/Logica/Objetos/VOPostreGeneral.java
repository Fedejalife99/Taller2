package Logica.Objetos;

public class VOPostreGeneral {
	private String codigo;
	private String nombre;
	private double precioUnitario;
	private String tipoPostre;
	
	public VOPostreGeneral(String codigo, String nombre, double precioUnitario, String tipoPostre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
		this.tipoPostre = tipoPostre;
	}
	
	public String getCodigo()
	{
		return codigo;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public double getPrecioUnitario() 
	{
		return precioUnitario;
	}
	
	public String getTipo()
	{
		return tipoPostre;
	}
	
	
}
