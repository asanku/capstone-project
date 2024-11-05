package com.SpringSecurity.LoginRegist.JWT.user;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChangePasswordRequest{

    private String OldPassword;
    private String NewPassword;
    private String ConfirmPassword;

}
