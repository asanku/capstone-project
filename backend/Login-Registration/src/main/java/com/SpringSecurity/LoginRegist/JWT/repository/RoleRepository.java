package com.SpringSecurity.LoginRegist.JWT.repository;

import com.SpringSecurity.LoginRegist.JWT.user.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(String roleName);

}
