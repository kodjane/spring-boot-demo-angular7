package com.techAIK.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produit {

	@Id
	@GeneratedValue
	private Long reference;
	private String designation;
	private double prix;
	private int quantite;
	
	public Produit() {
		super();
	}

	public Produit(Long reference, String designation, double prix, int quantite) {
		this.reference = reference;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}

	public Long getReference() {
		return reference;
	}

	public void setReference(Long reference) {
		this.reference = reference;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Produit [reference=" + reference + ", designation=" + designation + ", prix=" + prix + ", quantite="
				+ quantite + "]";
	}
	
}
