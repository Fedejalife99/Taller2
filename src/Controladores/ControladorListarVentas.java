package Controladores;

import java.util.List;

import Logica.Objetos.IFachada;
import Logica.Objetos.TipoIndice;
import Logica.Objetos.Exceptions.ErrorIndiceException;
import Logica.Objetos.VOVenta;

public class ControladorListarVentas {

	private IFachada fachada;

	public ControladorListarVentas(IFachada fachada) {
		this.fachada = fachada;
	}

	public List<VOVenta> listarVentas(TipoIndice tipo) throws ErrorIndiceException {
		try {
			return fachada.listarVentasIndic(tipo);
		} catch (ErrorIndiceException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Error al listar ventas: " + e.getMessage());
		}
	}
}