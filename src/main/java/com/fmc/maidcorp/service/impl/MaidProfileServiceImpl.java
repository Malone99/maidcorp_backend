package com.fmc.maidcorp.service.impl;

import com.fmc.maidcorp.domain.MaidProfile;
import com.fmc.maidcorp.dto.MaidProfileDto;
import com.fmc.maidcorp.repository.MaidProfileRepository;
import com.fmc.maidcorp.service.MaidProfileSevice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class MaidProfileServiceImpl implements MaidProfileSevice {

    final MaidProfileRepository repository;
    @Autowired
    public MaidProfileServiceImpl(MaidProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public MaidProfile save(MaidProfile maidProfile) {
        System.out.println("save object__>"+ maidProfile.toString());
        return repository.save(maidProfile);
    }

    @Override
    public Optional<MaidProfile> read(Long ID) {
        Optional<MaidProfile>readId=this.repository.findById(ID);
        log.info("read Customer By Id :"+readId);
        return  readId;
    }

    @Override
    public void delete(Long ID) {
        Optional <MaidProfile> read=read(ID);
        if (!(read.isPresent())){
            throw  new IllegalArgumentException("ID does not exist in the database");
        }else
        repository.deleteById(ID);

    }

    @Override
    public List<MaidProfile> findAll() {
        return repository.findAll();
    }

    public List<MaidProfileDto> getAll(){return  repository.getAllDto();}

    public List<MaidProfile> findBySurname(String surname ){

        List <MaidProfile> maids=this.repository.findMaidProfileByLastNameContainsIgnoreCase(surname);
       return maids;
    }

    @Override
    public MaidProfile update(MaidProfile update) {
        return repository.save(update);
    }

}
