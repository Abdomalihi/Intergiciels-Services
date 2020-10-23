package iga.springBoot.Repository;

import iga.springBoot.Model.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LaboratoryRepository extends JpaRepository<Laboratory,Long> { }
