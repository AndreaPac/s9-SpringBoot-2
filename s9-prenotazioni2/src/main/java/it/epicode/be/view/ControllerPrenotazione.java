package it.epicode.be.view;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPrenotazione {

	
	@GetMapping("/prenotazione")
	public String getPrenotazione(String lingua) {
		return "regole";
	}
	
}
