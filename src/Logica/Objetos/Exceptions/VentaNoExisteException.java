package Logica.Objetos.Exceptions;

public class VentaNoExisteException extends Exception {
	private String mensaje;
	
	public VentaNoExisteException(String msj)
	{
		super(msj);
	}
	
	public String darMensaje()
	{
		return mensaje;
	}
}
