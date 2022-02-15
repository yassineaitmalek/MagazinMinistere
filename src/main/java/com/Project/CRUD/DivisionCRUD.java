package com.Project.CRUD;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Project.Entities.Division;

public interface DivisionCRUD extends CrudRepository<Division, Long> {
	@Query("from Division d where d.nom=:nom ")
    public Division findByNom(String nom);

}
