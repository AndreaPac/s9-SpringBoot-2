package it.epicode.be.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Edificio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	private String nomeEdificio;
	private String indirizzoEdificio;

	@OneToMany(mappedBy = "edificio")
	private List<Postazione> postazione;

	@ManyToOne
	private Citta citta;
	
}
