package com.example.gadgetbeast.data;

import com.example.gadgetbeast.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
