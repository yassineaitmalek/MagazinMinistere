package com.Project.CRUD;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Project.Entities.Fournisseur;

public interface FournisseurCRUD extends CrudRepository<Fournisseur, Long> {
	@Query("from Fournisseur d where d.nom=:nom ")
    public Fournisseur findByNom(String nom);

}
