package com.univlittoral.lpdim.biblio.entity;



import java.sql.Date;
import coml.univlittoral.lpdim.biblio.enums.GenreEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="livres") //=> le nom de la table de votre base de données associée à cet objet Entité.
public class LivreEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String editeur;
	private Date  dateParution;
	private String lieuParution;
	private Long nbPages;
	@Enumerated(EnumType.STRING)
	private GenreEnum genre;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_auteur", referencedColumnName="id")
	private AuteurEntity auteur;
	
	
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
	public GenreEnum getGenre() {
		return genre;
	}
	public void setGenre(GenreEnum genre) {
		this.genre = genre;
	}
	public AuteurEntity getAuteur() {
		return auteur;
	}
	public void setAuteur(AuteurEntity auteur) {
		this.auteur = auteur;
	}
	
	
	
	
}
