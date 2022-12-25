package com.univlittoral.lpdim.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univlittoral.lpdim.biblio.entity.AuteurEntity;
import com.univlittoral.lpdim.biblio.repository.AuteurRepository;


@Service
public class AuteurService {
	

	@Autowired
	private AuteurRepository repo; 
	
	
	public List<AuteurEntity> findAll() {
		return repo.findAllAuteurs();
	}
	
	
	public AuteurEntity findOne(Long id) {
		return repo.findById(id).orElse(null);
	}
	
}
