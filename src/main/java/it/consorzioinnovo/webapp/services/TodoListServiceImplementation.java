package it.consorzioinnovo.webapp.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.consorzioinnovo.webapp.entities.Attivita;
import it.consorzioinnovo.webapp.entities.ListaAttivita;
import it.consorzioinnovo.webapp.enums.CompletataEnum;
import it.consorzioinnovo.webapp.enums.RegistrazioneEnum;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

@Service
public class TodoListServiceImplementation implements TodoListService {
	public static List<String> utentiRegistrati = new ArrayList<>();

	public static Map<String, ListaAttivita> activities = new HashMap<>(); // chiave:username , valore:lista delle
																			// attività dell'utente

	private Logger logger = LoggerFactory.getLogger(TodoListService.class);

	@Override
	public RegistrazioneEnum registra(String username) {
		if (isValidEmail(username)) {
			if (utentiRegistrati.contains(username)) {
				return RegistrazioneEnum.PRESENTE;
			} else {
				utentiRegistrati.add(username);
				ListaAttivita nuovaLista = new ListaAttivita("lista dell'utente " + username);
				activities.put(username, nuovaLista);
				logger.info(utentiRegistrati.toString());
				return RegistrazioneEnum.REGISTRATO;
			}

		} else {
			logger.info(utentiRegistrati.toString());
			return RegistrazioneEnum.NONREGISTRATO;
		}
	}

	private Boolean isValidEmail(String username) {
		Pattern regexPattern;
		Matcher regexMatcher;

		regexPattern = Pattern.compile(
				"^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,4}))$");
		regexMatcher = regexPattern.matcher(username);
		if (regexMatcher.matches()) {
			return true; // "Valid Email Address: " + username;
		} else {
			return false; // "Invalid Email Address: " + username;
		}
		/*
		 * try { InternetAddress emailAddr = new InternetAddress(email);
		 * emailAddr.validate(); } catch (AddressException ex) { result = false; }
		 * return result;
		 */
	}

	@Override
	public Boolean aggiungiAttivita(String username, String attivita) {
		/*
		 * 1) verifico nella mappa se è presente l'utente (e quindi se c'è la chiave con
		 * la sua email) 2) se non è presente creo l'associazione chiave:email
		 * valore:nuova lista di attivita (creata con il costruttore con il solo nome)
		 * 2.1) aggiungo l'attivita alla lista appena creata 3) se è presente aggiungere
		 * direttamente l'attività alla lista indicizzata dall'email dell'utente
		 * (utilizzare il valore ottenuto dalla get sulla mappa con il parametro di
		 * chiave username)
		 * 
		 */
		if (activities.containsKey(username)) {
			activities.get(username).addAttivita(new Attivita(attivita));
			logger.info(username + ": " + activities.get(username).toString());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public CompletataEnum completaAttivita(String username, String nomeAttivita) {
		if (utentiRegistrati.contains(username)) {
			List<Attivita> attivitaUtente = activities.get(username).getAttivita();
			for (Attivita att : attivitaUtente) {
				if (att.getNome().equals(nomeAttivita)) {
					if (att.getCompletata())
						return CompletataEnum.GIACOMPLETATA;
					else {
						att.setCompletata();
						return CompletataEnum.COMPLETATA;
					}
				}
			}
			return CompletataEnum.NONTROVATA;
		} else {
			return CompletataEnum.NONREGISTRATO;
		}
	}
}
