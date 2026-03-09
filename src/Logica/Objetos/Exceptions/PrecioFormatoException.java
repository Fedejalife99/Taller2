package Logica.Objetos.Exceptions;

public class PrecioFormatoException extends Exception{

	private String mensaje;
	
	public PrecioFormatoException(String msj)
	{
		super(msj);
	}
	
	public String darMensaje()
	{
		return mensaje;
	}
}
