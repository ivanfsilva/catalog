package br.com.ivanfsilva.catalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ivanfsilva.catalog.dto.CategoryDTO;
import br.com.ivanfsilva.catalog.entities.Category;
import br.com.ivanfsilva.catalog.repositories.CategoryRepository;
import br.com.ivanfsilva.catalog.services.exceptions.EntityNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();
		
		return list.stream().map(c -> new CategoryDTO(c)).collect(Collectors.toList());
		
//		List<CategoryDTO> listDTO = new ArrayList<>();
//		for (Category category : list) {
//			listDTO.add(new CategoryDTO(category));
//		}
//		
//		return listDTO;
	}

	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow( () -> new EntityNotFoundException("Entidade não encontrada"));
		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CategoryDTO(entity);
	}
}
