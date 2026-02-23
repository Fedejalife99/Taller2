package Logica.Objetos;
import Logica.Objetos.VObjects.VOVentaIngreso;
import java.time.LocalDate;

public class VOVenta extends VOVentaIngreso{
	
	private int numeroVenta;
	private double montoTotal;
	private boolean finalizado;
	
	public VOVenta(LocalDate fechaVenta, String dirEntrega, int numeroVenta, double montoTotal, boolean finalizado) {
		super(dirEntrega);
		this.numeroVenta = numeroVenta;
		this.montoTotal = montoTotal;
		this.finalizado = finalizado;
	}
	
	public int getNumeroVenta() {
		return numeroVenta;
	}
	
	public double getMontoTotal() {
		return montoTotal;
	}

	public boolean isFinalizado() {
		return finalizado;
	}
}
