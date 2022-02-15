package com.Project.CRUD;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Project.Entities.Magasinier;

public interface MagasinierCRUD extends CrudRepository<Magasinier, Long> {
	@Query("from Magasinier d where d.cin=:cin ")
    public Magasinier findByCin(String cin);
	
	@Query("from Magasinier d where d.email=:email ")
    public Magasinier findByemail(String email);
}
