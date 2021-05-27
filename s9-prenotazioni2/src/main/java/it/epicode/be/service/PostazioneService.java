package it.epicode.be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be.model.Citta;
import it.epicode.be.model.Edificio;
import it.epicode.be.model.Postazione;
import it.epicode.be.model.TipoPostazione;

import it.epicode.be.persistance.EdificioRepository;
import it.epicode.be.persistance.PostazioneRepository;

@Service
public class PostazioneService {

	@Autowired
	PostazioneRepository pr;

	public Optional<Postazione> getById(long idPostazione) {
		return pr.findById(idPostazione);
	}

	public List<Postazione> getPostazioneAll() {
		return pr.findAll();
	}

	public Postazione creaPostazione(Postazione postazione) {
		return pr.save(postazione);
	}

	public void deletePostazione(long idPostazione) {
		pr.deleteById(idPostazione);

	}

	public Postazione updatePostazione(long idPostazione, Postazione postazione) {

		return pr.save(postazione);

	}

}
