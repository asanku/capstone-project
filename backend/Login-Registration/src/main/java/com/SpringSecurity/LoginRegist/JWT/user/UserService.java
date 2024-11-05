package com.SpringSecurity.LoginRegist.JWT.user;

import com.SpringSecurity.LoginRegist.JWT.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void changePassword(ChangePasswordRequest request,
                               Principal connectedUser) {

            var user = (UserEntity)((UsernamePasswordAuthenticationToken)connectedUser).getPrincipal();

            //check if the current password is correct
            if(!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
                throw new BadCredentialsException("Wrong password");
            }

            //check if the two new password are same
            if(!request.getNewPassword().equals(request.getConfirmPassword())) {
               throw new BadCredentialsException("Passwords are not same");
            }

            //update and save the new password
            user.setPassword(passwordEncoder.encode(request.getNewPassword()));
            userRepository.save(user);

    }

}
