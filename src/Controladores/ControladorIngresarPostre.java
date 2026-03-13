package Controladores;

import java.rmi.RemoteException;

import Logica.Objetos.IFachada;
import Logica.Objetos.Exceptions.CodigoExistenteException;
import Logica.Objetos.Exceptions.PrecioPostreException;
import Logica.Objetos.VObjects.VOPostreIngreso;
import Logica.Objetos.VObjects.VOPostreLightIngreso;

public class ControladorIngresarPostre {

	private IFachada fachada;

	public ControladorIngresarPostre(IFachada fachada) {
		this.fachada = fachada;
	}

	public String ingresarPostre(String codigo, String nombre, String precioStr, boolean esLight, boolean esComun, String endulzante, String descripcion) {
		
		if (codigo.isBlank() || nombre.isBlank() || precioStr.isBlank()) {
			return "Error: Código, nombre y precio son obligatorios.";
		}
		
		if (!esLight && !esComun) {
			return "Error: Debe seleccionar el tipo de postre (Común o Light).";
		}
		
		String precioNormalizado = precioStr.trim().replace(',', '.');
		double precio;
		try {
			precio = Double.parseDouble(precioNormalizado);
		} catch (NumberFormatException e) {
			return "Error: El precio debe ser un número válido (use punto o coma decimal).";
		}

		if (esLight && (endulzante.isBlank() || descripcion.isBlank())) {
			return "Error: Endulzante y descripción son obligatorios para postres Light.";
		}

		try {
			if (esLight) {
				VOPostreLightIngreso vo = new VOPostreLightIngreso(codigo, nombre, precio, endulzante, descripcion);
				fachada.IngresarPostre(vo);
			} else {
				VOPostreIngreso vo = new VOPostreIngreso(codigo, nombre, precio);
				fachada.IngresarPostre(vo);
			}
			return "ok";
		} catch (PrecioPostreException e) {
			return "Error: El precio debe ser mayor a 0.";
		} catch (CodigoExistenteException e) {
			return "Error: Ya existe un postre con ese código.";
		}catch (RemoteException e) {
			throw new RuntimeException("Error: No se pudo conectar con el servidor. Verifique que el servidor esté activo.");
		}catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}
}