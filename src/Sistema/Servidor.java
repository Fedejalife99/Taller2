package Sistema;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.io.FileNotFoundException;
import java.io.IOException;
import Logica.Objetos.Fachada;
import Logica.Objetos.Exceptions.PersistenciaException;

public class Servidor {
	
	public static void main(String [] args) throws PersistenciaException, IOException
	{
		try
		{
            ConfigProperties config = new ConfigProperties();
            int puerto = Integer.parseInt(config.getPuertoServidor());
            String ip = config.getIpServidor();
            
            LocateRegistry.createRegistry(puerto);
            Fachada fachada = new Fachada();
            
            try {
            	fachada.RecuperarDatos();
            	System.out.println("Datos recuperados correctamente.");
            } catch (FileNotFoundException e) {
            	System.out.println("No se encontró archivo de datos. Se inicia con datos vacíos.");
            }
            
            Naming.rebind("//" + ip + ":" + puerto + "/fachada", fachada);
            System.out.println("Servidor iniciado correctamente en " + ip + ":" + puerto);
		}
		catch (RemoteException e)
		{
			e.printStackTrace(); 
		}
        catch (MalformedURLException e)
		{
        	e.printStackTrace();
		}
        catch (InterruptedException e)
        {
        	e.printStackTrace();
        }
	}
}