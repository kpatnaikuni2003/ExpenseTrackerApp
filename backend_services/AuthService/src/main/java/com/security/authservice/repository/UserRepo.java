package com.security.authservice.repository;

import com.security.authservice.entities.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserInfo,String> {

    public UserInfo findByUsername(String username);
}
