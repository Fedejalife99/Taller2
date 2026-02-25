package Sistema;
import java.io.*;
import Logica.Postres.ColeccionPostres;
import Logica.Ventas.ColeccionVentas;
import Logica.Objetos.Exceptions.PersistenciaException;
import Logica.Objetos.VObjects.VOPersistencia;

public class Persistencia
{
    private static final String aVOPersistencia = "VOPersistencia.dat";

    public void respaldarColecciones(VOPersistencia VOP) throws PersistenciaException
    {
        try
        {
            FileOutputStream f = new FileOutputStream(aVOPersistencia);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(VOP);
            o.close();
            f.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new PersistenciaException("Error al respaldar las colecciones.");
        }
    }

    public VOPersistencia recuperarColecciones() throws PersistenciaException
    {
        try
        {
        	FileInputStream f = new FileInputStream(aVOPersistencia);
            ObjectInputStream o = new ObjectInputStream(f);
            return (VOPersistencia) o.readObject();

        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            throw new PersistenciaException("Error al recuperar postres.");
        }
    }
}