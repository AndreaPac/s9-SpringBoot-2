package it.epicode.be.persistance;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be.model.Citta;

@Repository
public interface CittaRepository extends JpaRepository<Citta, Long>{

	List<Citta> findByNomeIgnoreCase(String nome);

	//public List<Citta> FindBynomeIgnoreCase(String nome);

	
}
