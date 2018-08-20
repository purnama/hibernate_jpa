package de.purnama.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.purnama.demo.model.CivilService;
import de.purnama.demo.model.Department;
import de.purnama.demo.model.Review;
import de.purnama.demo.model.UserData;

/**
 * @author Arthur Purnama (arthur@purnama.de)
 */
@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{

    List<Review> findByCivilService(CivilService civilService );

    List<Review> findByDepartment(Department department);

    List<Review> findByUser(UserData user);
}
