package com.fmc.maidcorp.factory;

import com.fmc.maidcorp.domain.Address;
import com.fmc.maidcorp.domain.MaidProfile;
import com.fmc.maidcorp.helper.Helper;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MaidProfileFactory {

    public static MaidProfile build(
            String firstName,
            String middleName,
            String lastName
            , Date dob
            , Address address
            ){
            Helper.check(firstName);
            Helper.check(lastName);

        return  MaidProfile.builder()
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .dob(dob)
                .address(address)
                .build();
    }

    public static void main(String[] args) {
//        Set<Address> NN=new HashSet<>();
//        MaidProfile nn=MaidProfileFactory.build("Fraai","","",new Date(),NN);
//        System.out.println(nn.toString());
    }
}
