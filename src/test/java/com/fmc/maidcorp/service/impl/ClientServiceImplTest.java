package com.fmc.maidcorp.service.impl;

import com.fmc.maidcorp.domain.Address;
import com.fmc.maidcorp.domain.Client;
import com.fmc.maidcorp.domain.maidservices.RegularCleaning;
import com.fmc.maidcorp.domain.maidservices.SpringCleaning;
import com.fmc.maidcorp.factory.AddressFactory;
import com.fmc.maidcorp.factory.ClientFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ClientServiceImplTest {

    Client client;
    Client client2=ClientFactory.build("Manu","Bubu","manu@gmail.com", new ArrayList<>(),new RegularCleaning(),new SpringCleaning());

    Address addressSet2= AddressFactory.build("Fame Cresent","Cape Town", "Western Cape");
    Address addressSet= AddressFactory.build("Arnoldo","Durben", "Free  State");
    List<Address> addresses = new ArrayList<>();
    void addtolist(){
        addresses.add(addressSet);
        addresses.add(addressSet2);
        client= ClientFactory.build("Farai","Mirone","manu@gmail.com", addresses,new RegularCleaning(),new SpringCleaning());

    }

    @BeforeEach
    void setUp() {
        addtolist();
    }

    @Autowired
    private ClientServiceImpl clientService;

    @Test
    void save() {
         addtolist();
        Client save= clientService.save(client);
        clientService.save(client2);
    }

    @Test
    void read() {
        Optional<Client> read=clientService.read(2L);
        System.out.println(read);
    }

//    @Test
//    void delete() {
//    }
//
    @Test
    void findAll() {
        List<Client> all=clientService.findAll();
        System.out.println(all);
    }
//
//    @Test
//    void getAll() {
//    }
//
//    @Test
//    void findAllBySpringCleaning() {
//    }
//
//    @Test
//    void update() {
//    }
}