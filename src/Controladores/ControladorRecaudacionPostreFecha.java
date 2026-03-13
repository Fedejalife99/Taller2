package Controladores;

import java.rmi.RemoteException;
import java.time.LocalDate;

import Logica.Objetos.IFachada;
import Logica.Objetos.Exceptions.FechaInvalidaException;
import Logica.Objetos.Exceptions.PostreNoExisteException;
import Logica.Objetos.VObjects.VORecaudacionPostreFecha;

public class ControladorRecaudacionPostreFecha {

	private IFachada fachada;

	public ControladorRecaudacionPostreFecha(IFachada fachada) {
		this.fachada = fachada;
	}

	public VORecaudacionPostreFecha recaudacionPostreFecha(String codigo, LocalDate fecha) 
			throws PostreNoExisteException, FechaInvalidaException {

		// validaciones de pasaje
		if (codigo.isBlank()) {
			throw new RuntimeException("Error: El código de postre no puede estar vacío.");
		}

		try {
			return fachada.recaudacionPostreFecha(codigo, fecha);
		} catch (PostreNoExisteException e) {
			throw e;
		} catch (FechaInvalidaException e) {
			throw e;
		}catch (RemoteException e) {
			throw new RuntimeException("Error: No se pudo conectar con el servidor. Verifique que el servidor esté activo.");
		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}
}