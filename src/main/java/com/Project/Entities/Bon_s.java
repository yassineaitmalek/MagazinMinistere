package com.Project.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bon_s  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	@OneToOne
	private Employee e;
	@OneToOne
	private Article a;
	
	@OneToOne
	private Magazin m;
	
	private Date d;
	
	private int qte;
	
	private boolean delivred;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getE() {
		return e;
	}

	public void setE(Employee e) {
		this.e = e;
	}

	public Article getA() {
		return a;
	}

	public void setA(Article a) {
		this.a = a;
	}

	public Magazin getM() {
		return m;
	}

	public void setM(Magazin m) {
		this.m = m;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public boolean isDelivred() {
		return delivred;
	}

	public void setDelivred(boolean delivred) {
		this.delivred = delivred;
	}
	
	

}
