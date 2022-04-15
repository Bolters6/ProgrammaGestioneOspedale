package Ospedale.app.dao;

import java.util.Hashtable;

import java.util.List;

import Ospedale.app.dao.entities.Organo;

public class OrganoDao implements DAOconString<Organo> {
	private static Hashtable<String, Organo> dbOrgani = new Hashtable<>();
	
	@Override
	public void add(Organo o) {
		if(dbOrgani.contains(o)) {
			System.out.println("Organo gia esistente");
			return;
		}
		if(o == null) {
			System.out.println("non ci sono dati");
			return;
		}
		
		dbOrgani.put(o.getCodiceOrgano(), o);
		
	}

	@Override
	public void delete(String id) {
		dbOrgani.remove(id);
		
	}

	@Override
	public void update(Organo o) {
		boolean flag = false;
		for(String s: dbOrgani.keySet()) {
			if(dbOrgani.get(s).getCodiceOrgano().equals(o.getCodiceOrgano())){
				dbOrgani.put(s, o);
				flag = true;
				break;
			}
		}
		if(flag == false) {
			throw new RuntimeException("non posso aggiornare un Organo che non è nel db");
		}
	}

	@Override
	public Organo get(String id) {
		return dbOrgani.get(id);
	}

	@Override
	public List<Organo> findAll() {
		return (List<Organo>) dbOrgani.values();
	}

}
