package it.epicode.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.epicode.be.model.Edificio;
import it.epicode.be.persistance.CittaRepository;
import it.epicode.be.persistance.EdificioRepository;

@Service
public class EdificioService {

	@Autowired
	private EdificioRepository er;
	@Autowired
	private CittaRepository cr;

	public void popolaEdificio() {

		Edificio e1 = new Edificio();

		e1.setIndirizzoEdificio("Via Garibaldi 127");
		e1.setNomeEdificio("Palazzo Comunale");
		e1.setCitta(cr.getById(1l));
		er.save(e1);

		Edificio e2 = new Edificio();

		e2.setIndirizzoEdificio("Via degli Errori 404");
		e2.setNomeEdificio("Palazzo Micidiale");
		e2.setCitta(cr.getById(2l));
		er.save(e2);

	}

}
