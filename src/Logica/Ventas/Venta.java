package Logica.Ventas;
import java.time.LocalDate;


public class Venta {
	int numeroVenta;
	LocalDate Fecha;
	String direccion;
	double total;
	boolean finalizado;
	//AGREGAR SECCANTPOSTRES
	public Venta(int numeroVenta, String direccion, float total, boolean finalizado) 
	{
		this.numeroVenta = numeroVenta;
		Fecha = LocalDate.now();
		this.direccion = direccion;
		this.total = total;
		this.finalizado = finalizado;
	}
	
	public int getNumeroVenta()
	{
		return numeroVenta;
	}
	
	public LocalDate getFecha()
	{
		return Fecha;
	}
	
	public String getDirEntrega()
	{
		return direccion;
	}
	
	public double getTotal()
	{
		return total;
	}
	
	public boolean getFinalizado()
	{
		return finalizado;
	}
	
	public void setNumeroVenta(int numVenta)
	{
		numeroVenta = numVenta;
	}
	
	public void setFecha(LocalDate F)
	{
		Fecha = F;
	}
	
	public void setDirEntrega(String dir)
	{
		direccion = dir;
	}
	
	public void setTotal(double t)
	{
		total = t;
	}
	
	public void setFinalizado(boolean f)
	{
		finalizado = f;
	}
	
	

}
