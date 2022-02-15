package com.Project.CRUD;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Project.Entities.Article;

public interface ArticleCRUD extends CrudRepository<Article, Long> {
	@Query("from Article d where d.lib=:lib ")
    public Iterable<Article> findBylib(String lib);
	
	@Query("from Article d where d.qdisp <= qmin ")
    public Iterable<Article> findByundermin();
}
