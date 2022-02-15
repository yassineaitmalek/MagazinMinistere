package com.Project.CRUD;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.Project.Entities.Direction;

public interface DirectionCRUD extends CrudRepository<Direction, Long> {
	@Query("from Direction d where d.nom=:nom ")
    public Direction findByNom(String nom);
	
	

}
