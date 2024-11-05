package com.SpringSecurity.LoginRegist.JWT.repository;

import com.SpringSecurity.LoginRegist.JWT.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);

}
