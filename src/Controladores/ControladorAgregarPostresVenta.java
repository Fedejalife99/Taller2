package Controladores;

import java.rmi.RemoteException;

import Logica.Objetos.IFachada;
import Logica.Objetos.Exceptions.CantidadUnidadesException;
import Logica.Objetos.Exceptions.PostreNoExisteException;
import Logica.Objetos.Exceptions.VentaFinalizadaException;
import Logica.Objetos.Exceptions.VentaNoExisteException;

public class ControladorAgregarPostresVenta {

	private IFachada fachada;

	public ControladorAgregarPostresVenta(IFachada fachada) {
		this.fachada = fachada;
	}

	public String agregarPostreVenta(String codigoVentaStr, String codigoPostre, String cantidadStr) {

		// validaciones de pasaje
		if (codigoVentaStr.isBlank()) {
			return "Error: El código de venta no puede estar vacío.";
		}
		if (codigoPostre.isBlank()) {
			return "Error: El código de postre no puede estar vacío.";
		}
		if (cantidadStr.isBlank()) {
			return "Error: La cantidad no puede estar vacía.";
		}

		int codigoVenta;
		try {
			codigoVenta = Integer.parseInt(codigoVentaStr);
		} catch (NumberFormatException e) {
			return "Error: El código de venta debe ser un número entero.";
		}

		int cantidad;
		try {
			cantidad = Integer.parseInt(cantidadStr);
		} catch (NumberFormatException e) {
			return "Error: La cantidad debe ser un número entero.";
		}

		if (cantidad <= 0 || cantidad > 40) {
			return "Error: La cantidad debe estar entre 1 y 40.";
		}

		try {
			fachada.agregarPostreVenta(codigoPostre, cantidad, codigoVenta);
			return "ok";
		} catch (VentaNoExisteException e) {
			return "Error: No existe una venta con ese código.";
		} catch (PostreNoExisteException e) {
			return "Error: No existe un postre con ese código.";
		} catch (VentaFinalizadaException e) {
			return "Error: No se pueden agregar postres a una venta ya finalizada.";
		}catch (RemoteException e) {
			throw new RuntimeException("Error: No se pudo conectar con el servidor. Verifique que el servidor esté activo.");
		}
		catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}
}