package it.epicode.be.view;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.model.Citta;
import it.epicode.be.model.Edificio;
import it.epicode.be.persistance.EdificioRepository;
import it.epicode.be.service.EdificioService;

@RestController
@RequestMapping("/api")
public class ControllerEdificio {

	@Autowired
	private EdificioService edificioService;

	@GetMapping("/edificioFormatExample")
	public Edificio cittaFormat() {
		Edificio e = new Edificio();
		e.setId(1l);
		e.setNomeEdificio("Palazzo Santi");
		e.setIndirizzoEdificio("Via dai c");
		e.setCitta(null);
		return e;
	}

	@GetMapping("/edificio/alledificio")
	public ResponseEntity<List<Edificio>> edificio() {
		List<Edificio> listaedificio = edificioService.getEdificioAll();
		ResponseEntity<List<Edificio>> risposta = new ResponseEntity<>(listaedificio, HttpStatus.OK);

		return risposta;

	}

	@GetMapping("/edificio/{idEdificio}") // riga 39 e 40 stesso identico nome "idCitta"
	public ResponseEntity<Edificio> getEdificioById(@PathVariable(required = true) long idEdificio) {
		Optional<Edificio> edificioOpt = edificioService.getById(idEdificio);
		if (edificioOpt.isPresent()) {
			return new ResponseEntity<>(edificioOpt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/edificio")
	public ResponseEntity<Edificio> creaCitta(@RequestBody Edificio idEdificio) {
		try {
			Edificio edificioSalvato = edificioService.creaEdificio(idEdificio);
			return new ResponseEntity<Edificio>(edificioSalvato, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new WebServerException("Edificio not saved", e);
		}
	}

	@DeleteMapping("/edificio/{idEdificio}")
	public ResponseEntity<Edificio> eliminaEdificio(@PathVariable(required = true) long idEdificio) {
		edificioService.deleteEdificio(idEdificio);
		return new ResponseEntity<Edificio>(HttpStatus.OK);
	}


	@PutMapping("/edificio/{idEdificio}")
	public ResponseEntity<Edificio> updateCitta(@PathVariable("idEdificio") long idEdificio, @RequestBody Edificio edificio) {
		try {
			Edificio result = edificioService.updateEdificio(idEdificio, edificio);

			if (edificio != null) {
				return new ResponseEntity<>(edificio, HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			throw new WebServerException("Edificio not updated", e);
		}

	}


}
