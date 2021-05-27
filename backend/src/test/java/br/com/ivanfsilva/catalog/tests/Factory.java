package br.com.ivanfsilva.catalog.tests;

import java.time.Instant;

import br.com.ivanfsilva.catalog.dto.ProductDTO;
import br.com.ivanfsilva.catalog.entities.Category;
import br.com.ivanfsilva.catalog.entities.Product;

public class Factory {
	
	public static Product createProduct() {
		Product product = new Product(1L, "Phone", "Good Phone", 800.0, "https://img.com/img.png", Instant.parse("2021-05-21T23:00:00Z"));
		product.getCategories().add(createCategory());
		
		return product;
	}
	
	public static ProductDTO createProductDTO() {
		Product product = createProduct();
		
		return new ProductDTO(product, product.getCategories());
	}
	
	public static Category createCategory() {
		
		return new Category(2L, "Eletronics");
		
	}

}
