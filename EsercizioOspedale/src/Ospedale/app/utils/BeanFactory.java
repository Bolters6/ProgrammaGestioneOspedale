package Ospedale.app.utils;

import Ospedale.app.dao.CartellaClinicaDao;
import Ospedale.app.dao.DAO;
import Ospedale.app.dao.DAOconString;
import Ospedale.app.dao.OrganoDao;
import Ospedale.app.dao.PazienteDao;
import Ospedale.app.dao.RegistroOrganiDao;

public class BeanFactory{
	
	private static DAOconString pazienteDao;
	private static DAOconString organoDao;
	private static DAO registroOrganiDao;
	private static DAO cartellaClinicaDao;
	
	public static DAOconString pazienteDAOFactory() {
		if(pazienteDao == null) {
			return new PazienteDao();
		}
		return pazienteDao;
	}
	public static DAOconString organoDAOFactory() {
		if(organoDao == null) {
			return new OrganoDao();
		}
		return organoDao;
		
	}
	public static DAO registroOrganiDAOFactory() {
		if(registroOrganiDao == null) {
			return new RegistroOrganiDao();
		}
		return registroOrganiDao;
	}
	public static DAO cartellaClinicaDAOFactory() {
		if(cartellaClinicaDao == null) {
			return new CartellaClinicaDao();
		}
		return cartellaClinicaDao;
	}
}
