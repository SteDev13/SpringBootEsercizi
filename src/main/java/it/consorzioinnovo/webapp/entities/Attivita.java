package it.consorzioinnovo.webapp.entities;

public class Attivita {
	private String nome;
	private Boolean completata;
	
	public Attivita(String nome) {
		super();
		this.nome = nome;
		this.completata = false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getCompletata() {
		return completata;
	}

	public void setCompletata() {
		this.completata = true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Attivita other = (Attivita) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome+"-"+ (completata ? "completata" : "non completata");
	}
	
}
