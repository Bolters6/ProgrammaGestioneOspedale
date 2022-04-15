package Ospedale.app.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import Ospedale.app.dao.entities.CartellaClinica;

public class CartellaClinicaDao implements DAO<CartellaClinica> {
	private static Hashtable<Integer, CartellaClinica> dbCartellaClinica = new Hashtable<>();
	private static int id = 0;
	
	@Override
	public void add(CartellaClinica cc) {
		if(dbCartellaClinica.contains(cc)) {
			System.out.println("Cartella Clinica gia esistente");
			return;
		}
		if(cc == null) {
			System.out.println("non ci sono dati");
			return;
		}
		cc.setCodiceCartella(id++);
		dbCartellaClinica.put(id, cc);
		
	}

	@Override
	public void delete(int id) {
		dbCartellaClinica.remove(id);
	}

	@Override
	public void update(CartellaClinica cc) {
		if(cc.getCodiceCartella() == 0) {
			throw new RuntimeException("non posso aggiornare un paziente che non è nel db");
		}
		dbCartellaClinica.put(cc.getCodiceCartella(), cc);
		
	}

	@Override
	public CartellaClinica get(int id) {
		dbCartellaClinica.get(id);
		return null;
	}

	@Override
	public List<CartellaClinica> findAll() {
		return new ArrayList<>(dbCartellaClinica.values());
	}
	
}
