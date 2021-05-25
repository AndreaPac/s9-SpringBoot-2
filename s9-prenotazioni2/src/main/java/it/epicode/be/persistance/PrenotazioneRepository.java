package it.epicode.be.persistance;






import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import it.epicode.be.model.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long>{

//	@Query("FROM Prenotazione WHere utente= :u AND postazione =:p And Dataprenotazione =:dp");
//	public List<Prenotazione> findByUtentePostazioneData(Utente u, Postazione p, LocalDate ld);
}
