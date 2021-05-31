package it.consorzioinnovo.webapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/test/test3")
	public String hello() {
		String nome = "Davide";
		return "<i>Hello</i> " + nome;
	}
	
}
