package Controladores;

import Logica.Objetos.IFachada;
import Logica.Objetos.Exceptions.PostreNoExisteException;
import Logica.Objetos.VObjects.VOPostreDetallado;
import Logica.Objetos.VObjects.VOPostreGeneral;

public class ControladorPostreDetallado {

	private IFachada fachada;

	public ControladorPostreDetallado(IFachada fachada) {
		this.fachada = fachada;
	}

	public VOPostreGeneral buscarPostre(String codigo) {
		if (codigo.isBlank()) {
			throw new RuntimeException("Error: El código no puede estar vacío.");
		}
		try {
			return fachada.listarPostreDetallado(codigo);
		} catch (PostreNoExisteException e) {
			throw new RuntimeException("Error: No existe un postre con ese código.");
		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}
}