package com.SpringSecurity.LoginRegist.JWT.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query("""
    SELECT t FROM Token t JOIN UserEntity u ON u.id = t.userEntity.id 
    WHERE u.id = :userid and (t.expired = false or t.revoked = false)
""")
    List<Token> findAllValidTokenByUserEntity(Long userid);

    Optional<Token> findByToken(String token);
}
