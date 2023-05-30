package com.fmc.maidcorp.email;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component

public class EmailBuilder {
    @Autowired
    public EmailBuilder() {
    }

    public String buildEmailTemplate(String templateName) throws IOException {
        ClassPathResource pathResource = new ClassPathResource("templates/email/"+ templateName);
        byte [] temapleBytes= FileCopyUtils.copyToByteArray(pathResource.getInputStream());
        return  new String(temapleBytes, StandardCharsets.UTF_8);
    }
}
