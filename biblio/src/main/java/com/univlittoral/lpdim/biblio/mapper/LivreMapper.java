package com.univlittoral.lpdim.biblio.mapper;

import java.util.ArrayList;
import java.util.List;

import com.univlittoral.lpdim.biblio.dto.LivreDTO;
import com.univlittoral.lpdim.biblio.dto.LivreRequestSaveDTO;
import com.univlittoral.lpdim.biblio.entity.LivreEntity;

public class LivreMapper {
	
	public static LivreDTO map(final LivreEntity entity) {
		
		final LivreDTO livre = new LivreDTO();
		
		livre.setId(entity.getId());
		livre.setNom(entity.getNom());
		livre.setEditeur(entity.getEditeur());
		livre.setDateParution(entity.getDateParution());
		livre.setLieuParution(entity.getLieuParution());
		livre.setNbPages(entity.getNbPages());
		livre.setGenre(entity.getGenre());
		livre.setAuteur(AuteurMapper.map(entity.getAuteur()));
		
		return livre;
		
	}
	
	public final static List<LivreDTO> map(List<LivreEntity> entities){
		if(null == entities) {
			return null;
		}
		List<LivreDTO> result = new ArrayList<LivreDTO>();
		
		for(LivreEntity livre : entities) {
			result.add(LivreMapper.map(livre));
		}
		return result;
	}
	
	public static LivreEntity mapEntityToEntity(LivreEntity entity, LivreRequestSaveDTO request) {
		
		entity.setNom(request.getNom());
		entity.setEditeur(request.getEditeur());
		entity.setDateParution(request.getDateParution());
		entity.setLieuParution(request.getLieuParution());
		entity.setNbPages(request.getNbPages());
		entity.setGenre(request.getGenre());
		entity.setAuteur(AuteurMapper.map(request.getAuteur()));
		
		return entity;
	}
	

}
