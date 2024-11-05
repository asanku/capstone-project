package com.SpringSecurity.LoginRegist.JWT.token;


import com.SpringSecurity.LoginRegist.JWT.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private String token;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType = TokenType.BEARER;

    public boolean expired;

    public boolean revoked;

    @ManyToOne
    @JoinColumn(name = "userEntity")
    public UserEntity userEntity;

}
