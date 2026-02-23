package Logica.Objetos.Exceptions;

public class VentaFinalizadaException extends Exception{
	private String mensaje;
	
	public VentaFinalizadaException(String msj)
	{
		super(msj);
	}
	
	public String darMensaje() 
	{
		return mensaje;
	}
}
