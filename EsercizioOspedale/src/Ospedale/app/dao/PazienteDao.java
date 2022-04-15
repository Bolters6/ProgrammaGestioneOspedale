package Ospedale.app.dao;


import java.util.Hashtable;
import java.util.List;

import Ospedale.app.dao.entities.Paziente;

public class PazienteDao implements DAOconString<Paziente> {
	private static Hashtable<String, Paziente> dbPazienti = new Hashtable<>();
	
	
	@Override
	public void add(Paziente p) {
		if(p == null) {
			System.out.println("Questo Paziente non ha dati");
			return;
		}
		if(dbPazienti.contains(p)) {
			System.out.println("Questo Paziente esiste");
			return;
		}
	
		dbPazienti.put(p.getCodiceFiscale(), p);
	}

	@Override
	public void update(Paziente p) {
		boolean flag = false;
		for(String s: dbPazienti.keySet()) {
			if(dbPazienti.get(s).getCodiceFiscale().equals(p.getCodiceFiscale())){
				dbPazienti.put(s, p);
				flag = true;
				break;
			}
		}
		if(flag == false) {
			throw new RuntimeException("non posso aggiornare un paziente che non è nel db");
		}
	}

	@Override
	public Paziente get(String cf) {
		return dbPazienti.get(cf);
	}

	@Override
	public List<Paziente> findAll() {
		return (List<Paziente>) dbPazienti.values();
	}

	@Override
	public void delete(String cf) {
		dbPazienti.remove(cf);
	}

	
}
