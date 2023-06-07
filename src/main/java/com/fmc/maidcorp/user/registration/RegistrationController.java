package com.fmc.maidcorp.user.registration;

import com.fmc.maidcorp.user.UserAppService;
import jakarta.mail.MessagingException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Controller
@CrossOrigin
@RequestMapping("maidcorp/api/")
public class RegistrationController {

    final RegistrationService registrationService;
    final UserAppService userAppService;
    @Autowired
    public RegistrationController(RegistrationService registrationService, UserAppService userAppService) {
        this.registrationService = registrationService;

        this.userAppService = userAppService;
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
}
