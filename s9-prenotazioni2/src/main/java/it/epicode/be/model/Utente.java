package it.epicode.be.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import lombok.Data;

@Data
@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String nomeCompleto;
	private String mailUtente;
	private Boolean active = true;
	private String password;

	@OneToMany(mappedBy = "utente")
	private List<Prenotazione> prenotazioneUtente;
	
	@ManyToMany
	@JoinTable(name = "utente_roles",joinColumns = @JoinColumn(name = "utente_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Ruolo> roles = new HashSet<>();	
}
