package it.epicode.be.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Utente {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String userNomeUtente;
	private String nomeCompleto;
	private String mailUtente;
	
	@OneToMany(mappedBy="utente")
	private List<Prenotazione> prenotazioneUtente;
		
}
