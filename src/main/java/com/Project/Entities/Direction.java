package com.Project.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Direction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ;
	
	private String nom;
	
	@OneToOne
	private Employee directeur;

	
	@OneToOne
	private Magazin m;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Employee getDirecteur() {
		return directeur;
	}

	public void setDirecteur(Employee directeur) {
		this.directeur = directeur;
	}

	public Magazin getM() {
		return m;
	}

	public void setM(Magazin m) {
		this.m = m;
	}
	

}
