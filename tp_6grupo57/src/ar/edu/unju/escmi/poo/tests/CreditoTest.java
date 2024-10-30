package ar.edu.unju.escmi.poo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unju.escmi.tp6.collections.CollectionCredito;
import ar.edu.unju.escmi.tp6.dominio.Credito;
import ar.edu.unju.escmi.tp6.dominio.Factura;

public class CreditoTest {

    private Credito credito;
    private Factura factura;

    @BeforeEach
    public void setUp() {
        // Supone que ya existe un crédito en CollectionCredito
        if (!CollectionCredito.creditos.isEmpty()) {
            credito = CollectionCredito.creditos.get(0);
            factura = credito.getFactura();
        }
    }

    @Test
    public void testMontoTotalCreditoNoSuperaPermitido() {
        assertNotNull(credito, "El crédito no debe ser null.");
        assertNotNull(factura, "La factura no debe ser null.");
        
        double montoTotal = factura.calcularTotal();
        assertTrue(montoTotal <= 1500000, "El monto total del crédito no debe superar 1.500.000$.");
    }

    @Test
    public void testSumaDetallesIgualTotalFactura() {
        assertNotNull(factura, "La factura no debe ser null.");
        
        double sumaDetalles = factura.getDetalles().stream()
                .mapToDouble(detalle -> detalle.getImporte())
                .sum();
        double totalFactura = factura.calcularTotal();
        
        assertEquals(sumaDetalles, totalFactura, "La suma de los importes de los detalles debe ser igual al total de la factura.");

}

    @Test
    public void testMontoTotalCompraNoSuperaPermitidoYLimiteTarjeta() {
        assertNotNull(credito, "El crédito no debe ser null.");
        
        double montoTotal = factura.calcularTotal();
        double limiteTarjeta = credito.getTarjetaCredito().getLimiteCompra();
        
        assertTrue(montoTotal <= 1500000, "El monto total no debe superar 1.500.000$.");
        assertTrue(montoTotal <= limiteTarjeta, "El monto total no debe superar el límite disponible en la tarjeta de crédito.");
    }
}