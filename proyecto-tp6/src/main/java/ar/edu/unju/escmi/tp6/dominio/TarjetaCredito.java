package ar.edu.unju.escmi.tp6.dominio;

import java.time.LocalDate;

public class TarjetaCredito {

    private long numero;
    private LocalDate fechaCaducacion;
    private Cliente cliente;
    private double limiteCompra; // Atributo para el límite de compra

    public TarjetaCredito() {
    }

    public TarjetaCredito(long numero, LocalDate fechaCaducacion, Cliente cliente, double limiteCompra) {
        this.numero = numero;
        this.fechaCaducacion = fechaCaducacion;
        this.cliente = cliente; 
        this.limiteCompra = limiteCompra; // Inicializa el límite de compra
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public LocalDate getFechaCaducacion() {
        return fechaCaducacion;
    }

    public void setFechaCaducacion(LocalDate fechaCaducacion) {
        this.fechaCaducacion = fechaCaducacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getLimiteCompra() { // Método que obtiene el límite de compra
        return limiteCompra;
    }

    public void setLimiteCompra(double limiteCompra) { // Método que establece el límite de compra
        this.limiteCompra = limiteCompra;
    }

    public void reducirLimite(double monto) {
        if (this.limiteCompra >= monto) {
            this.limiteCompra -= monto;
        } else {
            System.out.println("Límite insuficiente.");
        }
    }

    @Override
    public String toString() {
        return "\nNumero: " + numero + " Fecha De Caducacion: " + fechaCaducacion + "\nNombre Titular: "
                + cliente.getNombre() + ", Limite De Compra Actual:" + limiteCompra;
    }
}
