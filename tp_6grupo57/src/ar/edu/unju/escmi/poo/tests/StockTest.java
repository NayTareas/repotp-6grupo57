package ar.edu.unju.escmi.poo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unju.escmi.tp6.collections.CollectionProducto;
import ar.edu.unju.escmi.tp6.collections.CollectionStock;
import ar.edu.unju.escmi.tp6.dominio.Producto;
import ar.edu.unju.escmi.tp6.dominio.Stock;

class StockTest {

    @BeforeEach
    void setUp() {
        CollectionProducto.precargarProductos();
        CollectionStock.precargarStocks();
    }

    @Test
    void testReducirStockProducto() {
        Producto producto = CollectionProducto.buscarProducto(1111); 
        assertNotNull(producto, "El producto no debe ser null");

        Stock stock = CollectionStock.buscarStock(producto);
        assertNotNull(stock, "El stock del producto no debe ser null");

        int stockInicial = stock.getCantidad();
        int cantidadAReducir = 11;

        assertTrue(stockInicial >= cantidadAReducir, "El stock inicial debe ser mayor o igual a la cantidad a reducir");

        CollectionStock.reducirStock(stock, cantidadAReducir);
        int stockEsperado = stockInicial - cantidadAReducir;

        assertEquals(stockEsperado, stock.getCantidad(), "El stock no se redujo correctamente");
    }
}