package com.fmc.maidcorp.user.registration;

import com.fmc.maidcorp.user.AppUser;
import com.fmc.maidcorp.user.AppUserRole;
import com.fmc.maidcorp.user.UserAppService;
import com.fmc.maidcorp.user.registration.token.ConfirmationToken;
import com.fmc.maidcorp.user.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public  class RegistrationService {

    private final EmailValidator emailValidator;
    private final UserAppService userAppService;
    private final ConfirmationTokenService tokenService;
    public String  register(UserRegistration request){

       boolean isValid= emailValidator.test(request.getEmail());
        if(!isValid){
            throw  new IllegalStateException("email not valid");
        }
        System.out.println("RegService hit-->"+request.toString());
        return  userAppService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }

    public String confirmToken(String token){
        ConfirmationToken confirmationToken=tokenService
                .getToken(token).orElseThrow(
                        ()-> new IllegalStateException("TOKEN_NOT_FOUND")
                );

        if(confirmationToken.getConfirmedAt()!=null){
            throw new IllegalStateException("email already confirmed");
        }
       return "";
    }
}
