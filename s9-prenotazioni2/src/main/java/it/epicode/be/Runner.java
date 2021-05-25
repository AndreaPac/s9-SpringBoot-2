package it.epicode.be;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import it.epicode.be.model.Postazione;
import it.epicode.be.model.Utente;
import it.epicode.be.service.CittaService;
import it.epicode.be.service.EdificioService;
import it.epicode.be.service.PostazioneService;
import it.epicode.be.service.PrenotazioneService;
import it.epicode.be.service.UtenteService;

public class Runner implements CommandLineRunner {

	@Autowired
	private PrenotazioneService prenSer;
	
	@Autowired
	private UtenteService us;
	@Autowired
	private PostazioneService ps;
	@Autowired
	private CittaService cs;
	@Autowired
	private EdificioService es;

	@Override
	public void run(String... args) throws Exception {
		
		cs.popolaCitta();
		es.popolaEdificio();
		us.popolaUtenti();
		ps.popolaPostazione();
		
		Utente u1 = us.getById(1l);
		Postazione p1 = ps.getById(1l);
		
		prenSer.prenota(u1, p1, LocalDate.now());

	}

}
