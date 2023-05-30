package com.fmc.maidcorp.service.impl;

import com.fmc.maidcorp.domain.FileData;
import com.fmc.maidcorp.repository.FileDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StorageService {
     @Autowired
    final private FileDataRepository fileDataRepository;

     private final  String fileSystemPath ="C:\\Users\\FARAI SKOOL\\IdeaProjects\\maidcorp\\src\\main\\resources\\templates\\email\\";
      final ClassPathResource pathResource = new ClassPathResource("templates/email/");
     public  String uploadImageTofileSystem(MultipartFile multipartFile) throws IOException {

         String path= fileSystemPath +multipartFile.getName();
         String path2=pathResource.getPath();
         String  fullPath=path2+multipartFile.getName();
         FileData fileData=FileData.builder()
                 .name(multipartFile.getOriginalFilename())
                 .type(multipartFile.getContentType())
                 .path(fullPath)
                 .build();
         fileDataRepository.save(fileData);

         multipartFile.transferTo(new File(path));

         boolean isNUll= fileData==null;

         return  isNUll? "file is null": "file successfully saved->"+fullPath;
     }

    public  byte[] downloadFile( String filename) throws IOException {

        Optional<FileData> file=fileDataRepository.findByName(filename);
        String filePath=file.get().getPath();
        byte [] fileImage= Files.readAllBytes(new File(filePath).toPath());
        return fileImage;
    }
}
