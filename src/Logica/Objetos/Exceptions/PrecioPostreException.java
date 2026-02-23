package Logica.Objetos.Exceptions;

public class PrecioPostreException extends Exception {
	private String mensaje;
	
	public PrecioPostreException (String msj)
	{
		super(msj);
	}
	
	public String darMensaje()
	{
		return mensaje;
	}
}
