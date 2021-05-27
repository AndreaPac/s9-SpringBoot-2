package it.epicode.be.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class Postazione {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String descrizionePostazione;
	private TipoPostazione tipoPostazione;
	private int numeroMassimoOccupanti;
	
	@ManyToOne
	private Edificio edificio;

	@JsonIgnore
	@OneToMany(mappedBy = "postazione")
	private List<Prenotazione> listaPrenotazioni;
}
