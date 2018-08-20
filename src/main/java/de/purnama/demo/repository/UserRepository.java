package de.purnama.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.purnama.demo.model.UserData;

/**
 * @author Arthur Purnama (arthur@purnama.de)
 */
@Repository
public interface UserRepository extends CrudRepository<UserData, Long> {
    UserData findByUsername(String username);
}