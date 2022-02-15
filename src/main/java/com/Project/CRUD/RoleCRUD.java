package com.Project.CRUD;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Project.Entities.Role;

public interface RoleCRUD extends CrudRepository<Role, Long> {
	@Query("from Role d where d.nom=:r ")
    public Role findByR(String r);
	
}
