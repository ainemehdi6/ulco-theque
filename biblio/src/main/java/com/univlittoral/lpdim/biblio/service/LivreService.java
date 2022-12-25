package com.univlittoral.lpdim.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univlittoral.lpdim.biblio.dto.LivreRequestSaveDTO;
import com.univlittoral.lpdim.biblio.entity.LivreEntity;
import com.univlittoral.lpdim.biblio.mapper.LivreMapper;
import com.univlittoral.lpdim.biblio.repository.LivreRepository;

@Service
public class LivreService {
	
	@Autowired
	private LivreRepository repo; 
	
	public List<LivreEntity> findAll(){
		return repo.findAll();
	}
	
	public LivreEntity findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	public void addLivre(LivreEntity livre) {
		
		repo.save(livre);
	}
	
	public void modifLivre(LivreEntity livre,LivreRequestSaveDTO request) {
		repo.save(LivreMapper.mapEntityToEntity(livre,request));
	}
	
	public List<LivreEntity> findByParam(String param) {
		return repo.findbyGenre(param);
	}

}
