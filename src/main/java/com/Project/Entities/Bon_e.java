package com.Project.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bon_e implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Article a;
	
	@OneToOne
	private Fournisseur f;
	
	@OneToOne
	private Magazin m;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Famille getFm() {
		return fm;
	}


	public void setFm(Famille fm) {
		this.fm = fm;
	}


	@OneToOne
	private Famille fm;
	
	private int qte ;
	
	private Date date;
	
	
	private float prix ;


	public Article getA() {
		return a;
	}


	public void setA(Article a) {
		this.a = a;
	}


	public Fournisseur getF() {
		return f;
	}


	public void setF(Fournisseur f) {
		this.f = f;
	}


	public Magazin getM() {
		return m;
	}


	public void setM(Magazin m) {
		this.m = m;
	}


	public int getQte() {
		return qte;
	}


	public void setQte(int qte) {
		this.qte = qte;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	
	
	
	
	

}
