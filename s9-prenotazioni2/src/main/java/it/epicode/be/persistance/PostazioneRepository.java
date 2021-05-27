package it.epicode.be.persistance;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be.model.Edificio;
import it.epicode.be.model.Postazione;
import it.epicode.be.model.TipoPostazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

	List<Postazione> findByTipoPostazione(TipoPostazione tipo);

	Postazione save(Edificio edificio);

	

	
//	public Optional<Postazione> findById(Long id);
	
}
