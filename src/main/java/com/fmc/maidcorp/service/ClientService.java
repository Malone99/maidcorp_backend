package com.fmc.maidcorp.service;

import com.fmc.maidcorp.domain.Client;
import com.fmc.maidcorp.domain.MaidProfile;

import java.util.List;

public interface ClientService extends IService<Client,Long>{
    List<Client> findAll();
    Client update(Client update);
}