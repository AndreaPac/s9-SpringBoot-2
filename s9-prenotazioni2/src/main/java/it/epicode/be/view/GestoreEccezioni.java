package it.epicode.be.view;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import it.epicode.be.exception.LinguaNonSupportataException;
import it.epicode.be.exception.PrenotazioneError;

@ControllerAdvice
public class GestoreEccezioni extends ResponseEntityExceptionHandler {

	@ExceptionHandler(LinguaNonSupportataException.class)
	public ResponseEntity<PrenotazioneError> gestioneEccezioneLingua(LinguaNonSupportataException e) {

		PrenotazioneError pe = new PrenotazioneError();

		pe.setStato(HttpStatus.NOT_FOUND);
		pe.setMessaggio(pe.getDeveloperReference() + " " + PAGE_NOT_FOUND_LOG_CATEGORY);

		return new ResponseEntity<PrenotazioneError>(pe, pe.getStato());

	}
}