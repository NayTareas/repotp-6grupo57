package ar.edu.unju.escmi.tp6.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unju.escmi.tp6.dominio.Credito;
import ar.edu.unju.escmi.tp6.dominio.Detalle;
import ar.edu.unju.escmi.tp6.dominio.Factura;

class CuotaTest {
	
	 	private Credito credito;
		
	   
	    @BeforeEach
	    void setUp() {
	    	 List<Detalle> detalles = new ArrayList<>();
	         Detalle detalle = new Detalle();
	         detalle.setImporte(250000.00);  
	         detalles.add(detalle);
	         Factura factura = new Factura();
	         factura.setDetalles(detalles);
	         credito = new Credito();
	         credito.setFactura(factura);
	         credito.generarCuotas();
	     }

    	

    @Test
    public void testListaCuotasNoEsNull() {
        assertNotNull(credito.getCuotas(), "La lista de cuotas no debe ser null");
    }

    @Test
    void testListaDe30Cuotas() {
        int cuotasEsperadas = 30; 
        int cuotasObtenidas = credito.getCuotas().size(); 
        assertEquals(cuotasEsperadas, cuotasObtenidas);
    }

    @Test
    void testCuotasNoSuperanCantidadPermitida() {
        int cuotasPermitidas = 30; 
        int cuotasObtenidas = credito.getCuotas().size(); 
        assertTrue(cuotasObtenidas <= cuotasPermitidas);
    }
}