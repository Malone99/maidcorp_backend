package com.fmc.maidcorp.controller;

import com.fmc.maidcorp.domain.Address;
import com.fmc.maidcorp.domain.MaidProfile;
import com.fmc.maidcorp.dto.AddressDto;
import com.fmc.maidcorp.service.impl.AddressServiceImpl;
import com.fmc.maidcorp.service.impl.MaidProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class APi {

    final AddressServiceImpl addressService;
    final MaidProfileServiceImpl maidProfileService;


    public APi(AddressServiceImpl addressService, MaidProfileServiceImpl maidProfileService) {
        this.addressService = addressService;
        this.maidProfileService = maidProfileService;
    }

    public String assignAddress(Long maidID, Long addressId) {
        MaidProfile assignAddress;
        boolean isPresent = maidProfileService.read(maidID).isPresent();
        boolean isPresentAddress = addressService.read(addressId).isPresent();
        Optional<Address> address = addressService.read(addressId);
        Optional<MaidProfile> maid = maidProfileService.read(maidID);

        if ((!isPresent || !isPresentAddress)) {
            throw new IllegalStateException("Maid does not exits");
        }

        Address address1 = address.get();
        assignAddress = maid.get();
        assignAddress.setAddress(address1);
        maidProfileService.save(assignAddress);

        return assignAddress.toString();

    }
}