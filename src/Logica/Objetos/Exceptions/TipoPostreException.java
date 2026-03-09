package Logica.Objetos.Exceptions;

public class TipoPostreException extends Exception{

	private String mensaje;
	
	public TipoPostreException(String msj)
	{
		super(msj);
	}
	
	public String darMensaje()
	{
		return mensaje;
	}
}
