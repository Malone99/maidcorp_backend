package com.fmc.maidcorp.controller;

import com.fmc.maidcorp.domain.MaidProfile;
import com.fmc.maidcorp.service.impl.AddressServiceImpl;
import com.fmc.maidcorp.service.impl.MaidProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class APi {

    final   AddressServiceImpl addressService;
    final MaidProfileServiceImpl maidProfileService;


    public APi(AddressServiceImpl addressService, MaidProfileServiceImpl maidProfileService) {
        this.addressService = addressService;
        this.maidProfileService = maidProfileService;
    }

//    public MaidProfile assignAddress(Long  maidID, Long addressId){
//        MaidProfile assignAddress;
//        boolean isPresent=maidProfileService.read(maidID).isPresent();
//
//        if ((isPresent)){
//            Optional<MaidProfile> main=maidProfileService.read(maidID);
//            assignAddress.setId(main.get());
//        }
//    }
}
