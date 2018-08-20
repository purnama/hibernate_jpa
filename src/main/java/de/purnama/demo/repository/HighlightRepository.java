package de.purnama.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.purnama.demo.model.Highlight;

/**
 * @author Arthur Purnama (arthur@purnama.de)
 */
@Repository
public interface HighlightRepository extends CrudRepository<Highlight, Long>{

}
