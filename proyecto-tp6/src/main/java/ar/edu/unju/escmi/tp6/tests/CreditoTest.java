package ar.edu.unju.escmi.tp6.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unju.escmi.tp6.collections.CollectionCredito;
import ar.edu.unju.escmi.tp6.dominio.Cliente;
import ar.edu.unju.escmi.tp6.dominio.Credito;
import ar.edu.unju.escmi.tp6.dominio.Factura;
import ar.edu.unju.escmi.tp6.dominio.TarjetaCredito;

public class CreditoTest {

    private Credito credito;
    private Factura factura;

    @BeforeEach
    public void setUp() {
        // Crear un objeto de tarjeta de crédito simulado
        TarjetaCredito tarjetaCredito = new TarjetaCredito(/* Inicializa según sea necesario */);
        
        // Crear un Cliente usando el constructor adecuado
        Cliente cliente = new Cliente(12345678L, "Juan Perez", "Calle Falsa 123", "123456789", tarjetaCredito);
        
        // Crear una Factura simulada para asociar con el Crédito
        factura = new Factura(/* Inicializa según sea necesario, incluyendo los detalles */);

        // Crear el objeto Credito
        credito = new Credito(tarjetaCredito, factura, new ArrayList<>());
        
        // Agregar el crédito a la colección si es necesario
        CollectionCredito.agregarCredito(credito);
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