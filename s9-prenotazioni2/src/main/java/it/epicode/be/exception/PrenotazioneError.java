package it.epicode.be.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
@Data
public class PrenotazioneError {

	private String messaggio;
	private String developerReference = "Epicode";
	private HttpStatus stato;

}
