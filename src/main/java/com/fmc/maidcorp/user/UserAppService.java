package com.fmc.maidcorp.user;

import com.fmc.maidcorp.user.registration.token.ConfirmationToken;
import com.fmc.maidcorp.user.registration.token.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service

public class UserAppService implements UserDetailsService {

    private final  String USER_NOT_FOUND_MSG="User with email %s not found";
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    final AppUserRepository appUserRepository;
    private  final ConfirmationTokenService confirmationTokenService;
   @Autowired
    public UserAppService(BCryptPasswordEncoder bCryptPasswordEncoder, AppUserRepository appUserRepository, ConfirmationTokenService confirmationTokenService) {
       this.bCryptPasswordEncoder = bCryptPasswordEncoder;
       this.appUserRepository = appUserRepository;
       this.confirmationTokenService = confirmationTokenService;
   }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(()->
                        new UsernameNotFoundException(String
                                .format(USER_NOT_FOUND_MSG,email)));
    }

    public String signUpUser (AppUser appUser){
       boolean userExits=appUserRepository.findByEmail(appUser.getEmail()).isPresent();
       if(userExits){
           throw new IllegalStateException("email already takken");
       }
       String encodedPassword=bCryptPasswordEncoder.encode(appUser.getPassword());
       appUser.setPassword(encodedPassword);
       appUserRepository.save(appUser);
       System.out.println("registration successful-->"+appUser.toString());

        String token= UUID.randomUUID().toString();

        ConfirmationToken confirmationToken= new ConfirmationToken(
                token, LocalDateTime.now(), LocalDateTime.now().minusMinutes(15),appUser
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
       return token;
    }
}
