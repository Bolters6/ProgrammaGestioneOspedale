package Ospedale.app.dao.entities;

import java.util.HashMap;

public class CartellaClinica {
	private Paziente p;
	private int codiceCartella;
	private HashMap<String, Integer> organiMalati = new HashMap<>();
	
	public CartellaClinica(Paziente p, int gravita, String nomeOrgano) {
		this.p = p;
		this.codiceCartella = 0;
		this.organiMalati.put(nomeOrgano, gravita);
	}
	


	public HashMap<String, Integer> getOrganiMalati() {
		return organiMalati;
	}


	public void setOrganiMalati(String nomeOrgano, int gravita) {
		this.organiMalati.put(nomeOrgano, gravita);
	}


	public Paziente getP() {
		return p;
	}

	public void setP(Paziente p) {
		this.p = p;
	}

	public int getCodiceCartella() {
		return codiceCartella;
	}

	public void setCodiceCartella(int codiceCartella) {
		this.codiceCartella = codiceCartella;
	}
	
}
