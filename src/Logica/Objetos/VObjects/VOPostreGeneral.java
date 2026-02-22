package Logica.Objetos.VObjects;
import Logica.Objetos.TipoPostre;

public class VOPostreGeneral {
	private String codigo;
	private String nombre;
	private double precioUnitario;
	private TipoPostre tipoPostre;
	
	public VOPostreGeneral(String codigo, String nombre, double precioUnitario, TipoPostre tipoPostre) {
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
	
	public TipoPostre getTipo()
	{
		return tipoPostre;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public void setTipoPostre(TipoPostre tipoPostre) {
		this.tipoPostre = tipoPostre;
	}
	
	
}
