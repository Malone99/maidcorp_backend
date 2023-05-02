package com.fmc.maidcorp.factory;

import com.fmc.maidcorp.domain.Address;
import com.fmc.maidcorp.helper.Helper;

public class AddressFactory {

    public static Address build(
         String street,
         String city,
         String province
    ){
        Helper.check(street);
        Helper.check(city);
        Helper.check(province);

        return Address.builder()
                .street(street)
                .city(city)
                .province(province)
//                .maid(maidProfile)
                .build();

    }
}
