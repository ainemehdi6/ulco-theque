	package com.univlittoral.lpdim.biblio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.univlittoral.lpdim.biblio.dto.AuteurDTO;
import com.univlittoral.lpdim.biblio.entity.AuteurEntity;
import com.univlittoral.lpdim.biblio.mapper.AuteurMapper;
import com.univlittoral.lpdim.biblio.service.AuteurService;

@RestController //-> est utilisé pour marquer les classes en tant que contrôleur Spring.
@RequestMapping(value = "rest/bd/auteurs/") //=> l’URL d’accès à votre controller.        
public class AuteurController {
	
	@Autowired
	private AuteurService service;
	
	@GetMapping
	public List<AuteurDTO> findAuteur(){
		return AuteurMapper.map(service.findAll());
	}
	
	@GetMapping(value= "{id}")
	public AuteurDTO getAuteurId(@PathVariable Long id) {
		final AuteurEntity entities = service.findOne(id);
		
		return AuteurMapper.map(entities);
	}
	





}
