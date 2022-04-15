package Ospedale.app;

import Ospedale.app.dao.entities.Paziente;
import Ospedale.app.exceptions.NoObjectException;
import Ospedale.app.exceptions.OrganoPresenteException;
import Ospedale.app.exceptions.PazienteException;

public interface InterfacciaGestioneOspedali {
	
	public void addOrgano(String codiceOrgano, int et‡Donatore, String gruppoSanguignoDonatore, String d) throws OrganoPresenteException;
	public void addPaziente(Paziente p) throws PazienteException; 
	public void updatePaziente(String cf, String nomeOrgano, int gravit‡);
	public Paziente bestMatch(String o) throws NoObjectException;
	
}
