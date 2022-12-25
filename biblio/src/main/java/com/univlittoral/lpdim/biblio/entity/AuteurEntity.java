package com.univlittoral.lpdim.biblio.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="auteurs") //=> le nom de la table de votre base de données associée à cet objet Entité.
public class AuteurEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String nom;
	String prenom;
	Date dateNaissance;
	@OneToMany(mappedBy = "auteur",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<LivreEntity> livres;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public List<LivreEntity> getLivres() {
		return livres;
	}
	public void setLivres(List<LivreEntity> livres) {
		this.livres = livres;
	}
	
	
	
}
