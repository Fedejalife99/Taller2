package Controladores;

import java.rmi.RemoteException;
import java.time.LocalDate;

import Logica.Objetos.IFachada;
import Logica.Objetos.Exceptions.FechaInvalidaException;
import Logica.Objetos.VObjects.VOVentaIngreso;

public class ControladorIngresarVenta {

	private IFachada fachada;

	public ControladorIngresarVenta(IFachada fachada) {
		this.fachada = fachada;
	}

	public String ingresarVenta(String direccion, LocalDate fecha) {
		if (direccion.isBlank()) {
			return "Error: La dirección no puede estar vacía.";
		}
		try {
			VOVentaIngreso vo = new VOVentaIngreso(direccion, fecha);
			fachada.IngresarVenta(vo);
			return "ok";
		} catch (FechaInvalidaException e) {
			return "Error: La fecha ingresada no es válida.";
		}catch (RemoteException e) {
			throw new RuntimeException("Error: No se pudo conectar con el servidor. Verifique que el servidor esté activo.");
		}catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}
}