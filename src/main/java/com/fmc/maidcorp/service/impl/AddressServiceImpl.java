package com.fmc.maidcorp.service.impl;

import com.fmc.maidcorp.domain.Address;
import com.fmc.maidcorp.repository.AddressRepository;
import com.fmc.maidcorp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    final AddressRepository repository;
    @Autowired
    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address save(Address address) {
        return repository.save(address);
    }

    @Override
    public Optional<Address> read(Long id) {
        Optional<Address> read= repository.findById(id);
        return read;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
