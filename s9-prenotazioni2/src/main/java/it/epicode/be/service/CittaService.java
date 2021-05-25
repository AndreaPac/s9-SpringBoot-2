package it.epicode.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be.model.Citta;
import it.epicode.be.persistance.CittaRepository;
@Service
public class CittaService {

	@Autowired
	private CittaRepository  cr;
	
	public void popolaCitta() {
		
		Citta c1 = new Citta();
		c1.setNome("Roma");
		cr.save(c1);

		Citta c2 = new Citta();
		c2.setNome("Milano");
		cr.save(c2);

		Citta c3 = new Citta();
		c3.setNome("Palermo");
		cr.save(c3);

		Citta c4 = new Citta();
		c4.setNome("Verona");
		cr.save(c4);

		Citta c5 = new Citta();
		c5.setNome("Torino");
		cr.save(c5);

	}
	
}
