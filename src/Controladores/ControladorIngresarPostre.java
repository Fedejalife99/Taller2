package Controladores;

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

	public String ingresarPostre(String codigo, String nombre, String precioStr, boolean esLight, String endulzante, String descripcion) {
		
		// Validar que los campos obligatorios no estén vacíos
		if (codigo.isBlank() || nombre.isBlank() || precioStr.isBlank()) {
			return "Error: Código, nombre y precio son obligatorios.";
		}
		
		// Validar que el precio sea un número
		double precio;
		try {
			precio = Double.parseDouble(precioStr);
		} catch (NumberFormatException e) {
			return "Error: El precio debe ser un número válido.";
		}

		// Validar campos de postre light
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
		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}
}