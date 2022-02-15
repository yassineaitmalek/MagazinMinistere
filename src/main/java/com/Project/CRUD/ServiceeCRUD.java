package com.Project.CRUD;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Project.Entities.Servicee;

public interface ServiceeCRUD extends CrudRepository<Servicee, Long> {
	@Query("from Servicee d where d.nom=:nom ")
    public Servicee findByNom(String nom);
}
