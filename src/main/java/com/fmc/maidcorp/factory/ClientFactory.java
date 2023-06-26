package com.fmc.maidcorp.factory;

import com.fmc.maidcorp.domain.Address;
import com.fmc.maidcorp.domain.Client;
import com.fmc.maidcorp.domain.maidservices.RegularCleaning;
import com.fmc.maidcorp.domain.maidservices.SpringCleaning;
import com.fmc.maidcorp.helper.Helper;

import java.util.List;

public class ClientFactory {

    public static Client build(
              String firstName
             ,String lastName
             ,String email
             ,List<Address> address
             ,RegularCleaning regularCleaning
             ,SpringCleaning springCleaning){

//        Helper.check(firstName);
//        Helper.check(lastName);
//        Helper.check(email);

        return Client.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .address(address)
                .regularCleaning(regularCleaning)
                .springCleaning(springCleaning)
                .build();

    }
}
