package com.sda.traianszabi.online_library.repository;

import com.sda.traianszabi.online_library.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}

