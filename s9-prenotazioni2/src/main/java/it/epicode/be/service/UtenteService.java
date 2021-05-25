package it.epicode.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be.model.Utente;
import it.epicode.be.persistance.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	UtenteRepository ur;
	
	public void popolaUtenti() {

		Utente u1 = new Utente();
		u1.setMailUtente("lorenzo@gmail.com");
		u1.setNomeCompleto("Lorenzo Giannini");
		u1.setUserNomeUtente("LoreGian");
		ur.save(u1);

		Utente u2 = new Utente();
		u2.setMailUtente("michele@gmail.com");
		u2.setNomeCompleto("Michele Franchi");
		u2.setUserNomeUtente("Mike");
		ur.save(u2);

		Utente u3 = new Utente();
		u3.setMailUtente("francesco@gmail.com");
		u3.setNomeCompleto("Francesco Lorenzoni");
		u3.setUserNomeUtente("Frattattack");
		ur.save(u3);

	}
	public Utente getById(Long id) {
		return ur.getById(id);
	}
}
