package iga.springBoot.Repository;

import iga.springBoot.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student,Long> {
    @RestResource(path="/byName")
    public List<Student> findByNameContains(@Param(value="mc")String mc);
}
