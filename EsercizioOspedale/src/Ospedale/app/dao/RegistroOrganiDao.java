package Ospedale.app.dao;

import java.util.Hashtable;
import java.util.List;

import Ospedale.app.dao.entities.RegistroOrgani;

public class RegistroOrganiDao implements DAO<RegistroOrgani> {
	private static Hashtable<Integer, RegistroOrgani> dbRegistroOrgani = new Hashtable<>();
	private static int id = 0;
	
	@Override
	public void add(RegistroOrgani ro) {
		if(dbRegistroOrgani.contains(ro)) {
			System.out.println("Organo gia esistente");
			return;
		}
		if(ro == null) {
			System.out.println("non ci sono dati");
			return;
		}
		ro.setId(id++);
		dbRegistroOrgani.put(id, ro);
		
	}

	@Override
	public void delete(int id) {
		dbRegistroOrgani.remove(id);
		
	}

	@Override
	public void update(RegistroOrgani ro) {
		if(ro.getId() == 0) {
			throw new RuntimeException("non posso aggiornare un paziente che non è nel db");
		}
		dbRegistroOrgani.put(ro.getId(), ro);
	}

	@Override
	public RegistroOrgani get(int id) {
		return dbRegistroOrgani.get(id);
	}

	@Override
	public List<RegistroOrgani> findAll() {
		return (List<RegistroOrgani>) dbRegistroOrgani.values();
	}

}
