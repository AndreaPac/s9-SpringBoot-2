package it.epicode.be.persistance;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be.model.Utente;
@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long>{

	List<Utente> findByuserNomeUtenteIgnoreCase(String nome);

	
		
}
