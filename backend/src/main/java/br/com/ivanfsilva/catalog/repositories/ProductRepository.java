package br.com.ivanfsilva.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ivanfsilva.catalog.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
