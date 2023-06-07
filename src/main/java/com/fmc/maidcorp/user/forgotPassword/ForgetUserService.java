package com.fmc.maidcorp.user.forgotPassword;

import com.fmc.maidcorp.user.AppUser;
import com.fmc.maidcorp.user.AppUserRepository;
import com.fmc.maidcorp.user.UserAppService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ForgetUserService {
    @Autowired
    private final UserAppService userAppService;
    @Autowired
    private final AppUserRepository appUserRepository;


    public String changePassword(String email, String newPassword){
        AppUser changePassword= (AppUser) userAppService.loadUserByUsername(email);

        if (changePassword!=null)
            changePassword.setPassword(newPassword);

        return "";
    }


}
