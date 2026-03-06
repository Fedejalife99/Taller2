package Controladores;

import Logica.Objetos.IFachada;
import Logica.Objetos.Exceptions.CantidadUnidadesException;
import Logica.Objetos.Exceptions.PostreNoExisteException;
import Logica.Objetos.Exceptions.VentaFinalizadaException;
import Logica.Objetos.Exceptions.VentaNoExisteException;

public class ControladorEliminarPostresVenta {

	private IFachada fachada;

	public ControladorEliminarPostresVenta(IFachada fachada) {
		this.fachada = fachada;
	}

	public String eliminarPostresVenta(String codPos, String cantStr, String numVentStr) {

		if (codPos.isBlank()) {
			return "Error: El código de postre no puede estar vacío.";
		}
		if (cantStr.isBlank()) {
			return "Error: La cantidad no puede estar vacía.";
		}
		if (numVentStr.isBlank()) {
			return "Error: El número de venta no puede estar vacío.";
		}

		int cant;
		try {
			cant = Integer.parseInt(cantStr);
		} catch (NumberFormatException e) {
			return "Error: La cantidad debe ser un número entero.";
		}

		if (cant <= 0 || cant >= 40) {
			return "Error: La cantidad debe ser mayor a 0 y menor a 40.";
		}

		int numVent;
		try {
			numVent = Integer.parseInt(numVentStr);
		} catch (NumberFormatException e) {
			return "Error: El número de venta debe ser un número entero.";
		}

		try {
			fachada.eliminarCantPostres(codPos, cant, numVent);
			return "ok";
		} catch (VentaNoExisteException e) {
			return "Error: No existe una venta con ese número.";
		} catch (PostreNoExisteException e) {
			return "Error: No existe un postre con ese código.";
		} catch (CantidadUnidadesException e) {
			return "Error: La cantidad ingresada no es válida.";
		} catch (VentaFinalizadaException e) {
			return "Error: No se pueden eliminar postres de una venta ya finalizada.";
		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}
}