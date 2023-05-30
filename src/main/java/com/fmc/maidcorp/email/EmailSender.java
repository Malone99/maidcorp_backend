package com.fmc.maidcorp.email;

import jakarta.mail.MessagingException;

import java.io.IOException;

public interface EmailSender {

    void sendEmail(String to, String subject, String body) throws IOException, MessagingException;
}
