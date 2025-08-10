package com.security.authservice.repository;

import com.security.authservice.entities.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepo extends CrudRepository<RefreshToken, Integer> {


    Optional<RefreshToken> findByRefreshToken(String token);
}
