package com.fmc.maidcorp.controller;

import com.fmc.maidcorp.service.impl.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@AllArgsConstructor
@RequestMapping("maidcorp/uploadfile/")
public class FileSystemController {
    @Autowired
    private final StorageService storageService;

    @PostMapping("uploadFile")
    public ResponseEntity<?> uploadFile(@RequestParam("image") MultipartFile multipartFile) throws IOException {
       String upload=storageService.uploadImageTofileSystem(multipartFile);
       return ResponseEntity.status(HttpStatus.OK).body(upload);
    }

    @GetMapping("{filename}")
    public ResponseEntity<?> downloadFile(@PathVariable String filename) throws IOException {
         byte [] fileImage= storageService.downloadFile(filename);
         return ResponseEntity.status(HttpStatus.OK)
                 .contentType(MediaType.valueOf("image/png")).body(fileImage);
    }
}
