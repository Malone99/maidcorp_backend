package com.fmc.maidcorp.controller;

import com.fmc.maidcorp.domain.MaidProfile;
import com.fmc.maidcorp.dto.MaidProfileDto;
import com.fmc.maidcorp.service.impl.MaidProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("maidcorp/api/")
@CrossOrigin
public class MaidController {

    final MaidProfileServiceImpl maidService;
    final APi api;
    @Autowired
    public MaidController(MaidProfileServiceImpl maidService, APi api) {
        this.maidService = maidService;
        this.api = api;
    }

    @PostMapping("save")
    public ResponseEntity<MaidProfile> save(@RequestBody MaidProfile maid){
        MaidProfile save=maidService.save(maid);
        return ResponseEntity.ok(save);
    }
    @GetMapping("findAll")
    public  ResponseEntity<List<MaidProfile>> findAll(){
        List<MaidProfile> maids=maidService.findAll();
        return ResponseEntity.ok(maids);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<MaidProfile> read(@PathVariable Long id){
        MaidProfile maid =maidService.read(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return ResponseEntity.ok(maid);
    }
    @GetMapping("assign/{ID}/{id}")
    public ResponseEntity<String> assign(@PathVariable Long ID, @PathVariable Long id){
        String maid =api.assignAddress(ID,id);
        return ResponseEntity.ok(maid);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long  id){
        this.maidService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("searchName/{surname}")
    public  ResponseEntity<List<MaidProfile>> findSurname(@PathVariable String surname){
        List<MaidProfile> allMaids=maidService.findBySurname(surname);
        return ResponseEntity.ok(allMaids);
    }

    @GetMapping("getAll")
    public  ResponseEntity<List<MaidProfileDto>> getAll(){
        List<MaidProfileDto> allMaids=maidService.getAll();
        return ResponseEntity.ok(allMaids);
    }
}
