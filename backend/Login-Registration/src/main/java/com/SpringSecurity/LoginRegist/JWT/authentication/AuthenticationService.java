package com.SpringSecurity.LoginRegist.JWT.authentication;

import com.SpringSecurity.LoginRegist.JWT.dto.LoginDTO;
import com.SpringSecurity.LoginRegist.JWT.dto.RegisterDTO;
import com.SpringSecurity.LoginRegist.JWT.user.RoleEntity;
import com.SpringSecurity.LoginRegist.JWT.user.UserEntity;
import com.SpringSecurity.LoginRegist.JWT.repository.RoleRepository;
import com.SpringSecurity.LoginRegist.JWT.repository.UserRepository;
import com.SpringSecurity.LoginRegist.JWT.security.JWTService;
import com.SpringSecurity.LoginRegist.JWT.token.Token;
import com.SpringSecurity.LoginRegist.JWT.token.TokenRepository;
import com.SpringSecurity.LoginRegist.JWT.token.TokenType;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final TokenRepository tokenRepository;

    private final JWTService jwtService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(LoginDTO loginDTO) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
        );

        var userEntity = userRepository.findByEmail(loginDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        var jwtToken = jwtService.generateToken(userEntity);
        var refreshToken = jwtService.generateRefreshToken(userEntity);
        var token = Token.builder()
                .userEntity(userEntity)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        revokeAllUserTokens(userEntity);
        tokenRepository.save(token);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public String register(RegisterDTO registerDTO) {

        if(userRepository.existsByEmail(registerDTO.getEmail())){
            return "Email Already Exists" +
                    "Register with a new email address";
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstname(registerDTO.getFirstname());
        userEntity.setLastname(registerDTO.getLastname());
        userEntity.setEmail(registerDTO.getEmail());
        userEntity.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        RoleEntity roles = roleRepository.findByName("USER").get();
        userEntity.setRoles(Collections.singletonList(roles));

        userRepository.save(userEntity);

        return "Register Success" +
                "Get back to login page and login with your email";
    }

    private void revokeAllUserTokens(UserEntity userEntity) {
        var validUserTokens = tokenRepository.findAllValidTokenByUserEntity(userEntity.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        final String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return;
        }
        final String refreshToken = authorizationHeader.substring(7);
        final String useremail =jwtService.extractUsername(refreshToken);

        if (useremail != null) {
            var userEntity = userRepository.findByEmail(useremail).
                    orElseThrow();
            if(jwtService.validateToken(refreshToken, userEntity)){
                var accessToken = jwtService.generateToken(userEntity);
                revokeAllUserTokens(userEntity);
                var token = Token.builder()
                        .userEntity(userEntity)
                        .token(accessToken)
                        .tokenType(TokenType.BEARER)
                        .expired(false)
                        .revoked(false)
                        .build();
                tokenRepository.save(token);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
