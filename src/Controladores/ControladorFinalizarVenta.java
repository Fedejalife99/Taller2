package Controladores;

import Logica.Objetos.IFachada;
import Logica.Objetos.Exceptions.VentaFinalizadaException;
import Logica.Objetos.Exceptions.VentaNoExisteException;

public class ControladorFinalizarVenta {

	private IFachada fachada;

	public ControladorFinalizarVenta(IFachada fachada) {
		this.fachada = fachada;
	}

	public String finalizarVenta(String numVentaStr, boolean cancela) {

		if (numVentaStr.isBlank()) {
			return "Error: El número de venta no puede estar vacío.";
		}

		int numVenta;
		try {
			numVenta = Integer.parseInt(numVentaStr);
		} catch (NumberFormatException e) {
			return "Error: El número de venta debe ser un número entero.";
		}

		try {
			double total = fachada.finalizarVenta(numVenta, cancela);
			return "ok:" + total;
		} catch (VentaNoExisteException e) {
			return "Error: No existe una venta con ese número.";
		} catch (VentaFinalizadaException e) {
			return "Error: La venta ya se encuentra finalizada.";
		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}
}