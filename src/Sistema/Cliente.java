package Sistema;

import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Logica.Objetos.IFachada;
import Ventanas.MenuPrincipal;

public class Cliente {
	public static void main(String[] args) {
		try {
			ConfigProperties config = new ConfigProperties();
			int puerto = Integer.parseInt(config.getPuertoServidor());
			String ip = config.getIpServidor();

			// Obtiene la referencia remota a la fachada via RMI
			IFachada fachada = (IFachada) Naming.lookup("//" + ip + ":" + puerto + "/fachada");

			// Abre el menú principal pasándole la interfaz
			EventQueue.invokeLater(() -> {
				MenuPrincipal menu = new MenuPrincipal(fachada);
				menu.setVisible(true);
			});

		}catch (NotBoundException e) {
			System.err.println("Objeto no publicado: " + e.getMessage());
		} catch (RemoteException e) {
			System.err.println("Error remoto: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}