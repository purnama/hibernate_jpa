package de.purnama.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.purnama.demo.model.Department;

/**
 * @author Arthur Purnama (arthur@purnama.de)
 */
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long>{

    Department findByUniqueName(String uniqueName);
}
