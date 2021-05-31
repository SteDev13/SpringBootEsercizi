package it.consorzioinnovo.webapp.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import it.consorzioinnovo.webapp.enums.CompletataEnum;

public class ListaAttivita {
	private UUID id;
	private String nome;
	private List<Attivita> attivita;
	
	public ListaAttivita(String nome) {
		super();
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.attivita = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UUID getId() {
		return id;
	}

	public List<Attivita> getAttivita() {
		return attivita;
	}
	
	public Boolean addAttivita(Attivita nuova) {
		return attivita.add(nuova);
	}
	
	public Boolean remAttivita(Attivita rem) {
		return attivita.remove(rem);
	}
	
	public CompletataEnum completaAttivita(String nomeAttivita) {
		/*
		 * 1) attivita trovata e completata
		 * 2) attivita trovata ma già completata
		 * 3) attività non trovata
		 * */
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaAttivita other = (ListaAttivita) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return attivita.toString();
	}
	
	
	
}
