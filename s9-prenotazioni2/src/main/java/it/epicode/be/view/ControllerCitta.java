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
import it.epicode.be.service.CittaService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
public class ControllerCitta {

	@Autowired
	private CittaService cittaService;

	@GetMapping("/cittaFormatExample")
	public Citta cittaFormat() {
		Citta c = new Citta();
		c.setId(1l);
		c.setNome("Roma");
		return c;
	}

	@GetMapping("/citta/allcitta")
	public ResponseEntity<List<Citta>> citta() {
		List<Citta> listaCitta = cittaService.getCittaAll();
		ResponseEntity<List<Citta>> risposta = new ResponseEntity<>(listaCitta, HttpStatus.OK);

		return risposta;

	}

	@GetMapping("/citta/{idCitta}") // riga 39 e 40 stesso identico nome "idCitta"
	public ResponseEntity<Citta> getCittaById(@PathVariable(required = true) long idCitta) {
		Optional<Citta> cittaOpt = cittaService.getById(idCitta);
		if (cittaOpt.isPresent()) {
			return new ResponseEntity<>(cittaOpt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/citta")
	public ResponseEntity<Citta> creaCitta(@RequestBody Citta citta) {
		try {
			Citta cittaSalvata = cittaService.creaCitta(citta);
			return new ResponseEntity<Citta>(cittaSalvata, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new WebServerException("City not saved", e);
		}
	}

	@DeleteMapping("/citta/{idCitta}")
	public ResponseEntity<Citta> eliminaCitta(@PathVariable(required = true) long idCitta) {
		cittaService.deleteCitta(idCitta);
		return new ResponseEntity<Citta>(HttpStatus.OK);
	}
	// da finire

	@PutMapping("/citta/{idCitta}")
	public ResponseEntity<Citta> updateCitta(@PathVariable("idCitta") long idCitta, @RequestBody Citta citta) {
		try {
			Citta result = cittaService.updateCitta(idCitta, citta);

			if (citta != null) {
				return new ResponseEntity<>(citta, HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			throw new WebServerException("User not updated", e);
		}

	}
}