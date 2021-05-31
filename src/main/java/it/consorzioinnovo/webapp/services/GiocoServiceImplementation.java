package it.consorzioinnovo.webapp.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GiocoServiceImplementation implements GiocoService {
	
	public static List<String> dizionario = new ArrayList<>(List.of("Libro","Casa","Auto","Albero","Astronave","Dizionario"));
	
	private Logger logger = LoggerFactory.getLogger(GiocoService.class);

	@Override
	public String nuovaPartita(String partita) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String aggiungi(String agg) {
		
		return "";
	}
	
	

	
	

}
