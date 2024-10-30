package ar.edu.unju.escmi.tp6.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp6.dominio.Credito;

public class CollectionCredito {

	 public static List<Credito> creditos = new ArrayList<Credito>();

	 public static void agregarCredito(Credito credito) {
	        
	    	try {
	    		creditos.add(credito);
			} catch (Exception e) {
				System.out.println("\nNO SE PUEDE GUARDAR EL CREDITO");
			}
	    	
	    }
}
