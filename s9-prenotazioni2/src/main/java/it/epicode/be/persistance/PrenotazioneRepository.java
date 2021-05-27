package it.epicode.be.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import it.epicode.be.model.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

//	metodo secondario per creazione Prenotazione
//	Prenotazione saveAll(int idPostazione, long idUtente, int idData);

}
