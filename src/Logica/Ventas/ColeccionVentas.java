package Logica.Ventas;
import Logica.Ventas.Venta;

import Logica.Objetos.VOVenta;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ColeccionVentas {
    private LinkedList<Venta> LPPF;

    public ColeccionVentas(){
        LPPF  = new LinkedList<>();
    }
	
    public void insBack(Venta v)
    {
    	LPPF.add(v);
    }
    
    public Venta obtenerPorNum(int numVenta) {
    	Venta aux = null;
    	
        for (Venta v : LPPF) {
            if (v.getNumeroVenta() == numVenta) {
                aux = v;
            }
        }

        return aux;
    }

    
    public List<VOVenta> listarVentas(String indic)
    {
        List<VOVenta> listaVO = new ArrayList<>();
        
        switch(indic)
        {
	        case "T":
	        		for(Venta v: LPPF)
	        		{
	        			listaVO.add(new VOVenta(v.getNumeroVenta(),
	        					v.getFecha(),
	        					v.getDirEntrega(),
	        					v.getTotal(),
	        					v.getFinalizado()));
	        		}
	        	break;
	        case "P":
	        	break;
	        case "F":
	        	break;
        }

    }
	

}
