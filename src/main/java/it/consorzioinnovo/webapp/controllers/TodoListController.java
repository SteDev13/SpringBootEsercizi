package it.consorzioinnovo.webapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.consorzioinnovo.webapp.dtos.AggiungiAttivitaRequestDTO;
import it.consorzioinnovo.webapp.dtos.CompletaAttivitaRequestDTO;
import it.consorzioinnovo.webapp.dtos.Utente;
import it.consorzioinnovo.webapp.enums.CompletataEnum;
import it.consorzioinnovo.webapp.enums.RegistrazioneEnum;
import it.consorzioinnovo.webapp.services.TodoListService;

@RestController
public class TodoListController {
	/*
	 * 1) Registrazione utente tramite POST a /registrazione con body { username:
	 * EMAIL } eseguendo una validazione del campo username prima dell'effettiva
	 * registrazione sul server
	 */

	@Autowired
	private TodoListService todoListService;

	private Logger logger = LoggerFactory.getLogger(TodoListController.class);

	@PostMapping("/registrazione")
	public String reg(@RequestBody Utente utente) {
		logger.info(utente.toString());
		logger.info("Registrazione utente " + utente.getUsername());

		RegistrazioneEnum resp = todoListService.registra(utente.getUsername());

		switch (resp) {
		case REGISTRATO:
			return "Utente registrato correttamente";
		case NONREGISTRATO:
			return "Utente non registrato correttamente.\nInserire un formato mail valido!";
		case PRESENTE:
			return "Utente già registrato";
		default:
			return "Enum errato";
		}
	}

	@PostMapping("/aggiungi/attivita")
	public String addActivity(@RequestBody AggiungiAttivitaRequestDTO request) {

		logger.info("Aggiunta attivita per l'utente " + request.getUsername());
		if (todoListService.aggiungiAttivita(request.getUsername(), request.getAttivita())) {
			return "Attività aggiunta correttamente";
		} else {
			return "Utente non registrato";
		}
	}

	@PostMapping("/completa/attivita")
	public String completeActivity(@RequestBody CompletaAttivitaRequestDTO request) {

		CompletataEnum doAct = todoListService.completaAttivita(request.getUsername(), request.getNomeAttivita());

		switch (doAct) {
		case NONREGISTRATO:
			return "Utente non registrato";
		case COMPLETATA:
			return "Attività completata";
		case GIACOMPLETATA:
			return "Attività già completata";
		case NONTROVATA:
			return "Attività non trovata";
		default:
			return "Enum errato";
		}
	}

}
