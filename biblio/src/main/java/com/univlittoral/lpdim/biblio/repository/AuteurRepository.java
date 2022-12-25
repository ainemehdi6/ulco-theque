package com.univlittoral.lpdim.biblio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.univlittoral.lpdim.biblio.entity.AuteurEntity;

@Repository
public interface AuteurRepository extends JpaRepository<AuteurEntity, Long>{

	@Query(value="SELECT * FROM auteurs order by prenom ASC", nativeQuery=true)
	public List<AuteurEntity> findAllAuteurs();
}
