package com.fmc.maidcorp.service.impl;

import com.fmc.maidcorp.domain.Client;
import com.fmc.maidcorp.domain.maidservices.SpringCleaning;
import com.fmc.maidcorp.dto.ClientDto;
import com.fmc.maidcorp.repository.ClientRepository;
import com.fmc.maidcorp.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    @Autowired
    private final ClientRepository clientRepository;
    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }
    @Override
    public Optional<Client> read(Long id) {
        Optional<Client> read=clientRepository.findById(id);
        return read;
    }
    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
    public List<ClientDto> getAll(){
        return clientRepository.getAll();
    }
    public List<ClientDto> findAllBySpringCleaning(SpringCleaning springCleaning){
        return clientRepository.findAllBySpringCleaning(springCleaning);
    }
    @Override
    public Client update(Client update) {
        boolean temp=read(update.getId()).isPresent();
        if(!temp){
            throw new IllegalStateException("NOT FOUND");
        }
        return clientRepository.save(update);
    }

}
