package it.epicode.be.view;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.model.Edificio;
import it.epicode.be.model.Postazione;
import it.epicode.be.model.TipoPostazione;
import it.epicode.be.model.Utente;
import it.epicode.be.service.UtenteService;

@RestController
@RequestMapping("/api")
public class ControllerUtente {

	@Autowired
	private UtenteService utenteService;

	@GetMapping("/UtenteFormatExample")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public Utente utenteFormat() {
		Utente u = new Utente();
		u.setId(1l);
		u.setUsername("Marco");
		u.setNomeCompleto("MarcoAurelio");
		u.setMailUtente("marcoa@gmail.com");
		return u;
	}

	@GetMapping("/utente/allUtente")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<List<Utente>> getAllUtente() {
		List<Utente> listaUtenti = utenteService.getUtenteAll();
		ResponseEntity<List<Utente>> risposta = new ResponseEntity<>(listaUtenti, HttpStatus.OK);

		return risposta;

	}

	@GetMapping("/utente/{idutente}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Utente> getUtenteById(@PathVariable(required = true) long idUtente) {
		Optional<Utente> utenteOpt = utenteService.getById(idUtente);
		if (utenteOpt.isPresent()) {
			return new ResponseEntity<>(utenteOpt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/utente")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Utente> creaUtente(@RequestBody Utente utente) {
		try {
			Utente utenteSalvato = utenteService.creaUtente(utente);
			return new ResponseEntity<Utente>(utenteSalvato, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new WebServerException("Utente not saved", e);
		}
	}

	@DeleteMapping("/utente/{idUtente}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Utente> eliminaUtente(@PathVariable(required = true) long idUtente) {
		utenteService.deleteUtente(idUtente);
		return new ResponseEntity<Utente>(HttpStatus.OK);
	}

	@PutMapping("/utente/{idutente}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Utente> updateUtente(@PathVariable("idUtente") long idUtente, @RequestBody Utente utente) {
		try {
			Utente result = utenteService.updateUtente(idUtente, utente);

			if (utente != null) {
				return new ResponseEntity<>(result, HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			throw new WebServerException("Postazione not updated", e);
		}

	}

	
}
