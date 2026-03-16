package tsenako.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import tsenako.demo.models.Categorie;
import tsenako.demo.repository.CategorieRepository;

@Service
public class CategorieService {
    private CategorieRepository categorieRepository;

    @Autowired
    public CategorieService(CategorieRepository cat){
        this.categorieRepository = cat;
    }

    public List<Categorie> getAllCategories(){
        return this.categorieRepository.findAll();
    }

    public Categorie getCategorieById(Long id){
        return this.categorieRepository.findById(id).orElse(null);
    }

    public Categorie addCategorie(Categorie cat){
        return this.categorieRepository.save(cat);
    }

    public Categorie updateCategorie(Long id, Categorie cat) {
        Categorie eCat = this.categorieRepository.findById(id).orElse(null);
        if(eCat != null){
            eCat.setNom(cat.getNom());
            return this.categorieRepository.save(eCat);
        } else {
            throw new EntityNotFoundException("Produit non existant.");
        }
    }

    public void deleteCategorie(Long id){
        this.categorieRepository.deleteById(id);
    }
}
