package it.epicode.be.persistance;




import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import it.epicode.be.model.Utente;
@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long>{

	//List<Utente> findByuserNomeUtenteIgnoreCase(String nome);

	Optional<Utente> findByUsername(String username);
//	Page<Utente> findByActive(Boolean active, Pageable pageable);
//	Page<Utente> findByFirstNameContaining(String firstName, Pageable pageable);
//	Page<Utente> findAll(Pageable pageable);

	//Optional<Utente> getIdFromJwtToken(String userName);

}
