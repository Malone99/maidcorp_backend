package com.fmc.maidcorp.user.registration;

import com.fmc.maidcorp.user.UserAppService;
import jakarta.mail.MessagingException;
import lombok.SneakyThrows;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Controller
@CrossOrigin
@RequestMapping("maidcorp/api/")
public class RegistrationController {

    final RegistrationService registrationService;
    final UserAppService userAppService;
//    private   final AuthenticationManager authenticationManager;
//    private final SessionRegistry sessionRegistry;
    @Autowired
    public RegistrationController(RegistrationService registrationService
            , UserAppService userAppService
            //, AuthenticationManager authenticationManager, SessionRegistry sessionRegistry
    ) {
        this.registrationService = registrationService;

        this.userAppService = userAppService;
//        this.authenticationManager = authenticationManager;
//        this.sessionRegistry = sessionRegistry;
    }
    @PostMapping("reg")
    public ResponseEntity<String> register(@RequestBody UserRegistration registration){
    System.out.println("Registartion end point hit"+registration.toString());
       String reg= registrationService.register(registration);
        return  ResponseEntity.ok(reg);
    }
    @SneakyThrows
    @PostMapping("{email}/{password}")
    public ResponseEntity<String> register(@PathVariable String email, @PathVariable String password) throws MessagingException, IOException {
        System.out.println("Registartion end point hit");
        String reg= null;
        try {
            reg = userAppService.changePassword(email,password);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  ResponseEntity.ok(reg);
    }
//     @PostMapping("login")
//    public ResponseEntity<String> login(User user){
//          authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                  user.getUsername(),user.getPassword()
//          ));
//         return null;
//     }
}
