package it.epicode.be.view;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.exception.LinguaNonSupportataException;

@RestController
@RequestMapping("/try")
public class IstruzioniController {

	@Value("${s9-prenotazioni2.istruzioniItaliano}")
	private String italiano;

	@Value("${s9-prenotazioni2.istruzioniInglese}")
	private String inglese;

	@GetMapping("istruzioni/{lingua}")
	public String getIstruzioni(@PathVariable String lingua) {
		if (lingua.equals("italiano")) {
			return italiano;
		} else if (lingua.equals("inglese")) {
			return inglese;
		} else {
			throw new LinguaNonSupportataException("Language not "
											   + "found" + lingua);
		}

	}

}
