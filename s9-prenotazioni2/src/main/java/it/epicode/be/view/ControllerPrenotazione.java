package it.epicode.be.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.service.PrenotazioneService;

@RestController
@RequestMapping("/api")
public class ControllerPrenotazione {

	@Autowired
	private PrenotazioneService prenotazioneService;
	
	
//	@GetMapping(value="/prenotaPostazione/{idUtente}/{idPostazione}/{dataPrenotazione}")
//	public String prenotaPostazione(@PathVariable long idUtente, @PathVariable long idPostazione, 
	//@PathVariable long dataPrenotazione ) {
		
	//prenotaPostazione(idUtente, idPostazione, dataPrenotazione);
		
		
	}
			
	


