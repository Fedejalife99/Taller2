package Logica.Objetos.Exceptions;

public class CantidadUnidadesException extends Exception{
	
	private String mensaje;
	
	public CantidadUnidadesException(String msj)
	{
		super(msj);
	}
	
	public String darMensaje()
	{
		return mensaje;
	}
}
