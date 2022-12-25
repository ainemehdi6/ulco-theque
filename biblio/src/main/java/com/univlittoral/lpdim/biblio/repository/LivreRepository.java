package com.univlittoral.lpdim.biblio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.univlittoral.lpdim.biblio.entity.LivreEntity;


@Repository
public interface LivreRepository extends JpaRepository<LivreEntity, Long>{
	
	
	@Query(value="SELECT * FROM livres  WHERE genre = :param order by nom ASC", nativeQuery=true)
	public List<LivreEntity> findbyGenre(@Param("param") String param);
	
	@Query(value="SELECT * FROM livres order by nom ASC", nativeQuery=true)
	public List<LivreEntity> findAllLivres();

}
