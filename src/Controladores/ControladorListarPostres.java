package Controladores;

import java.rmi.RemoteException;
import java.util.List;

import Logica.Objetos.IFachada;
import Logica.Objetos.Exceptions.NoHayPostresException;
import Logica.Objetos.VObjects.VOPostreGeneral;

public class ControladorListarPostres {

	private IFachada fachada;

	public ControladorListarPostres(IFachada fachada) {
		this.fachada = fachada;
	}

	public List<VOPostreGeneral> listarPostres() throws NoHayPostresException {
		try {
			return fachada.listarPostresGral();
		} catch (NoHayPostresException e) {
			throw e;
		}catch (RemoteException e) {
			throw new RuntimeException("Error: No se pudo conectar con el servidor. Verifique que el servidor esté activo.");
		}catch (Exception e) {
			throw new RuntimeException("Error al listar postres: " + e.getMessage());
		}
	}
}