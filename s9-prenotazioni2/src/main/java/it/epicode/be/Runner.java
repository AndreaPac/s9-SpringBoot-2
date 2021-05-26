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
import lombok.extern.slf4j.Slf4j;
@Slf4j
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
		
		
		
//		cs.popolaCitta();
//		es.popolaEdificio();
//		us.popolaUtenti();
//		ps.popolaPostazione();
//		
//		log.info("********* Mi trovo nel Runner ***********");
//		
//		Utente u1 = us.getById(1l);
//		Utente u2 = us.getById(2l);
//		Postazione p1 = ps.getById(1l);
//		Postazione p2 = ps.getById(2l);
//		
//		prenSer.prenotaPostazione(u1, p1, LocalDate.now());
//		prenSer.prenotaPostazione(u2, p2, LocalDate.now());
//		
	
	}

}
