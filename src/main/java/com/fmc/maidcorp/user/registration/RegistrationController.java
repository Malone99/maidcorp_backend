package com.fmc.maidcorp.user.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin
@RequestMapping("maidcorp/api/")
public class RegistrationController {

    final RegistrationService registrationService;
    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;

    }
@PostMapping("reg")
    public ResponseEntity<String> register(@RequestBody UserRegistration registration){
    System.out.println("Registartion end point hit"+registration.toString());
       String reg= registrationService.register(registration);
        return  ResponseEntity.ok(reg);
    }
}
