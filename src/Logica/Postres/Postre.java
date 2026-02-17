package Logica.Postres;

public class Postre {
	String codigo;
	String nombre;
	float precioUnitario;
	public Postre(String cod, String nom, float pre)
	{
		this.codigo = cod;
		this.nombre = nom;
		this.precioUnitario = pre;
	}
	
	public String getCodigo()
	{
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String darTipo()
	{
		return "Comun";
	}
	
}
