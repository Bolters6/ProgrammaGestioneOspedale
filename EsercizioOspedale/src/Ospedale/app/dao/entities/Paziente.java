package Ospedale.app.dao.entities;

public class Paziente {
	private String codiceFiscale;
	private String nome;
	private String indirizzo;
	private int cartellaClinica;
	
	public Paziente(String codiceFiscale, String nome, String indirizzo) {
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.cartellaClinica = 0;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getCartellaClinica() {
		return cartellaClinica;
	}

	public void setCartellaClinica(int cartellaClinica) {
		this.cartellaClinica = cartellaClinica;
	}

	@Override
	public String toString() {
		return "Paziente [codiceFiscale=" + codiceFiscale + ", nome=" + nome + ", indirizzo=" + indirizzo
				+ ", cartellaClinica=" + cartellaClinica + "]";
	}
	
}
