package tsenako.demo.repository;

import tsenako.demo.models.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitsRepository extends JpaRepository<Produits, Long> {

}