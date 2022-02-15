package com.Project.CRUD;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Project.Entities.Famille;

public interface FamilleCRUD extends CrudRepository<Famille, Long> {
	@Query("from Famille d where d.nom=:nom ")
    public Famille findByNom(String nom);
	

}
