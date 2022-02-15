package com.Project.CRUD;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Project.Entities.Employee;

public interface EmployeeCRUD extends CrudRepository<Employee, Long> {
	@Query("from Employee d where d.cin=:cin ")
    public Employee findByCin(String cin);
	
	@Query("from Employee d where d.email=:email ")
    public Employee findByEmail(String email);
	

	
}
