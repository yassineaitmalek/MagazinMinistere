package com.Project.CRUD;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.Project.Entities.Demande;

public interface DemandeCRUD  extends CrudRepository<Demande, Long> {
	@Query("from Demande d where d.etat=:etat ")
    public Iterable<Demande> findByetat(String etat);
	
}
