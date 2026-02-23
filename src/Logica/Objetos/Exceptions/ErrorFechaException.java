package Logica.Objetos.Exceptions;

public class ErrorFechaException extends Exception{
	private String mensaje;
	
	public ErrorFechaException(String msj)
	{
		super(msj);
	}
	
	public String darMensaje() 
	{
		return mensaje;
	}
}
