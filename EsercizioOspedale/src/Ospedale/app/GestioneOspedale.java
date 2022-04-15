package Ospedale.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Ospedale.app.dao.CartellaClinicaDao;
import Ospedale.app.dao.DAO;
import Ospedale.app.dao.DAOconString;
import Ospedale.app.dao.OrganoDao;
import Ospedale.app.dao.PazienteDao;
import Ospedale.app.dao.RegistroOrganiDao;
import Ospedale.app.dao.entities.CartellaClinica;
import Ospedale.app.dao.entities.Organo;
import Ospedale.app.dao.entities.Paziente;
import Ospedale.app.dao.entities.RegistroOrgani;
import Ospedale.app.exceptions.NoObjectException;
import Ospedale.app.exceptions.OrganoPresenteException;
import Ospedale.app.exceptions.PazienteException;
import Ospedale.app.utils.BeanFactory;

public class GestioneOspedale implements InterfacciaGestioneOspedali{
	private DAOconString daoPazienti;
	private DAOconString daoOrgano;
	private DAO daoRegistroOrgani;
	private DAO daoCartellaClinica;
	private Scanner scan;
	
	public GestioneOspedale() {
		this.scan = new Scanner(System.in);
		this.daoPazienti = BeanFactory.pazienteDAOFactory();
		this.daoOrgano = BeanFactory.organoDAOFactory();
		this.daoCartellaClinica = BeanFactory.cartellaClinicaDAOFactory();
		this.daoRegistroOrgani = BeanFactory.registroOrganiDAOFactory();
	}
	
	public void applicazione() {
		try {
		System.out.println("Benvenuti al sistema del Ospedale");
		System.out.println("1) Aggiungi un Organo nel Sistema");
		System.out.println("2) Aggiungi un Paziente nel Sistema");
		System.out.println("3) Aggiorna la cartella clinica di un Paziente");
		System.out.println("4) Trova il Paziente piu adatto per l' organo richiesto");
		System.out.println("5) Uscire dal Sistema");
		System.out.println("Inserisci il numero corrispondente a la azione da compiere");
		int choose = this.scan.nextInt();
		this.scan.nextLine();
		switch(choose) {
		case 1:
			System.out.println("Aggiungi un Codice per l' organo ad aggiungere");
			String co = this.scan.next();
			co+=this.scan.nextLine();
			System.out.println("Aggiungi l' eta dil donatore");
			int eta = this.scan.nextInt();
			this.scan.nextLine();
			System.out.println("Aggiungi il gruppo sanguineo dil donatore");
			String gs = this.scan.next(); 
			gs+=this.scan.nextLine(); 
			System.out.println("Aggiungi la data di Arrivo dell organo");  
			String data = this.scan.next(); 
			data+=this.scan.nextLine(); 
			try { 
				addOrgano(co, eta, gs, data); 
			} catch (OrganoPresenteException e) { 
				System.out.println(e.getMessage());
			} 
			break; 
			
		case 2:
			System.out.println("Aggiungi il codice fiscale del paziente");
			String cf = this.scan.next();
			cf+=this.scan.nextLine();
			System.out.println("Aggiungi il nome dil paziente");
			String nome = this.scan.next();
			nome+=this.scan.nextLine();
			System.out.println("Aggiungi l' indirizzo del paziente");
			String indirizzo = this.scan.next();
			indirizzo+=this.scan.nextLine();
			Paziente p = new Paziente(cf, nome, indirizzo);
			try {
				addPaziente(p);
			} catch (PazienteException e) {
				System.out.println(e.getMessage());	
			}
			break;
		case 3:
			System.out.println("Aggiungi il codice fiscale del paziente");
			cf = this.scan.next();
			cf+=this.scan.nextLine();
			System.out.println("Aggiungi il nome del organo richiesto");
			String nomeOrgano = this.scan.next();
			nomeOrgano+=this.scan.nextLine();
			System.out.println("Inserisci la gravita de la malattia del Organo");
			int g = this.scan.nextInt();
			this.scan.nextLine();
			updatePaziente(cf,nomeOrgano, g);
			break;
		case 4:
			System.out.println("Inserisci il nome del Organo per trovare il best match");
			nomeOrgano = this.scan.next();
			nomeOrgano+=this.scan.nextLine();
			try {
				System.out.print("Il paziente piu adatto e: ");
				System.out.println(bestMatch(nomeOrgano));
			} catch (NoObjectException e) {
				System.out.println(e.getMessage());	
			}
			break;
		case 5:
			System.out.println("Grazie per usare il software");
			System.exit(0);
			break;
		default:
			System.out.println("il valore inserito non e valido, riprova!");
			this.applicazione();
		}
		}catch(InputMismatchException e){
			System.out.println("valore non valido, riprova!!!");
			this.scan.nextLine();
		}
		this.applicazione();
		}

	@Override
	public void addOrgano(String codiceOrgano, int et‡Donatore, String gruppoSanguignoDonatore, String d) throws OrganoPresenteException {
		Organo o = new Organo(codiceOrgano, et‡Donatore, gruppoSanguignoDonatore);
		if(!(this.daoOrgano.get(codiceOrgano) == null)) {
			throw new OrganoPresenteException();
		}
		this.daoOrgano.add(o);
		System.out.println("Inserire il tipo di organo");
		String tipo = this.scan.next();
		tipo+=this.scan.nextLine();
		RegistroOrgani ro = new RegistroOrgani(tipo, d, o);
		this.daoRegistroOrgani.add(ro);
	}

	@Override
	public void addPaziente(Paziente p) throws PazienteException {
		if(!(this.daoPazienti.get(p.getCodiceFiscale()) == null)) {
			throw new PazienteException();
		}
		this.daoPazienti.add(p);
	}

	@Override
	public void updatePaziente(String cf, String nomeOrgano, int gravit‡) {
		if(((Paziente) this.daoPazienti.get(cf)).getCartellaClinica() == 0) {
		CartellaClinica cc = new CartellaClinica((Paziente)this.daoPazienti.get(cf), gravit‡, nomeOrgano);
		this.daoCartellaClinica.add(cc);
		return;
		}
		((CartellaClinica) this.daoCartellaClinica.get(((Paziente) this.daoPazienti.get(cf)).getCartellaClinica())).setOrganiMalati(nomeOrgano, gravit‡);
	}

	@Override
	public Paziente bestMatch(String o) throws NoObjectException {
		int gravitamax = 0;
		Paziente pazientequalificato = null;
		for (CartellaClinica cc: (ArrayList<CartellaClinica>) this.daoCartellaClinica.findAll()) {
			if(cc.getOrganiMalati().get(o) == null) {
				throw new NoObjectException();
			}
			if(cc.getOrganiMalati().get(o) >= gravitamax) {
				pazientequalificato = cc.getP();
				gravitamax = cc.getOrganiMalati().get(o);
			}
		}
		return pazientequalificato;
	}



}	
