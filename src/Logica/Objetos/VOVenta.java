package Logica.Objetos;

public class VOVenta extends VOVentaIngreso{
	
	private String numeroVenta;
	private double montoTotal;
	private boolean finalizado;
	
	public VOVenta(String numeroVenta, double montoTotal, boolean finalizado) {
		super();
		this.numeroVenta = numeroVenta;
		this.montoTotal = montoTotal;
		this.finalizado = finalizado;
	}
	
	public String getNumeroVenta() {
		return numeroVenta;
	}
	
	public double getMontoTotal() {
		return montoTotal;
	}

	public boolean isFinalizado() {
		return finalizado;
	}
}
