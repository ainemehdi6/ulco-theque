package com.univlittoral.lpdim.biblio.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univlittoral.lpdim.biblio.dto.GenresDTO;
import com.univlittoral.lpdim.biblio.dto.HomeDTO;
import com.univlittoral.lpdim.biblio.dto.IndicateursDTO;
import com.univlittoral.lpdim.biblio.entity.AuteurEntity;
import com.univlittoral.lpdim.biblio.entity.LivreEntity;
import com.univlittoral.lpdim.biblio.mapper.LivreMapper;
import com.univlittoral.lpdim.biblio.service.LivreService;

import coml.univlittoral.lpdim.biblio.enums.GenreEnum;

import com.univlittoral.lpdim.biblio.service.AuteurService;

@RestController //-> est utilisé pour marquer les classes en tant que contrôleur Spring.
@RequestMapping(value = "rest/bd/home/") //=> l’URL d’accès à votre controller.
public class HomeController {
	
	@Autowired
	private LivreService LivreService;
	@Autowired
	private AuteurService AuteurService;
	
	@GetMapping
	public HomeDTO getHome() {
		final List<LivreEntity> livresEntities = LivreService.findAll() ;
		final ArrayList<String> genres = new ArrayList<String>();
		final Map<String, Integer> tabListeGenre = new HashMap();
		final HomeDTO dto = new HomeDTO();
        final IndicateursDTO indicateur = new IndicateursDTO();
        indicateur.setNbLivres(livresEntities.size());
        indicateur.setNbAuteurs(AuteurService.findAll().size());
        
        
		for (int i = 0; i < livresEntities.size(); i++) {
	            LivreEntity livre = livresEntities.get(i);
	            String genre =  livre.getGenre().toString();
	          boolean contains = genres.contains(genre);
	            if(!contains) {
	            	genres.add(genre.toString());         
	            }
	        }
		
		
		for (int i = 0; i < livresEntities.size(); i++) {
            LivreEntity livre = livresEntities.get(i);
            String genre =  livre.getGenre().toString();
          boolean contains = tabListeGenre.containsKey(genre);
            if(!contains) {
                tabListeGenre.put(genre, 1);
            }
            else{
            	tabListeGenre.put(genre, tabListeGenre.get(genre) + 1);
            }

        }
			
		
        dto.setLivres(new ArrayList<>(LivreMapper.map(livresEntities)));
        dto.setIndicateur(indicateur);
        indicateur.setNbGenres(genres.size());
        
        final GenresDTO listeGenre = new GenresDTO();
        listeGenre.setListeGenre(tabListeGenre);
        dto.setGenres(tabListeGenre);
        
        return dto;
		
	}

}
