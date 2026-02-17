package Logica.Postres;
import Logica.Objetos.VOPostreGeneral;
import java.util.*;

public class ColeccionPostres{
    private TreeMap<String, Postre> ABB;

    public ColeccionPostres(){
        ABB  = new TreeMap<>();
    }
    
    public boolean member (String clave)
    { 
    	return ABB.containsKey(clave); 
    }

    public void insert (String clave, Postre p)
    {
    	ABB.put(clave, p);
    }
    
    public Postre find (String clave)
    {
    	return ABB.get(clave);
    }
    
    public List<VOPostreGeneral> listarPostresGeneral() {

        List<VOPostreGeneral> listaVO = new ArrayList<>();

        for (Postre p : ABB.values()) {

            listaVO.add(new VOPostreGeneral(
                p.getCodigo(),
                p.getNombre(),
                p.getPrecioUnitario(),
                p.darTipo()
            ));
        }

        return listaVO;
    }

}
