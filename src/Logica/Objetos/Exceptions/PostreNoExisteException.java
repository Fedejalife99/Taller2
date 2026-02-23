package Logica.Objetos.Exceptions;

public class PostreNoExisteException extends Exception {
	private String mensaje;
	
	
	public PostreNoExisteException(String msj)
	{
		super(msj);
	}
	
	public String darMensaje(String msj)
	{
		return mensaje;
	}
	
	
}
