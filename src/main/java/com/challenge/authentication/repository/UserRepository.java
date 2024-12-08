package com.challenge.authentication.repository;

import com.challenge.authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * UserRepository is a Spring Data JPA repository interface for managing User
 * entities. It provides methods for performing CRUD operations and custom
 * queries related to the User entity in a relational database.
 *
 * This repository inherits standard CRUD operations from JpaRepository and
 * defines a custom query method for retrieving users by their usernames.
 *
 * @see User
 * @see JpaRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

