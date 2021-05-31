package it.epicode.be;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import it.epicode.be.model.Utente;
import it.epicode.be.persistance.UtenteRepository;
import it.epicode.be.service.UtenteService;

public class Runner2 implements CommandLineRunner{

	@Autowired
	UtenteService utenteService;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	UtenteRepository utenteRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		codificaPassword();
//		codificaPassword(2l);
//		
//		
		
	}
	public void codificaPassword(Long id) {
		
		Optional<Utente> u = utenteService.getById(id);
		Utente u2 = u.get();
		String password = u2.getPassword();
		String nuovaPass = encoder.encode(password);
		u2.setPassword(nuovaPass);
		utenteRepo.save(u2);
		
	}
}
