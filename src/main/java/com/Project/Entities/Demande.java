package com.Project.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Demande implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ;
	@OneToOne
	private Article a;
	@OneToOne
	private Famille f;
	@OneToOne
	private Magazin m;
	@OneToOne
	private Employee e;
	
	private Date d;
	
	private String etat;
	
	private int qte;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Article getA() {
		return a;
	}

	public void setA(Article a) {
		this.a = a;
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

	public Employee getE() {
		return e;
	}

	public void setE(Employee e) {
		this.e = e;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}
	
	
	

}
