package com.techAIK.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techAIK.model.Produit;
import com.techAIK.repository.ProduitJpaRespository;

@RestController
@CrossOrigin("*")
@Repository
@RepositoryRestResource
public class ProduitController {

    @Autowired
    private ProduitJpaRespository produitJpaRespository;

    @GetMapping(value = "/listProducts")
    public List<Produit> findAll() {
        return produitJpaRespository.findAll();
    }
    
    @GetMapping(value = "/pagination") // This method allows me to show only 5 products by page(Very usefull!)
    public Page<Produit> findProduitParPage(int page) {
        return produitJpaRespository.findAll(new PageRequest(page, 1));
    }
    
//    @GetMapping(value = "/ProduitParMC") // This method allows to get products by specifying a key word
//    public Page<Produit> findProduitParMC(String mc, int page) {
//        return produitJpaRespository.produitParMC("%" +mc+"%", new PageRequest(page, 5));
//    }

//    @GetMapping(value = "/listProducts/{name}")
//    public List<Produit> findByDesignation(@Param("x") String des){
//        return produitJpaRespository.findByDesignation(des);
//    }
    
    @GetMapping(value = "/listProducts/{id}")
    public Produit findById(Long id){
        return produitJpaRespository.findOne(id);
    }

    @PostMapping(value = "/saveProduct")
    public void save(@RequestBody Produit produit) {
        produitJpaRespository.save(produit);
    }
    
    @PutMapping(value = "/updateProduct")
    public void update(@RequestBody Produit produit) {
        produitJpaRespository.save(produit);
    }
    
    @DeleteMapping(value = "/deleteProduct/{id}")
    public void delete(@PathVariable long id) {
        produitJpaRespository.delete(id);
    }
    
}
