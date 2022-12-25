package com.univlittoral.lpdim.biblio.dto;

import java.sql.Date;

import coml.univlittoral.lpdim.biblio.enums.GenreEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class LivreDTO {

	Long id;
	String nom;
	String editeur;
	Date dateParution;
	String lieuParution;
	Long nbPages;
	AuteurDTO auteur;
	@Enumerated(EnumType.STRING)
	private GenreEnum genre;
	

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
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public Date getDateParution() {
		return dateParution;
	}
	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}
	public String getLieuParution() {
		return lieuParution;
	}
	public void setLieuParution(String lieuParution) {
		this.lieuParution = lieuParution;
	}
	public Long getNbPages() {
		return nbPages;
	}
	public void setNbPages(Long nbPages) {
		this.nbPages = nbPages;
	}
	public AuteurDTO getAuteur() {
		return auteur;
	}
	public void setAuteur(AuteurDTO auteur) {
		this.auteur = auteur;
	}
	public GenreEnum getGenre() {
		return genre;
	}
	public void setGenre(GenreEnum genre) {
		this.genre = genre;
	}
	
	
}
