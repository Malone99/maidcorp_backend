package com.fmc.maidcorp.controller;

import com.fmc.maidcorp.domain.Client;
import com.fmc.maidcorp.domain.MaidProfile;
import com.fmc.maidcorp.dto.ClientDto;
import com.fmc.maidcorp.dto.MaidProfileDto;
import com.fmc.maidcorp.service.impl.ClientServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("maidcorp/api/client/")
public class ClientController {
    @Autowired
    final private ClientServiceImpl clientService;

    @PostMapping("save")
    public ResponseEntity<Client> save(@RequestBody Client client){
        Client save=clientService.save(client);
        return ResponseEntity.ok(save);
    }
    @GetMapping("read/{id}")
    public ResponseEntity<Client> read(@PathVariable Long id){
        Client read =clientService.read(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return ResponseEntity.ok(read);
    }

    @GetMapping("findAll")
    public  ResponseEntity<List<Client>> findAll(){
        List<Client> all=clientService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("getAll")
    public  ResponseEntity<List<ClientDto>> getAll(){
        List<ClientDto> allclient=clientService.getAll();
        return ResponseEntity.ok(allclient);
    }
}
