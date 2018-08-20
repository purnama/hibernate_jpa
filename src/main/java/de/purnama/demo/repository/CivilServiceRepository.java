package de.purnama.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.purnama.demo.model.CivilService;

/**
 * @author Arthur Purnama (arthur@purnama.de)
 */
@Repository
public interface CivilServiceRepository extends CrudRepository<CivilService, Long>{

    CivilService findByUniqueName(String uniqueName);
}
