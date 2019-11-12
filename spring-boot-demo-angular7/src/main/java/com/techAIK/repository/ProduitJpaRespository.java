package com.techAIK.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.techAIK.model.Produit;

@CrossOrigin("*")
@Component
@RepositoryRestResource
@Repository
public interface ProduitJpaRespository extends JpaRepository<Produit, Long>{
	
	@Query("select p from Produit p where p.designation like :x")
	Page<Produit> produitParMC(@Param("x") String mc, Pageable p);
	
//	@RestResource(path = "/byDesignation")
//	List<Produit> findByDesignationContains(@Param ("x") String des);
	
	//	Page<Produit> findByDesignation(String des, Pageable p);
	
	@RestResource(path = "/byDesignationPage")
	Page<Produit> findByDesignationContains(@Param("mc") String des, Pageable p);

//	List<Produit> findByReference(Long ref);
}
