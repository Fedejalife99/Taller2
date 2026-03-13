package Controladores;

import java.rmi.RemoteException;
import java.util.List;

import Logica.Objetos.IFachada;
import Logica.Objetos.Exceptions.VentaNoExisteException;
import Logica.Objetos.VObjects.VOPostresCant;

public class ControladorPostresDeVenta {

	private IFachada fachada;

	public ControladorPostresDeVenta(IFachada fachada) {
		this.fachada = fachada;
	}

	public List<VOPostresCant> postresDeVenta(String numVentaStr) throws VentaNoExisteException {

		if (numVentaStr.isBlank()) {
			throw new RuntimeException("Error: El número de venta no puede estar vacío.");
		}

		int numVenta;
		try {
			numVenta = Integer.parseInt(numVentaStr);
		} catch (NumberFormatException e) {
			throw new RuntimeException("Error: El número de venta debe ser un número entero.");
		}

		try {
			return fachada.listarPostresVenta(numVenta);
		} catch (VentaNoExisteException e) {
			throw e;
		}catch (RemoteException e) {
			throw new RuntimeException("Error: No se pudo conectar con el servidor. Verifique que el servidor esté activo.");
		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}
}