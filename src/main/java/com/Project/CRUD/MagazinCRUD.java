package com.Project.CRUD;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Project.Entities.Magazin;

public interface MagazinCRUD extends CrudRepository<Magazin, Long> {
	@Query("from Magazin d where d.nom=:nom ")
    public Magazin findByNom(String nom);
}
