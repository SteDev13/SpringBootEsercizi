package it.consorzioinnovo.webapp.services;

import it.consorzioinnovo.webapp.enums.CompletataEnum;
import it.consorzioinnovo.webapp.enums.RegistrazioneEnum;


public interface TodoListService {
	
	public RegistrazioneEnum registra(String username);
	
	public Boolean aggiungiAttivita(String username, String attivita);
	
	public CompletataEnum completaAttivita(String username, String attivita);
}
