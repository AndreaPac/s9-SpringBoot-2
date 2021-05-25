package it.epicode.be.service;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.epicode.be.model.Postazione;
import it.epicode.be.model.Prenotazione;
import it.epicode.be.model.Utente;
import it.epicode.be.persistance.PrenotazioneRepository;



@Service
public class PrenotazioneService {

	@Autowired
	PrenotazioneRepository pr;
	
	public Prenotazione prenota(Utente u, Postazione p, LocalDate l){
		
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setUtente(u);
		prenotazione.setPostazione(p);
		prenotazione.setDataPrenotata(l);
		pr.save(prenotazione);
		return prenotazione;
		
	}
	
}
