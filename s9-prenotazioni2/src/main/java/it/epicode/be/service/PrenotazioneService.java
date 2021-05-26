package it.epicode.be.service;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.epicode.be.model.Postazione;
import it.epicode.be.model.Prenotazione;
import it.epicode.be.model.Utente;
import it.epicode.be.persistance.PrenotazioneRepository;
import it.epicode.be.persistance.UtenteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PrenotazioneService {

	@Autowired
	UtenteRepository ur;

	@Autowired
	PrenotazioneRepository pr;

	// restituisce true se postazione libera, altrimenti false
	public boolean verificaPostazioneLibera(Postazione p, LocalDate ld) {
		for (Prenotazione pr : p.getListaPrenotazioni()) {
			if (pr.getDataPrenotazione().equals(ld))
				return false;
			//cancella log se dà errori
			log.info("***** POSTAZIONE GIà OCCUPATA NEL GIORNO " + ld + "*****");
		}
		return true;
	}

	// Restituisce true se l'utente non ha prenotato in quella giornata, altrimenti false
	public boolean verificaUtenteLibera(Utente u, LocalDate ld) {

		for (Prenotazione pr : u.getPrenotazioneUtente()) {
			if (pr.getDataPrenotazione().equals(ld)) {
				return false;
			}
		}
		return true;
	}

	public Prenotazione prenotaPostazione(Utente u, Postazione p, LocalDate ld) {
		// sezione controlli
		if (!verificaPostazioneLibera(p, ld)) {

			return null;
		}
		if (!verificaUtenteLibera(u, ld)) {
			return null;
		}

		// costruzione prenotazione regolare
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setDataPrenotazione(ld);
		prenotazione.setPostazione(p);
		prenotazione.setUtente(u);

		Prenotazione prenotazioneSalvata = pr.save(prenotazione);

		return prenotazioneSalvata;

	}
}
