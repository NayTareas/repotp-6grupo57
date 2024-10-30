package ar.edu.unju.escmi.tp6.dominio;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp6.collections.CollectionFactura;

public class Cliente {

	private long dni;
	private String nombre;
	private String direccion;
	private String telefono;
	private TarjetaCredito tarjetaCredito;
	
	public Cliente() {

	}


	public Cliente(long dni, String nombre, String direccion, String telefono, TarjetaCredito tarjetaCredito) {
	    this.dni = dni;
	    this.nombre = nombre;
	    this.direccion = direccion;
	    this.telefono = telefono;
	    this.tarjetaCredito = tarjetaCredito;
	}



	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


    public TarjetaCredito getTarjetaCredito() { // Método para obtener la tarjeta de crédito
        return tarjetaCredito;
    }

    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) { // Método para establecer la tarjeta de crédito
        this.tarjetaCredito = tarjetaCredito;
    }

    public List<Factura> consultarCompras() {
        List<Factura> shoppingList = new ArrayList<>();
        if (CollectionFactura.facturas != null) {
            for (Factura fac : CollectionFactura.facturas) {
                if (fac.getCliente().getDni() == this.dni) {
                    shoppingList.add(fac);
                }
            }
        }
        return shoppingList; // Devolviendo la lista de compras
    }
}