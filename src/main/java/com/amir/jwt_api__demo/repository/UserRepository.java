package com.amir.jwt_api__demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amir.jwt_api__demo.model.UserInfo;
import java.util.Optional;

@Repository

public interface UserRepository extends CrudRepository <UserInfo , Long> {

    Optional<UserInfo> findByUsername(String username);

    Optional<UserInfo> findFirstById(Long id );

}
