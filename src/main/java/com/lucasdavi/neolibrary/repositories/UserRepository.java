package com.lucasdavi.neolibrary.repositories;

import com.lucasdavi.neolibrary.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{
}
