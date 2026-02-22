package Logica.Objetos;
import Logica.Objetos.VObjects.*;
import Logica.Postres.*;
import Logica.Ventas.*;
import java.util.List;

public class Fachada {
	private ColeccionPostres postres;
	private ColeccionVentas ventas;
	public Fachada() {
		this.postres = new ColeccionPostres();
		this.ventas = new ColeccionVentas();
	}
	public void IngresarPostre(VOPostreIngreso datosPostre)
	{
		Postre nuevo = new Postre(datosPostre.getCodigo(), datosPostre.getNombre(), datosPostre.getPrecioUnitario());
		postres.insert(nuevo);	
	}
	public List<VOPostreGeneral> listarPostresGral()
	{
		return postres.listarPostresGeneral();
	}
	public VOPostreDetallado listarPostreDetallado(String codigo)
	{
		PostreLight aux = (PostreLight) postres.find(codigo);
		VOPostreDetallado nuevo = new VOPostreDetallado(aux.getCodigo(), aux.getNombre(), aux.getPrecioUnitario(), aux.darTipo(), aux.getEndulzante(), aux.getDescripcion());
		return nuevo;
	}
	public void IngresarVenta(VOVentaIngreso v)
	{
		Venta nueva = new Venta(v.getDireccionEntrega(), ventas.Largo());
		ventas.insBack(nueva);
	}
	public void eliminarCantPostres(String codPos, int cant, int numVent)
	{
		Venta aux = ventas.obtenerPorNum(numVent);
		if(aux.getSec().ExistePostreEnSec(codPos))
		{
			aux.getSec().SetCantPostre(codPos, cant);
		}
		else
		{
			//crear nuevo cant postre y agregarlo a la sec
		}
	}
}
