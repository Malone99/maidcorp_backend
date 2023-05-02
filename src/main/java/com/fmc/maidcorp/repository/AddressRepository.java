package com.fmc.maidcorp.repository;

import com.fmc.maidcorp.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Override
    List<Address> findAllById(Iterable<Long> longs);

}

