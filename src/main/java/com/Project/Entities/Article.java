package com.Project.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Article implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String lib , raison ;
	
	private int qmax,qmin,qdisp;
	
	@OneToOne
	private Famille f ;
	
	@OneToOne
	private Magazin m ;
	

	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLib() {
		return lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}

	public String getRaison() {
		return raison;
	}

	public void setRaison(String raison) {
		this.raison = raison;
	}

	public int getQmax() {
		return qmax;
	}

	public void setQmax(int qmax) {
		this.qmax = qmax;
	}

	public int getQmin() {
		return qmin;
	}

	public void setQmin(int qmin) {
		this.qmin = qmin;
	}

	public int getQdisp() {
		return qdisp;
	}

	public void setQdisp(int qdisp) {
		this.qdisp = qdisp;
	}

	public Famille getF() {
		return f;
	}

	public void setF(Famille f) {
		this.f = f;
	}

	public Magazin getM() {
		return m;
	}

	public void setM(Magazin m) {
		this.m = m;
	}

	
	
	
	
	
	
	

}
