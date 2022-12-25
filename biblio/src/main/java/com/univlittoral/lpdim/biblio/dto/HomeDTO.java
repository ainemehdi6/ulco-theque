package com.univlittoral.lpdim.biblio.dto;

import java.util.List;
import java.util.Map;


public class HomeDTO {

	private List <LivreDTO> livres;
	private IndicateursDTO indicateur;
	private Map<String,	Integer> genres;
	
	public List<LivreDTO> getLivres() {
		return livres;
	}
	public void setLivres(List<LivreDTO> livres) {
		this.livres = livres;
	}
	public IndicateursDTO getIndicateurs() {
		return indicateur;
	}
	public void setIndicateur(IndicateursDTO indicateurs) {
		this.indicateur = indicateurs;
	}
	public Map<String,Integer> getGenres() {
		return genres;
	}
	public void setGenres(Map<String,Integer> genres) {
		this.genres = genres;
	}
	
	
}
