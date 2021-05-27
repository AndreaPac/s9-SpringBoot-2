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

import it.epicode.be.model.Edificio;
import it.epicode.be.model.Postazione;
import it.epicode.be.model.TipoPostazione;
import it.epicode.be.service.PostazioneService;

@RestController
@RequestMapping("/api")
public class ControllerPostazione {

	@Autowired
	private PostazioneService postazioneService;
	
	@GetMapping("/postazioneFormatExample")
	public Postazione cittaFormat() {
		Postazione p = new Postazione();
		p.setId(1l);
		p.setDescrizionePostazione("Ampia");
		p.setTipoPostazione(TipoPostazione.PRIVATO);
		p.setNumeroMassimoOccupanti(1);
		return p;
	}

	@GetMapping("/postazione/allpostazione")
	public ResponseEntity<List<Postazione>> postazione() {
		List<Postazione> listaPostazioni = postazioneService.getPostazioneAll();
		ResponseEntity<List<Postazione>> risposta = new ResponseEntity<>(listaPostazioni, HttpStatus.OK);

		return risposta;

	}

	@GetMapping("/postazione/{idPostazione}") // riga 39 e 40 stesso identico nome "idCitta"
	public ResponseEntity<Postazione> getEdificioById(@PathVariable(required = true) long idPostazione) {
		Optional<Postazione> postazioneOpt = postazioneService.getById(idPostazione);
		if (postazioneOpt.isPresent()) {
			return new ResponseEntity<>(postazioneOpt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/postazione")
	public ResponseEntity<Postazione> creaCitta(@RequestBody Postazione idPostazione) {
		try {
			Postazione postazioneSalvato = postazioneService.creaPostazione(idPostazione);
			return new ResponseEntity<Postazione>(postazioneSalvato, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new WebServerException("Postazione not saved", e);
		}
	}

	@DeleteMapping("/postazione/{idPostazione}")
	public ResponseEntity<Postazione> eliminaEdificio(@PathVariable(required = true) long idPostazione) {
		postazioneService.deletePostazione(idPostazione);
		return new ResponseEntity<Postazione>(HttpStatus.OK);
	}


	@PutMapping("/postazione/{idpostazione}")
	public ResponseEntity<Postazione> updateCitta(@PathVariable("idPostazione") long idPostazione, @RequestBody Postazione postazione) {
		try {
			Postazione result = postazioneService.updatePostazione(idPostazione, postazione);

			if (postazione != null) {
				return new ResponseEntity<>(postazione, HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			throw new WebServerException("Postazione not updated", e);
		}

	}

	
}
