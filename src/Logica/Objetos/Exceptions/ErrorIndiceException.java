package Logica.Objetos.Exceptions;

public class ErrorIndiceException extends Exception{
	private String mensaje;
	
	public ErrorIndiceException(String msj)
	{
		super(msj);
	}
	
	public String darMensaje()
	{
		return mensaje;
	}
}
