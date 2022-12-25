package com.univlittoral.lpdim.biblio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.univlittoral.lpdim.biblio.dto.LivreDTO;
import com.univlittoral.lpdim.biblio.dto.LivreRequestSaveDTO;
import com.univlittoral.lpdim.biblio.entity.LivreEntity;
import com.univlittoral.lpdim.biblio.mapper.LivreMapper;
import com.univlittoral.lpdim.biblio.service.LivreService;



@RestController //-> est utilisé pour marquer les classes en tant que contrôleur Spring.
@RequestMapping(value = "rest/bd/livres/") //=> l’URL d’accès à votre controller.
public class LivreController {
	
	@Autowired
	private LivreService service;
	
	
	@GetMapping(value="{id}")
	public LivreDTO findLivre(@PathVariable Long id) {
		return LivreMapper.map(service.findById(id));
	}
	
	@DeleteMapping(value="{id}")
	public void deleteLivre(@PathVariable Long id) {
		service.deleteById(id);
	}
	
	@PostMapping
    public void addLivre(@RequestBody LivreEntity livre){
        service.addLivre(livre);
    }
	
	@PutMapping(value="{id}")
    public void modifLivre(@RequestBody LivreRequestSaveDTO request, @PathVariable Long id){
		LivreEntity livre = service.findById(id);
        service.modifLivre(livre,request);
    }
	
	@GetMapping
    public List<LivreDTO> getLivreByGenre(@RequestParam("genre") String param){
	List<LivreEntity> livreEntity = service.findByParam(param);
	List<LivreDTO> livres = new ArrayList<LivreDTO>();
	livres = new ArrayList<>(LivreMapper.map(livreEntity));
	return livres;
    }
}
