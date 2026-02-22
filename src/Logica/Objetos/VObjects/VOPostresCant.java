package Logica.Objetos.VObjects;
import Logica.Objetos.TipoPostre;
public class VOPostresCant{
	private String codigo;
	private String nombre;
	private double precioUnitario;
	private TipoPostre tipoPostre;
	private int cantidad;
	public VOPostresCant()
	{}
	public VOPostresCant(String codigo, String nombre, double precioUnitario,TipoPostre tipoPostre, int cantidad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
		this.tipoPostre = tipoPostre;
		this.cantidad = cantidad;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public TipoPostre getTipoPostre() {
		return tipoPostre;
	}
	public void setTipoPostre(TipoPostre tipoPostre) {
		this.tipoPostre = tipoPostre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	 
}

