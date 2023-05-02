package com.fmc.maidcorp.controller;

import com.fmc.maidcorp.domain.Address;
import com.fmc.maidcorp.service.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("maidcorp/api/address/")
public class AddressController {

    final AddressServiceImpl addressService;
    @Autowired
    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }
    @PostMapping("save")
    public ResponseEntity<Address> save(Address address){
        Address saved=addressService.save(address);
        return ResponseEntity.ok(saved);

    }
    @GetMapping("read/{id}")
    public ResponseEntity<Address> read(@PathVariable Long id ){
        Address read=addressService.read(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return ResponseEntity.ok(read);
    }
}
