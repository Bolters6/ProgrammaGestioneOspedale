package Ospedale.app.dao.entities;

public class Organo {
	private String codiceOrgano;
	private int donatore;
	private String gruppoSanguineo;
	
	
	public Organo(String codiceOrgano, int donatore, String gruppoSanguineo) {
		this.codiceOrgano = codiceOrgano;
		this.donatore = donatore;
		this.gruppoSanguineo = gruppoSanguineo;
	}
	
	public String getCodiceOrgano() {
		return codiceOrgano;
	}

	public void setCodiceOrgano(String codiceOrgano) {
		this.codiceOrgano = codiceOrgano;
	}

	public int getDonatore() {
		return donatore;
	}

	public void setDonatore(int donatore) {
		this.donatore = donatore;
	}

	public String getGruppoSanguineo() {
		return gruppoSanguineo;
	}

	public void setGruppoSanguineo(String gruppoSanguineo) {
		this.gruppoSanguineo = gruppoSanguineo;
	}
	
	
}
