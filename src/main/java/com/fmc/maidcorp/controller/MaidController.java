package com.fmc.maidcorp.controller;

import com.fmc.maidcorp.domain.Address;
import com.fmc.maidcorp.domain.MaidProfile;
import com.fmc.maidcorp.dto.MaidProfileDto;
import com.fmc.maidcorp.service.impl.MaidProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("maidcorp/api/")
public class MaidController {

    final MaidProfileServiceImpl maidService;
    @Autowired
    public MaidController(MaidProfileServiceImpl maidService) {
        this.maidService = maidService;
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
    @GetMapping("getAll")
    public  ResponseEntity<List<MaidProfileDto>> getAll(){
        List<MaidProfileDto> allMaids=maidService.getAll();
        return ResponseEntity.ok(allMaids);
    }
}
