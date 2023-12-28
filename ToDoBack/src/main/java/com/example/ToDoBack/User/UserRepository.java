package com.example.ToDoBack.User;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{ 'userName' : ?0 }")
    Optional<User> findByUserName(String username);
}
