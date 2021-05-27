package it.epicode.be.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import it.epicode.be.model.Utente;
import it.epicode.be.persistance.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	UtenteRepository ur;

	public Optional<Utente> getById(Long idUtente) {
		return ur.findById(idUtente);
	}

	public List<Utente> getUtenteAll() {
		return ur.findAll();
	}

	public Utente creaUtente(Utente utente) {
		return ur.save(utente);
	}

	public void deleteUtente(long idUtente) {
		ur.deleteById(idUtente);

	}

	public Utente updateUtente(long idUtente, Utente utente) {
		return ur.save(utente);
	}

	public Optional<Utente> getPrenotazioneByUsername(String userName) {
	
		return ur.findByUsername(userName);
		
	}
	
	
}
