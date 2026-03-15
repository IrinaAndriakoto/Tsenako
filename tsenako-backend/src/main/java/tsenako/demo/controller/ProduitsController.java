package tsenako.demo.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tsenako.demo.models.Produits;
import tsenako.demo.repository.ProduitsRepository;

@RestController
@RequestMapping("/api/produits")
public class ProduitsController {
    @Autowired
    private ProduitsRepository produitsRepository;

    @GetMapping
    public List<Produits> getAllProduits() {
        return produitsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produits getProduitById(@PathVariable Long id) {
        return produitsRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Produits createProduit(@RequestBody Produits produit) {
        return produitsRepository.save(produit);
    }

    @PutMapping("/{id}")
    public Produits updateProduit(@PathVariable Long id, @RequestBody Produits produit) {
        return produitsRepository.findById(id)
                .map(existingProduit -> {
                    existingProduit.setNom(produit.getNom());
                    existingProduit.setPrix(produit.getPrix());
                    return produitsRepository.save(existingProduit);
                })
                .orElse(null);
    }

    @PatchMapping("/{id}")
    public Produits patchProduit(@PathVariable Long id, @RequestBody Produits p ){
        return produitsRepository.findById(id)
                .map(existingProduit -> {
                    if (p.getNom() != null) existingProduit.setNom(p.getNom());
                    if (p.getPrix() != null) existingProduit.setPrix(p.getPrix());
                    return produitsRepository.save(existingProduit);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitsRepository.deleteById(id);
    }
}