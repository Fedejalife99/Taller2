package Logica.Objetos.Exceptions;

public class FechaInvalidaException extends Exception{
	private String mensaje;
	
	public FechaInvalidaException(String msj)
	{
		super(msj);
	}
	
	public String darMensaje() 
	{
		return mensaje;
	}
}
