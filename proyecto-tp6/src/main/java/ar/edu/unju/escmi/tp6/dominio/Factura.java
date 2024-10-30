package ar.edu.unju.escmi.tp6.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Factura {

    private LocalDate fecha;
    private long nroFactura;
    private Cliente cliente;
    private List<Detalle> detalles = new ArrayList<>();

    public Factura() {
    }

    public Factura(LocalDate fecha, long nroFactura, Cliente cliente, List<Detalle> detalles) {
        this.fecha = fecha;
        this.nroFactura = nroFactura;
        this.cliente = cliente;
        this.detalles = detalles;
        calcularTotal();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public long getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(long nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public double calcularTotal() {
        return detalles.stream().mapToDouble(Detalle::getImporte).sum();
    }

    @Override
    public String toString() {
        StringBuilder facturaStr = new StringBuilder();
        facturaStr.append("\n\n******************** Factura ********************")
                  .append("\nFecha: ").append(fecha)
                  .append(" | N° de Factura: ").append(nroFactura)
                  .append("\nCliente: ").append(cliente.getNombre())
                  .append("\n************ Detalles de la Factura *************");

        // Agrupar productos y calcular la cantidad e importe total por cada código de producto
        detalles.stream()
                .collect(Collectors.groupingBy(detalle -> detalle.getProducto().getCodigo(),
                        Collectors.summingInt(Detalle::getCantidad)))
                .forEach((codigo, cantidad) -> {
                    Detalle detalle = detalles.stream()
                                              .filter(d -> d.getProducto().getCodigo() == codigo)
                                              .findFirst()
                                              .orElse(null);
                    if (detalle != null) {
                        double importeTotal = cantidad * detalle.getProducto().getPrecioUnitario();
                        facturaStr.append("\nPRODUCTO: Codigo: ").append(detalle.getProducto().getCodigo())
                                  .append(" Descripcion: ").append(detalle.getProducto().getDescripcion())
                                  .append(" Precio Unitario: ").append(detalle.getProducto().getPrecioUnitario())
                                  .append(" Origen Fabricacion: ").append(detalle.getProducto().getOrigenFabricacion())
                                  .append("\nCANTIDAD: ").append(cantidad)
                                  .append(" | IMPORTE: ").append(importeTotal);
                    }
                });

        return facturaStr.toString();
    }
}
