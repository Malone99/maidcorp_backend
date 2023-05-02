package com.fmc.maidcorp;

import com.fmc.maidcorp.domain.Address;
import com.fmc.maidcorp.domain.MaidProfile;
import com.fmc.maidcorp.factory.MaidProfileFactory;
import com.fmc.maidcorp.service.impl.MaidProfileServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MaidcorpApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaidcorpApplication.class, args);
    }

//    @Bean
//    CommandLineRunner run(MaidProfileServiceImpl service) {
//        return args -> {
//            Address addressSet=new Address();
//
//            MaidProfile obj= MaidProfileFactory.build("Farai", "Malone","Chawara"
//            ,new Date(),addressSet);
//            MaidProfile obj2= MaidProfileFactory.build("Manuel", "Tatenda","Chawora"
//                    ,new Date(),addressSet);
//            service.save(obj2);
//            service.save(obj);
//
//        };
//    }



}
