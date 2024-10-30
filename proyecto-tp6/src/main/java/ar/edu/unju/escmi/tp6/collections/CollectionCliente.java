package ar.edu.unju.escmi.tp6.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp6.dominio.Cliente;
import ar.edu.unju.escmi.tp6.dominio.TarjetaCredito;

public class CollectionCliente {

    public static List<Cliente> clientes = new ArrayList<Cliente>();

    public static void precargarClientes() {
        if (clientes.isEmpty()) {
            // Crear tarjetas de crédito con la referencia al cliente correspondiente
            TarjetaCredito tarjeta1 = new TarjetaCredito(232323, LocalDate.of(2026, 10, 10), null, 800000);
            TarjetaCredito tarjeta2 = new TarjetaCredito(4458444, LocalDate.of(2030, 3, 15), null, 900000);
            TarjetaCredito tarjeta3 = new TarjetaCredito(8754566, LocalDate.of(2030, 4, 21), null, 1000000);

            // Asociar las tarjetas de crédito a los clientes
            Cliente cliente1 = new Cliente(45111222, "Mario Barca", "Alvear 120", "65454686", tarjeta1);
            tarjeta1.setCliente(cliente1); // Establecer el cliente en la tarjeta

            Cliente cliente2 = new Cliente(36888666, "Juan Perez", "Av. Belgrano 300", "35185695", tarjeta2);
            tarjeta2.setCliente(cliente2); // Establecer el cliente en la tarjeta

            Cliente cliente3 = new Cliente(25777555, "Ana Juarez", "Islas Malvinas 731", "38845224", tarjeta3);
            tarjeta3.setCliente(cliente3); // Establecer el cliente en la tarjeta

            // Agregar clientes a la lista
            clientes.add(cliente1);
            clientes.add(cliente2);
            clientes.add(cliente3);
        }
    }

    public static void agregarCliente(Cliente cliente) {
        try {
            clientes.add(cliente);
        } catch (Exception e) {
            System.out.println("\nNO SE PUEDE GUARDAR EL CLIENTE");
        }
    }

    public static Cliente buscarCliente(long dni) {
        Cliente clienteEncontrado = null;

        // Buscar el cliente por DNI
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dni) {
                clienteEncontrado = cliente;
                break;
            }
        }

        return clienteEncontrado;
    }
}
