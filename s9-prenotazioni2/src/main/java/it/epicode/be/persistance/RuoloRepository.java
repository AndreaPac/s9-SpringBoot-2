package it.epicode.be.persistance;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be.model.RoleType;
import it.epicode.be.model.Ruolo;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo,Long>{
	
	public List<Ruolo> findByRoleType(RoleType tipo);

	
	
}
