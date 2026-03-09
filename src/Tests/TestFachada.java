package Tests;

import java.time.LocalDate;
import java.util.List;

import Logica.Objetos.Fachada;
import Logica.Objetos.TipoIndice;

import Logica.Objetos.VObjects.VOPostreGeneral;
import Logica.Objetos.VObjects.VOPostreIngreso;
import Logica.Objetos.VObjects.VOPostreLightIngreso;
import Logica.Objetos.VObjects.VOPostresCant;
import Logica.Objetos.VOVenta;
import Logica.Objetos.VObjects.VORecaudacionPostreFecha;
import Logica.Objetos.VObjects.VOVentaIngreso;
import Logica.Objetos.Exceptions.*;

public class TestFachada {

    private static int total   = 0;
    private static int pasados = 0;
    private static int fallidos = 0;

    public static void main(String[] args) throws Exception {

        Fachada f = new Fachada();

        System.out.println("================================================");
        System.out.println("  CASOS DE PRUEBA - 12 REQUERIMIENTOS FACHADA");
        System.out.println("================================================\n");

        // -------------------------------------------------------
        // REQ 1: IngresarPostre
        // -------------------------------------------------------
        titulo("REQ 1 - IngresarPostre");

        // Caso fehiz comun
        try {
            f.IngresarPostre(new VOPostreIngreso("P01", "Flan", 150.0));
            ok("Postre común válido ingresado");
        } catch (Exception e) { falla("Postre común válido: " + e.getMessage()); }

        // Caso feliz light
        try {
            f.IngresarPostre(new VOPostreLightIngreso("P02", "Mousse Light", 200.0, "Stevia", "Sin azúcar"));
            ok("Postre light válido ingresado");
        } catch (Exception e) { falla("Postre light válido: " + e.getMessage()); }

        // Precio <= 0
        try {
            f.IngresarPostre(new VOPostreIngreso("P03", "Torta", 0.0));
            falla("Precio = 0 debería lanzar PrecioPostreException");
        } catch (PrecioPostreException e) { ok("Precio = 0 → PrecioPostreException"); }
        catch (Exception e) { falla("Precio = 0 lanzó excepción incorrecta: " + e.getClass().getSimpleName()); }

        // Precio negativo
        try {
            f.IngresarPostre(new VOPostreIngreso("P04", "Torta", -50.0));
            falla("Precio negativo debería lanzar PrecioPostreException");
        } catch (PrecioPostreException e) { ok("Precio negativo → PrecioPostreException"); }
        catch (Exception e) { falla("Precio negativo lanzó excepción incorrecta: " + e.getClass().getSimpleName()); }

        // Código duplicado
        try {
            f.IngresarPostre(new VOPostreIngreso("P01", "Duplicado", 100.0));
            falla("Código duplicado debería lanzar CodigoExistenteException");
        } catch (CodigoExistenteException e) { ok("Código duplicado → CodigoExistenteException"); }
        catch (Exception e) { falla("Código duplicado lanzó excepción incorrecta: " + e.getClass().getSimpleName()); }

        // -------------------------------------------------------
        // REQ 2: listarPostresGral
        // -------------------------------------------------------
        titulo("REQ 2 - listarPostresGral");

        try {
            List<VOPostreGeneral> lista = f.listarPostresGral();
            if (lista != null && lista.size() == 2) {
                ok("listarPostresGral retorna 2 postres (P01 y P02)");
            } else {
                falla("listarPostresGral retornó " + (lista == null ? "null" : lista.size()) + " postres, se esperaban 2");
            }
        } catch (Exception e) { falla("listarPostresGral lanzó excepción: " + e.getMessage()); }

        // Sin postres (nueva fachada vacía)
        try {
            Fachada fVacia = new Fachada();
            fVacia.listarPostresGral();
            falla("listarPostresGral en fachada vacía debería lanzar NoHayPostresException");
        } catch (NoHayPostresException e) { ok("Sin postres → NoHayPostresException"); }
        catch (Exception e) { falla("Sin postres, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // -------------------------------------------------------
        // REQ 3: listarPostreDetallado
        // -------------------------------------------------------
        titulo("REQ 3 - listarPostreDetallado");

        try {
            VOPostreGeneral p = f.listarPostreDetallado("P01");
            if (p != null && p.getCodigo().equals("P01")) {
                ok("listarPostreDetallado retorna postre P01 correctamente");
            } else {
                falla("listarPostreDetallado no retornó P01");
            }
        } catch (Exception e) { falla("listarPostreDetallado P01: " + e.getMessage()); }

        // Código inexistente
        try {
            f.listarPostreDetallado("XXXX");
            falla("Código inexistente debería lanzar PostreNoExisteException");
        } catch (PostreNoExisteException e) { ok("Código inexistente → PostreNoExisteException"); }
        catch (Exception e) { falla("Código inexistente, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // Postre light con detalle
        try {
            VOPostreGeneral pl = f.listarPostreDetallado("P02");
            if (pl != null && pl.getCodigo().equals("P02")) {
                ok("listarPostreDetallado retorna postre Light P02 correctamente");
            } else {
                falla("listarPostreDetallado no retornó P02");
            }
        } catch (Exception e) { falla("listarPostreDetallado P02 light: " + e.getMessage()); }

        // -------------------------------------------------------
        // REQ 4: IngresarVenta
        // -------------------------------------------------------
        titulo("REQ 4 - IngresarVenta");

        LocalDate hoy = LocalDate.now();

        try {
            f.IngresarVenta(new VOVentaIngreso("Av. Siempre Viva 742", hoy));
            ok("Venta 1 ingresada con fecha de hoy");
        } catch (Exception e) { falla("Venta 1 válida: " + e.getMessage()); }

        try {
            f.IngresarVenta(new VOVentaIngreso("Calle Falsa 123", hoy));
            ok("Venta 2 ingresada con la misma fecha (fecha igual está permitida)");
        } catch (Exception e) { falla("Venta 2 misma fecha: " + e.getMessage()); }

        // Fecha anterior a la última
        try {
            f.IngresarVenta(new VOVentaIngreso("Retroceso 1", hoy.minusDays(5)));
            falla("Fecha anterior debería lanzar ErrorFechaException");
        } catch (ErrorFechaException e) { ok("Fecha anterior → ErrorFechaException"); }
        catch (Exception e) { falla("Fecha anterior, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // -------------------------------------------------------
        // REQ 5: agregarPostreVenta
        // -------------------------------------------------------
        titulo("REQ 5 - agregarPostreVenta");

        // Caso feliz
        try {
            f.agregarPostreVenta("P01", 3, 1);
            ok("3 unidades de P01 agregadas a venta 1");
        } catch (Exception e) { falla("Agregar P01 a venta 1: " + e.getMessage()); }

        // Agregar mismo postre → acumula
        try {
            f.agregarPostreVenta("P01", 2, 1);
            ok("2 unidades más de P01 a venta 1 (total 5)");
        } catch (Exception e) { falla("Acumular P01 en venta 1: " + e.getMessage()); }

        // Agregar segundo postre
        try {
            f.agregarPostreVenta("P02", 10, 1);
            ok("10 unidades de P02 agregadas a venta 1");
        } catch (Exception e) { falla("Agregar P02 a venta 1: " + e.getMessage()); }

        // Postre inexistente
        try {
            f.agregarPostreVenta("XXXX", 1, 1);
            falla("Postre inexistente debería lanzar PostreNoExisteException");
        } catch (PostreNoExisteException e) { ok("Postre inexistente → PostreNoExisteException"); }
        catch (Exception e) { falla("Postre inexistente, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // Venta inexistente
        try {
            f.agregarPostreVenta("P01", 1, 9999);
            falla("Venta inexistente debería lanzar VentaNoExisteException");
        } catch (VentaNoExisteException e) { ok("Venta inexistente → VentaNoExisteException"); }
        catch (Exception e) { falla("Venta inexistente, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // Cantidad = 0
        try {
            f.agregarPostreVenta("P01", 0, 1);
            falla("Cantidad = 0 debería lanzar CantidadUnidadesException");
        } catch (CantidadUnidadesException e) { ok("Cantidad = 0 → CantidadUnidadesException"); }
        catch (Exception e) { falla("Cantidad = 0, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // Cantidad negativa
        try {
            f.agregarPostreVenta("P01", -1, 1);
            falla("Cantidad negativa debería lanzar CantidadUnidadesException");
        } catch (CantidadUnidadesException e) { ok("Cantidad negativa → CantidadUnidadesException"); }
        catch (Exception e) { falla("Cantidad negativa, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // Superar 40 en total
        try {
            f.agregarPostreVenta("P01", 30, 1);
            falla("Superar 40 postres debería lanzar CantidadUnidadesException");
        } catch (CantidadUnidadesException e) { ok("Superar 40 postres en total → CantidadUnidadesException"); }
        catch (Exception e) { falla("Superar 40, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // -------------------------------------------------------
        // REQ 6: eliminarCantPostres
        // -------------------------------------------------------
        titulo("REQ 6 - eliminarCantPostres");

        // Caso feliz: eliminar 2 de P01 (hay 5)
        try {
            f.eliminarCantPostres("P01", 2, 1);
            ok("Eliminadas 2 unidades de P01 en venta 1 (quedan 3)");
        } catch (Exception e) { falla("Eliminar 2 de P01 venta 1: " + e.getMessage()); }

        // Eliminar todos (quedan 3, eliminar 3)
        try {
            f.eliminarCantPostres("P01", 3, 1);
            ok("Eliminadas 3 unidades restantes de P01 en venta 1 (se borra el registro)");
        } catch (Exception e) { falla("Eliminar todos los P01 de venta 1: " + e.getMessage()); }

        // Postre no en la venta
        try {
            f.eliminarCantPostres("P01", 1, 1);
            falla("Postre eliminado de venta debería lanzar PostreNoExisteException");
        } catch (PostreNoExisteException e) { ok("Postre no en venta → PostreNoExisteException"); }
        catch (Exception e) { falla("Postre no en venta, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // Cantidad = 0
        try {
            f.eliminarCantPostres("P02", 0, 1);
            falla("Cantidad = 0 debería lanzar CantidadUnidadesException");
        } catch (CantidadUnidadesException e) { ok("Cantidad = 0 en eliminar → CantidadUnidadesException"); }
        catch (Exception e) { falla("Cantidad = 0 eliminar, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // Cantidad mayor a la existente (hay 10 de P02)
        try {
            f.eliminarCantPostres("P02", 99, 1);
            falla("Eliminar más de los existentes debería lanzar CantidadUnidadesException");
        } catch (CantidadUnidadesException e) { ok("Cantidad mayor a existente → CantidadUnidadesException"); }
        catch (Exception e) { falla("Cantidad mayor a existente, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // Venta inexistente
        try {
            f.eliminarCantPostres("P02", 1, 9999);
            falla("Venta inexistente en eliminar debería lanzar VentaNoExisteException");
        } catch (VentaNoExisteException e) { ok("Venta inexistente en eliminar → VentaNoExisteException"); }
        catch (Exception e) { falla("Venta inexistente eliminar, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // -------------------------------------------------------
        // REQ 7: finalizarVenta
        // -------------------------------------------------------
        titulo("REQ 7 - finalizarVenta");

        // Finalizar venta 1 (tiene P02 x 10)
        try {
            double total7 = f.finalizarVenta(1, false);
            if (total7 > 0) {
                ok("Venta 1 finalizada. Total: $" + total7);
            } else {
                falla("finalizarVenta retornó 0 con postres cargados");
            }
        } catch (Exception e) { falla("Finalizar venta 1: " + e.getMessage()); }

        // Finalizar venta ya finalizada
        try {
            f.finalizarVenta(1, false);
            falla("Venta ya finalizada debería lanzar VentaFinalizadaException");
        } catch (VentaFinalizadaException e) { ok("Venta ya finalizada → VentaFinalizadaException"); }
        catch (Exception e) { falla("Venta ya finalizada, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // Venta inexistente
        try {
            f.finalizarVenta(9999, false);
            falla("Venta inexistente en finalizar debería lanzar VentaNoExisteException");
        } catch (VentaNoExisteException e) { ok("Venta inexistente en finalizar → VentaNoExisteException"); }
        catch (Exception e) { falla("Venta inexistente finalizar, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // Cancelar venta (venta 2 sigue pendiente)
        try {
            double r = f.finalizarVenta(2, true);
            ok("Venta 2 cancelada (eliminada). Total retornado: $" + r);
        } catch (Exception e) { falla("Cancelar venta 2: " + e.getMessage()); }

        // Agregar una venta 3 vacía y finalizarla sin postres
        f.IngresarVenta(new VOVentaIngreso("Sin postres 99", hoy));
        int numVentaSinPostres = f.listarVentasIndic(TipoIndice.T).stream()
                .filter(v -> !v.isFinalizado()).mapToInt(v -> v.getNumeroVenta()).findFirst().orElse(-1);
        try {
            double r = f.finalizarVenta(numVentaSinPostres, false);
            ok("Venta sin postres finalizada/eliminada. Total: $" + r);
        } catch (Exception e) { falla("Venta sin postres: " + e.getMessage()); }

        // -------------------------------------------------------
        // REQ 8: listarVentasIndic
        // -------------------------------------------------------
        titulo("REQ 8 - listarVentasIndic");

        // Ingresamos una nueva venta para tener pendiente
        f.IngresarVenta(new VOVentaIngreso("Pendiente 100", hoy));

        try {
            List<VOVenta> todas = f.listarVentasIndic(TipoIndice.T);
            ok("TipoIndice.T → " + todas.size() + " ventas totales");
        } catch (Exception e) { falla("Listar todas las ventas: " + e.getMessage()); }

        try {
            List<VOVenta> pendientes = f.listarVentasIndic(TipoIndice.P);
            ok("TipoIndice.P → " + pendientes.size() + " ventas pendientes");
        } catch (Exception e) { falla("Listar ventas pendientes: " + e.getMessage()); }

        try {
            List<VOVenta> finalizadas = f.listarVentasIndic(TipoIndice.F);
            ok("TipoIndice.F → " + finalizadas.size() + " ventas finalizadas");
        } catch (Exception e) { falla("Listar ventas finalizadas: " + e.getMessage()); }

        // -------------------------------------------------------
        // REQ 9: listarPostresVenta
        // -------------------------------------------------------
        titulo("REQ 9 - listarPostresVenta");

        // Venta 1 está finalizada y tiene P02
        try {
            List<VOPostresCant> postresVenta = f.listarPostresVenta(1);
            ok("listarPostresVenta(1) → " + postresVenta.size() + " postre(s)");
        } catch (Exception e) { falla("listarPostresVenta venta 1: " + e.getMessage()); }

        // Venta inexistente
        try {
            f.listarPostresVenta(9999);
            falla("Venta inexistente en listarPostresVenta debería lanzar VentaNoExisteException");
        } catch (VentaNoExisteException e) { ok("Venta inexistente en listarPostresVenta → VentaNoExisteException"); }
        catch (Exception e) { falla("Venta inexistente listarPostres, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // -------------------------------------------------------
        // REQ 10: recaudacionPostreFecha
        // -------------------------------------------------------
        titulo("REQ 10 - recaudacionPostreFecha");

        // Caso feliz con venta finalizada hoy
        try {
            VORecaudacionPostreFecha r = f.recaudacionPostreFecha("P02", hoy);
            ok("Recaudación P02 hoy → monto: $" + r.getMontoTotal() + ", cantidad: " + r.getCantidadTotal());
        } catch (Exception e) { falla("recaudacionPostreFecha P02 hoy: " + e.getMessage()); }

        // Postre inexistente
        try {
            f.recaudacionPostreFecha("XXXX", hoy);
            falla("Postre inexistente debería lanzar PostreNoExisteException");
        } catch (PostreNoExisteException e) { ok("Código inexistente → PostreNoExisteException"); }
        catch (Exception e) { falla("Código inexistente recaudación, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // Fecha futura
        try {
            f.recaudacionPostreFecha("P01", hoy.plusDays(1));
            falla("Fecha futura debería lanzar FechaInvalidaException");
        } catch (FechaInvalidaException e) { ok("Fecha futura → FechaInvalidaException"); }
        catch (Exception e) { falla("Fecha futura, excepción incorrecta: " + e.getClass().getSimpleName()); }

        // Fecha real sin ventas ese día
        try {
            VORecaudacionPostreFecha r = f.recaudacionPostreFecha("P01", hoy.minusDays(30));
            ok("Sin ventas el día dado → monto: $" + r.getMontoTotal() + ", cantidad: " + r.getCantidadTotal() + " (ambos 0)");
        } catch (Exception e) { falla("Fecha sin ventas: " + e.getMessage()); }

        // -------------------------------------------------------
        // REQ 11: RespaldarDatos
        // -------------------------------------------------------
        titulo("REQ 11 - RespaldarDatos");

        try {
            f.RespaldarDatos();
            ok("Datos respaldados correctamente en archivo");
        } catch (PersistenciaException e) { falla("RespaldarDatos PersistenciaException: " + e.getMessage()); }
        catch (Exception e) { falla("RespaldarDatos excepción: " + e.getMessage()); }

        // -------------------------------------------------------
        // REQ 12: RecuperarDatos
        // -------------------------------------------------------
        titulo("REQ 12 - RecuperarDatos");

        try {
            f.RecuperarDatos();
            ok("Datos recuperados del archivo correctamente");
        } catch (Exception e) { falla("RecuperarDatos excepción: " + e.getMessage()); }

        // RecuperarDatos con fachada nueva (verifica que recupera datos persistidos)
        try {
            Fachada f2 = new Fachada();
            f2.RecuperarDatos();
            List<VOPostreGeneral> listaRec = f2.listarPostresGral();
            ok("Nueva Fachada recuperó " + listaRec.size() + " postre(s) persistidos");
        } catch (Exception e) { falla("RecuperarDatos en fachada nueva: " + e.getMessage()); }

        // -------------------------------------------------------
        // RESUMEN FINAL
        // -------------------------------------------------------
        System.out.println("\n================================================");
        System.out.println("  RESUMEN FINAL");
        System.out.println("================================================");
        System.out.println("  Total de casos : " + total);
        System.out.printf ("  Pasados        : %d %s%n", pasados,  pasados  == total ? "✓" : "");
        System.out.printf ("  Fallidos       : %d %s%n", fallidos, fallidos > 0       ? "✗" : "");
        System.out.println("================================================");
        if (fallidos == 0) {
            System.out.println("  ¡Todos los casos pasaron correctamente! ✓");
        } else {
            System.out.println("  Hay casos fallidos. Revisá los detalles arriba.");
        }
        System.out.println("================================================");
    }

    // ----- helpers -----

    private static void titulo(String titulo) {
        System.out.println("\n--- " + titulo + " ---");
    }

    private static void ok(String msg) {
        total++;
        pasados++;
        System.out.println("  [OK]   " + msg);
    }

    private static void falla(String msg) {
        total++;
        fallidos++;
        System.out.println("  [FALLA] " + msg);
    }
}
