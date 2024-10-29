package ar.edu.unju.escmi.tp6.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp6.dominio.TarjetaCredito;

public class CollectionTarjetaCredito {

	public static List<TarjetaCredito> tarjetas = new ArrayList<TarjetaCredito>();

    public static void precargarTarjetas() {
		if (tarjetas.isEmpty()) {
			tarjetas = new ArrayList<TarjetaCredito>();
			tarjetas.add(new TarjetaCredito(232323, LocalDate.of(2026,10,10), CollectionCliente.buscarCliente(45111222), 800000));
			tarjetas.add(new TarjetaCredito(4458444, LocalDate.of(2030, 3, 15), CollectionCliente.buscarCliente(36888666), 900000));
			tarjetas.add(new TarjetaCredito(8754566, LocalDate.of(2030, 4, 21), CollectionCliente.buscarCliente(25777555), 1000000));
		}
	}

	
	public static void agregarTarjetaCredito(TarjetaCredito tarjeta) {
		
		try {
			tarjetas.add(tarjeta);
		} catch (Exception e) {
			System.out.println("\nNO SE PUEDE GUARDAR LA TARJETA DE CREDITO");
		}
		
	}

	public static TarjetaCredito buscarTarjetaCredito(long numero) {
		TarjetaCredito tarjetaEncontrada = null;
		
		try {
			if (tarjetas != null) {
				for (TarjetaCredito tarjeta : tarjetas) {
					if (tarjeta.getNumero() == numero) {
						tarjetaEncontrada = tarjeta;
					}
				}
			}
		} catch (Exception e) {
			return null;
		}
		
		return tarjetaEncontrada;
	}
}
