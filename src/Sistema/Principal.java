package Sistema;
import Logica.Objetos.Fachada;
import Logica.Objetos.VObjects.*;
import Logica.Objetos.Exceptions.*;
import java.time.LocalDate;
import java.util.List;

public class Principal
{
    private Fachada f;

    public Principal()
    {
        this.f = new Fachada();
    }

    public static void main(String[] args)
    {
        Principal p = new Principal();

        // ── PRUEBA 1: Ingresar postres ────────────────────────────
        System.out.println("=== PRUEBA 1: Ingresar postres ===");
        try
        {
            p.f.IngresarPostre(new VOPostreIngreso("p001", "Brownie", 80));
            p.f.IngresarPostre(new VOPostreLightIngreso("p002", "Cheesecake Light", 60, "Stevia", "Suave y cremoso"));
            System.out.println("OK: Postres ingresados correctamente.");
        }
        catch (PrecioPostreException e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Precio invalido
        try
        {
            p.f.IngresarPostre(new VOPostreIngreso("p003", "Postre invalido", -10));
            System.out.println("ERROR: Deberia haber lanzado excepcion.");
        }
        catch (PrecioPostreException e)
        {
            System.out.println("OK: Precio invalido detectado: " + e.getMessage());
        }

        // ── PRUEBA 2: Listar postres general ─────────────────────
        System.out.println("\n=== PRUEBA 2: Listar postres general ===");
        try
        {
            List<VOPostreGeneral> lista = p.f.listarPostresGral();
            for (VOPostreGeneral postre : lista)
            {
                System.out.println("Codigo: " + postre.getCodigo() + " | Nombre: " + postre.getNombre() + " | Precio: " + postre.getPrecioUnitario() + " | Tipo: " + postre.getTipo());
            }
        }
        catch (NoHayPostresException e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }

        // ── PRUEBA 3: Listar postre detallado ─────────────────────
        System.out.println("\n=== PRUEBA 3: Listar postre detallado ===");
        try
        {
            VOPostreDetallado detalle = p.f.listarPostreDetallado("p002");
            System.out.println("OK: Codigo: " + detalle.getCodigo() + " | Endulzante: " + detalle.getEndulzante() + " | Descripcion: " + detalle.getDescripcion());
        }
        catch (PostreNoExisteException e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Codigo inexistente
        try
        {
            p.f.listarPostreDetallado("p999");
            System.out.println("ERROR: Deberia haber lanzado excepcion.");
        }
        catch (PostreNoExisteException e)
        {
            System.out.println("OK: Postre inexistente detectado: " + e.getMessage());
        }

        // ── PRUEBA 4: Ingresar venta ──────────────────────────────
        System.out.println("\n=== PRUEBA 4: Ingresar venta ===");
        try
        {
            p.f.IngresarVenta(new VOVentaIngreso("Av. Italia 1234"));
            System.out.println("OK: Venta ingresada correctamente.");
        }
        catch (ErrorFechaException e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }

        // ── PRUEBA 5: Agregar postres a la venta ──────────────────
        System.out.println("\n=== PRUEBA 5: Agregar postres a la venta ===");
        try
        {
            p.f.agregarPostreVenta("p001", 3, 1);
            p.f.agregarPostreVenta("p002", 2, 1);
            System.out.println("OK: Postres agregados correctamente.");
        }
        catch (PostreNoExisteException | VentaNoExisteException | CantidadUnidadesException | VentaFinalizadaException e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Postre inexistente
        try
        {
            p.f.agregarPostreVenta("p999", 1, 1);
            System.out.println("ERROR: Deberia haber lanzado excepcion.");
        }
        catch (PostreNoExisteException | VentaNoExisteException | CantidadUnidadesException | VentaFinalizadaException e)
        {
            System.out.println("OK: Postre inexistente detectado: " + e.getMessage());
        }

        // Cantidad invalida
        try
        {
            p.f.agregarPostreVenta("p001", -1, 1);
            System.out.println("ERROR: Deberia haber lanzado excepcion.");
        }
        catch (PostreNoExisteException | VentaNoExisteException | CantidadUnidadesException | VentaFinalizadaException e)
        {
            System.out.println("OK: Cantidad invalida detectada: " + e.getMessage());
        }

        // ── PRUEBA 6: Eliminar postres de la venta ────────────────
        System.out.println("\n=== PRUEBA 6: Eliminar postres de la venta ===");
        try
        {
            p.f.eliminarCantPostres("p001", 1, 1);
            System.out.println("OK: Postre eliminado correctamente.");
        }
        catch (VentaNoExisteException | VentaFinalizadaException | CantidadUnidadesException | PostreNoExisteException e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Eliminar mas de los existentes
        try
        {
            p.f.eliminarCantPostres("p001", 999, 1);
            System.out.println("ERROR: Deberia haber lanzado excepcion.");
        }
        catch (VentaNoExisteException | VentaFinalizadaException | CantidadUnidadesException | PostreNoExisteException e)
        {
            System.out.println("OK: Cantidad excedida detectada: " + e.getMessage());
        }

        // ── PRUEBA 7: Finalizar venta ─────────────────────────────
        System.out.println("\n=== PRUEBA 7: Finalizar venta ===");
        try
        {
            double total = p.f.finalizarVenta(1, false);
            System.out.println("OK: Venta finalizada. Total: $" + total);
        }
        catch (VentaNoExisteException | VentaFinalizadaException e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Intentar modificar venta finalizada
        try
        {
            p.f.agregarPostreVenta("p001", 1, 1);
            System.out.println("ERROR: Deberia haber lanzado excepcion.");
        }
        catch (PostreNoExisteException | VentaNoExisteException | CantidadUnidadesException | VentaFinalizadaException e)
        {
            System.out.println("OK: Venta finalizada no modificable: " + e.getMessage());
        }

        // ── PRUEBA 8: Recaudacion por postre y fecha ──────────────
        System.out.println("\n=== PRUEBA 8: Recaudacion por postre y fecha ===");
        try
        {
            VORecaudacionPostreFecha rec = p.f.recaudacionPostreFecha("p001", LocalDate.now());
            System.out.println("OK: Cantidad vendida: " + rec.getCantidadTotal() + " | Monto total: $" + rec.getMontoTotal());
        }
        catch (PostreNoExisteException | FechaInvalidaException e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Fecha futura invalida
        try
        {
            p.f.recaudacionPostreFecha("p001", LocalDate.now().plusDays(1));
            System.out.println("ERROR: Deberia haber lanzado excepcion.");
        }
        catch (PostreNoExisteException | FechaInvalidaException e)
        {
            System.out.println("OK: Fecha invalida detectada: " + e.getMessage());
        }
    }
}
