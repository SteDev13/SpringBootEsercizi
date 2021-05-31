package it.consorzioinnovo.webapp.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import it.consorzioinnovo.webapp.services.MainServiceImplementation;

@RestController
public class MainController3 {
	@Autowired
	MainServiceImplementation mainService;
	
	private Logger logger = LoggerFactory.getLogger(MainController3.class);

	@GetMapping("/ins1/{add}")
	public String Add(@PathVariable String add) {
		logger.info("Inserimento elemento "+add);
		return mainService.inserimento(add);
		// System.out.println("valore inserito: " +);
	}

	@GetMapping("/del2/{del}")
	public void Del(@PathVariable int del) {
		logger.info("Cancellazione elemento in posizione "+del);
		mainService.eliminazione(del);
		// System.out.println("valore inserito: " +);
	}
	
	@GetMapping("/eliminazionepertodo/{todo}")
	public String Del(@PathVariable String todo) {
		logger.info("Cancellazione elemento "+todo);
		return mainService.eliminazionePerTodo(todo);
	}

	@GetMapping("/view3")
	public List<String> View() {
		logger.info("Visualizzazione elementi");
		return mainService.lettura();
	}

	@GetMapping("/mod4/{pos}/{mod}")
	public String Mod(@PathVariable int pos, @PathVariable String mod) {
		logger.info("Sostituzione elemento in posizione "+pos+" con "+mod);
		return mainService.modifica(pos, mod);
		// System.out.println("valore inserito: " +);
	}
}
