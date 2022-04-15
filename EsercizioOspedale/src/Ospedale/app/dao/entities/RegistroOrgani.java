package Ospedale.app.dao.entities;

public class RegistroOrgani {
	private String nome;
	private String dataArrivo;
	private Organo o;
	private int id;
	
	public RegistroOrgani(String nome, String dataArrivo, Organo o) {
		this.nome = nome;
		this.dataArrivo = dataArrivo;
		this.o = o;
		this.id = 0;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Organo getOrgano() {
		return this.o;
	}
	
	public void setOrgano(Organo o) {
		this.o = o;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataArrivo() {
		return dataArrivo;
	}

	public void setDataArrivo(String dataArrivo) {
		this.dataArrivo = dataArrivo;
	}
	
}
