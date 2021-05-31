package it.epicode.be.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.epicode.be.model.RegistrazioneUtente;
import it.epicode.be.model.RoleType;
import it.epicode.be.model.Ruolo;
import it.epicode.be.model.Utente;
import it.epicode.be.persistance.RuoloRepository;
import it.epicode.be.persistance.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	UtenteRepository ur;
	@Autowired
	RuoloRepository ruoloRepository;

	public Optional<Utente> getById(Long idUtente) {
		return ur.findById(idUtente);
	}

	public List<Utente> getUtenteAll() {
		return ur.findAll();
	}

	public Utente creaUtente(Utente utente) {
		return ur.save(utente);
	}

	public void deleteUtente(long idUtente) {
		ur.deleteById(idUtente);

	}

	public Utente updateUtente(long idUtente, Utente utente) {
		return ur.save(utente);
	}

	public Optional<Utente> getPrenotazioneByUsername(String userName) {

		return ur.findByUsername(userName);

	}

	@Autowired
	private PasswordEncoder encoder;

	public RegistrazioneUtente registraUtente(RegistrazioneUtente registrazioneUtente) {

		Utente utente = new Utente();
		
		utente.setNomeCompleto(registrazioneUtente.getNomeCompleto());
		utente.setMailUtente(registrazioneUtente.getMailUtente());
		utente.setUsername(registrazioneUtente.getUsername());
		String hashedPassword = encoder.encode(registrazioneUtente.getPlainPassword());
		utente.setPassword(hashedPassword);

		Set<Ruolo> setDiRuoli = new HashSet<Ruolo>();

		for (String s : registrazioneUtente.getNomiRuolo()) {
			RoleType tipo = RoleType.valueOf(s);
			List<Ruolo> listaRuolo = ruoloRepository.findByRoleType(tipo);
			Ruolo r = listaRuolo.get(0);
			setDiRuoli.add(r);
		}
		utente.setRoles(setDiRuoli);
		ur.save(utente);
		registrazioneUtente.setId(utente.getId());
		
		return registrazioneUtente;

	}
}
