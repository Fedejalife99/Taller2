package Logica.Objetos.VObjects;
import java.io.Serializable;
import java.time.LocalDate;

public class VOVentaIngreso implements Serializable{
	private LocalDate fechaVenta;
	private String direccionEntrega;
	
	public VOVentaIngreso(String direccionEntrega,LocalDate fec) {
		this.fechaVenta = fec;
		this.direccionEntrega = direccionEntrega;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
	
	
	
}
