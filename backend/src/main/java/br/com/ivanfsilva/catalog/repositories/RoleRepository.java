package br.com.ivanfsilva.catalog.repositories;

import br.com.ivanfsilva.catalog.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
