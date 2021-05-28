package it.epicode.be.view;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.model.Edificio;
import it.epicode.be.model.Postazione;
import it.epicode.be.model.Prenotazione;
import it.epicode.be.model.TipoPostazione;
import it.epicode.be.model.Utente;
import it.epicode.be.security.JwtUtils;
import it.epicode.be.service.PostazioneService;
import it.epicode.be.service.PrenotazioneService;
import it.epicode.be.service.UtenteService;

@RestController
@RequestMapping("/api")
public class ControllerPrenotazione {

	@Autowired
	private PrenotazioneService prenotazioneService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UtenteService us;

	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/prenotazioneFormatExample")
	public Prenotazione prenotazioneFormat() {
		Prenotazione p = new Prenotazione();
		p.setId(1l);
		p.setDataPrenotazione(LocalDate.now());
		p.setDataPrenotata(LocalDate.now());
		return p;
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/prenotazione/allprenotazione")
	public ResponseEntity<List<Prenotazione>> GetAllprenotazione() {
		List<Prenotazione> listaPrenotazione = prenotazioneService.getPrenotazioneServiceAll();
		ResponseEntity<List<Prenotazione>> risposta = new ResponseEntity<>(listaPrenotazione, HttpStatus.OK);

		return risposta;

	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/prenotazione/{idprenotazione}")
	public ResponseEntity<Prenotazione> getPrenotazioneById(@PathVariable(required = true) long idprenotazione) {
		Optional<Prenotazione> prenotazioneOpt = prenotazioneService.getById(idprenotazione);
		if (prenotazioneOpt.isPresent()) {
			return new ResponseEntity<>(prenotazioneOpt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/prenotazione")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Prenotazione> creaPrenotazione(@RequestBody Prenotazione prenotazione) {
		try {
			Prenotazione prenotazioneSalvata = prenotazioneService.prenotaPostazione(prenotazione.getUtente(),
					prenotazione.getPostazione(), prenotazione.getDataPrenotazione());
			return new ResponseEntity<Prenotazione>(prenotazioneSalvata, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new WebServerException("Prenotazione not saved", e);
		}
	}

	@DeleteMapping("/prenotazione/{idPrenotazione}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Prenotazione> eliminaPrenotazione(@PathVariable(required = true) long idPrenotazione) {
		prenotazioneService.deletePrenotazione(idPrenotazione);
		return new ResponseEntity<Prenotazione>(HttpStatus.OK);
	}

	@PutMapping("/prenotazione/{idPrenotazione}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Prenotazione> updatePrenotazione(@PathVariable("idPrenotazione") long idPrenotazione,
			@RequestBody Prenotazione prenotazione) {
		try {
			Prenotazione result = prenotazioneService.updatePrenotazione(idPrenotazione, prenotazione);

			if (prenotazione != null) {
				return new ResponseEntity<>(result, HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			throw new WebServerException("Prenotazione not updated", e);
		}

	}

//	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
//	@GetMapping("/prenotazioneUtentiPerUserName")
//	public ResponseEntity<List<Prenotazione>> getPrenotazioniByUtente(@RequestHeader Map<String,String> headers){
//		String userName = jwtUtils.getUserNameFromJwtToken(headers.get("authorization").replace("Bearer ", ""));
//		Optional<Utente> u = us.getPrenotazioneByUsername(userName);
//		List<Prenotazione> listaPrenotazioni = u.get().getPrenotazioneUtente();
//		if(listaPrenotazioni.equals(null)) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}else {
//			return new ResponseEntity<>(listaPrenotazioni, HttpStatus.OK);
//		}
//	}
	
}
