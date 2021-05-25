package it.epicode.be.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.Data;

@Data
@Entity
public class Prenotazione {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private LocalDate dataPrenotazione;
	
	private LocalDate dataPrenotata;
	
	@ManyToOne
	private Utente utente;
	
	@ManyToOne
	private Postazione postazione;

}
