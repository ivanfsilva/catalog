package br.com.ivanfsilva.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ivanfsilva.catalog.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
