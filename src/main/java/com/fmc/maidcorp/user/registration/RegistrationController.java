package com.fmc.maidcorp.user.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("maidcorp/api/registration/")
public class RegistrationController {


    final RegistrationService registrationService;
    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
@GetMapping("register")
    public String register(@RequestBody UserRegistration registration){
        return registrationService.register(registration);
    }
}
