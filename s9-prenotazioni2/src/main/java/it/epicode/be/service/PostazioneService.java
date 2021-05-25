package it.epicode.be.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.epicode.be.model.Postazione;
import it.epicode.be.model.TipoPostazione;

import it.epicode.be.persistance.EdificioRepository;
import it.epicode.be.persistance.PostazioneRepository;

@Service
public class PostazioneService {

	@Autowired
	PostazioneRepository pr;
	
	@Autowired
	EdificioRepository er;
	
	public void popolaPostazione() {
		
		Postazione p1 = new Postazione();
		
		p1.setDescrizionePostazione("Scrivania 120x70");
		p1.setTipoPostazione(TipoPostazione.PRIVATO);
		p1.setNumeroMassimoOccupanti(1);
		p1.setEdificio(er.getById(1l));
		pr.save(p1);
		
		Postazione p2 = new Postazione();
		
		p2.setDescrizionePostazione("Scrivania 200x130");
		p2.setTipoPostazione(TipoPostazione.OPENSPACE);
		p2.setNumeroMassimoOccupanti(3);
		p2.setEdificio(er.getById(1l));
		pr.save(p2);
		
		
	}
	public Postazione getById(Long id) {
		return pr.getById(id);
	}
}
