package tsenako.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import tsenako.demo.models.Produits;
import tsenako.demo.repository.ProduitsRepository;

@Service
public class ProduitsService {
    
    private final ProduitsRepository repository;

    @Autowired
    public ProduitsService(ProduitsRepository repository) {
        this.repository = repository;
    }

    public List<Produits> getAllProduits() {
        return repository.findAll();
    }

    public Optional<Produits> getProduitById(Long id) {
        return repository.findById(id);
    }

    public Produits addProduit(Produits produit) {
        return repository.save(produit);
    }

    public Produits updateProduit(Produits produit) {
        if(produit.getId() != null && repository.existsById(produit.getId())) {
            return repository.save(produit);
        } else {
            throw new EntityNotFoundException("Produit non existant.");
        }
    }

    public void deleteProduit(Long id) {
        repository.deleteById(id);
    }
}