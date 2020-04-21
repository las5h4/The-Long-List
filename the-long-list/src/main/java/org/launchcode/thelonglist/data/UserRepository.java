package org.launchcode.thelonglist.data;

import org.launchcode.thelonglist.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
