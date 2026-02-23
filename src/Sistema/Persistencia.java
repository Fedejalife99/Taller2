package Sistema;
import java.io.*;
import Logica.Postres.ColeccionPostres;
import Logica.Ventas.ColeccionVentas;
import Logica.Objetos.Exceptions.PersistenciaException;

public class Persistencia
{
    private static final String aPostres = "postres.dat";
    private static final String aVentas = "ventas.dat";

    public void respaldarPostres(ColeccionPostres postres) throws PersistenciaException
    {
        try
        {
            FileOutputStream f = new FileOutputStream(aPostres);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(postres);
            o.close();
            f.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new PersistenciaException("Error al respaldar postres.");
        }
    }

    public ColeccionPostres recuperarPostres() throws PersistenciaException
    {
        try
        {
            FileInputStream f = new FileInputStream(aPostres);
            ObjectInputStream o = new ObjectInputStream(f);
            ColeccionPostres postres = (ColeccionPostres) o.readObject();
            o.close();
            f.close();
            return postres;
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            throw new PersistenciaException("Error al recuperar postres.");
        }
    }

    public void respaldarVentas(ColeccionVentas ventas) throws PersistenciaException
    {
        try
        {
            FileOutputStream f = new FileOutputStream(aVentas);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(ventas);
            o.close();
            f.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new PersistenciaException("Error al respaldar ventas.");
        }
    }

    public ColeccionVentas recuperarVentas() throws PersistenciaException
    {
        try
        {
            FileInputStream f = new FileInputStream(aVentas);
            ObjectInputStream o = new ObjectInputStream(f);
            ColeccionVentas ventas = (ColeccionVentas) o.readObject();
            o.close();
            f.close();
            return ventas;
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            throw new PersistenciaException("Error al recuperar ventas.");
        }
    }
}