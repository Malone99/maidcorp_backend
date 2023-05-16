package com.fmc.maidcorp.repository;

import com.fmc.maidcorp.domain.Client;
import com.fmc.maidcorp.domain.maidservices.SpringCleaning;
import com.fmc.maidcorp.dto.ClientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    List<ClientDto> findAllBySpringCleaning(SpringCleaning springCleaning);
    @Query("""
    select new com.fmc.maidcorp.dto.ClientDto(md.id, md.firstName, md.lastName, md.email, md.address,md.regularCleaning,md.springCleaning) from Client md 
    """)
    List<ClientDto> getAll();
}