package com.fmc.maidcorp.user.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class UserRegistration {

    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;


}
