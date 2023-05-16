package com.fmc.maidcorp.service.impl;

import com.fmc.maidcorp.domain.Address;
import com.fmc.maidcorp.domain.MaidProfile;
import com.fmc.maidcorp.factory.AddressFactory;
import com.fmc.maidcorp.factory.MaidProfileFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class MaidProfileImplTest {

    Address addressSet2= AddressFactory.build("Fame Cresent","Cape Town", "Western Cape");
    Address addressSet= AddressFactory.build("Arnoldo","Durben", "Free  State");
    Address addressSet3= AddressFactory.build("Broadway Bulavard","Strand", "Northern  State");
    MaidProfile test= MaidProfileFactory.build("Faith", "","Johnson"
            ,new Date(), addressSet);
    MaidProfile test2= MaidProfileFactory.build("Faith", "","Jackson"
            ,new Date(),addressSet2);
    MaidProfile test3= MaidProfileFactory.build("Diana", "Fungai","Chawora"
            ,new Date(),addressSet3);
    @Autowired
       private MaidProfileServiceImpl service;

    @Test
    void a_save() {
        MaidProfile save =service.save(test);
        MaidProfile save2 =service.save(test2);
        MaidProfile save3 =service.save(test3);

        System.out.println(save.toString());
    }

    @Test
    void read() {
    }

//    @Test
//    void b_delete() {
//        service.delete(2L);
//    }

    @Test
    void b_findAll() {
        List<MaidProfile> all=service.findAll();
        System.out.println(all);
    }
}