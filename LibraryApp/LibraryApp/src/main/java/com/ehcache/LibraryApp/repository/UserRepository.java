package com.ehcache.LibraryApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehcache.LibraryApp.model.UserLoginEntity;

public interface UserRepository extends JpaRepository<UserLoginEntity,Long> {

    Optional<UserLoginEntity> findByuserName(String username);
    
}
