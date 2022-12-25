package com.univlittoral.lpdim.biblio.mapper;

import java.util.ArrayList;
import java.util.List;

import com.univlittoral.lpdim.biblio.dto.AuteurDTO;
import com.univlittoral.lpdim.biblio.entity.AuteurEntity;

public class AuteurMapper {

public static AuteurDTO map(AuteurEntity entity) {
		
		final AuteurDTO auteur = new AuteurDTO();
		
		auteur.setId(entity.getId());
		auteur.setNom(entity.getNom());
		auteur.setPrenom(entity.getPrenom());
		auteur.setDateNaissance(entity.getDateNaissance());
		
		return auteur;
		
	}
	
	public static List<AuteurDTO> map(final List<AuteurEntity> entities){
		if(null == entities) {
			return null;
		}
		List<AuteurDTO> result = new ArrayList<AuteurDTO>();
		for(final AuteurEntity auteur : entities) {
			result.add(AuteurMapper.map(auteur));
		}
		
		return result;
	}
	
	public final static AuteurEntity map(final AuteurDTO source) {
    	final  AuteurEntity auteurEntity = new AuteurEntity();
    	if (null == source) {
            return auteurEntity;
        }
        
    	auteurEntity.setId(source.getId());
    	auteurEntity.setNom(source.getNom());
    	auteurEntity.setPrenom(source.getPrenom());
    	auteurEntity.setDateNaissance(source.getDateNaissance());
        return auteurEntity;
    }

}
