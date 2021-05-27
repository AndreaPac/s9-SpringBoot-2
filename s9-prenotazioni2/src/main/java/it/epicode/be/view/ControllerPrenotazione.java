package it.epicode.be.view;

import java.time.LocalDate;
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
import it.epicode.be.model.Prenotazione;
import it.epicode.be.model.TipoPostazione;
import it.epicode.be.service.PrenotazioneService;

@RestController
@RequestMapping("/api")
public class ControllerPrenotazione {

	@Autowired
	private PrenotazioneService prenotazioneService;

	@GetMapping("/prenotazioneFormatExample")
	public Prenotazione prenotazioneFormat() {
		Prenotazione p = new Prenotazione();
		p.setId(1l);
		p.setDataPrenotazione(LocalDate.now());
		p.setDataPrenotata(LocalDate.now());
		return p;
	}

	@GetMapping("/prenotazione/allprenotazione")
	public ResponseEntity<List<Prenotazione>> postazione() {
		List<Prenotazione> listaPrenotazione = prenotazioneService.getPrenotazioneServiceAll();
		ResponseEntity<List<Prenotazione>> risposta = new ResponseEntity<>(listaPrenotazione, HttpStatus.OK);

		return risposta;

	}

	@GetMapping("/prenotazione/{idprenotazione}") // riga 39 e 40 stesso identico nome "idCitta"
	public ResponseEntity<Prenotazione> getPrenotazioneById(@PathVariable(required = true) long idprenotazione) {
		Optional<Prenotazione> prenotazioneOpt = prenotazioneService.getById(idprenotazione);
		if (prenotazioneOpt.isPresent()) {
			return new ResponseEntity<>(prenotazioneOpt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

//	@PostMapping("/prenotazione")
//	public ResponseEntity<Prenotazione> creaPrenotazione(@RequestBody Prenotazione idPrenotazione) {
//		try {
//			Postazione prenotazioneSalvata = prenotazioneService.prenotaPostazione(null, prenotazioneSalvata, null);
//			return new ResponseEntity<Prenotazione>(prenotazioneSalvata, HttpStatus.CREATED);
//		} catch (Exception e) {
//			throw new WebServerException("Prenotazione not saved", e);
//		}
//	}
//
//	@DeleteMapping("/prenotazione/{idPrenotazione}")
//	public ResponseEntity<Prenotazione> eliminaPrenotazione(@PathVariable(required = true) long idPrenotazione) {
//		prenotazioneService.deletePrenotazione(idPrenotazione);
//		return new ResponseEntity<Prenotazione>(HttpStatus.OK);
//	}
//
//
//	@PutMapping("/prenotazione/{idPrenotazione}")
//	public ResponseEntity<Postazione> updateCitta(@PathVariable("idPrenotazione") long idPrenotazione, @RequestBody Prenotazione prenotazione) {
//		try {
//			Prenotazione result = prenotazioneService.updatePrenotazione(idPrenotazione, prenotazione);
//
//			if (prenotazione != null) {
//				return new ResponseEntity<>(prenotazione, HttpStatus.OK);
//
//			} else {
//				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
//		} catch (Exception e) {
//			throw new WebServerException("Prenotazione not updated", e);
//		}
//
//	}

}
