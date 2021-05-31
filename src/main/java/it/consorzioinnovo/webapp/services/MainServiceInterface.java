package it.consorzioinnovo.webapp.services;

import java.util.List;

public interface MainServiceInterface {
	
	
	
	public String inserimento(String todo);
	
	public List<String> lettura();
	
	public String modifica(int pos, String todo);
	
	public void eliminazione(int pos);
	
	public String eliminazionePerTodo(String todo);

}
