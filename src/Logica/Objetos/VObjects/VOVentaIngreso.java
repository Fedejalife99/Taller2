package Logica.Objetos.VObjects;
import java.time.LocalDate;

public class VOVentaIngreso{
	private LocalDate fechaVenta;
	private String direccionEntrega;
	
	public VOVentaIngreso(String direccionEntrega) {
		this.fechaVenta = LocalDate.now();
		this.direccionEntrega = direccionEntrega;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}
	
	
	
}
