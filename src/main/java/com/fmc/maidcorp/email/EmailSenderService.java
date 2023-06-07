package com.fmc.maidcorp.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

@Service
@AllArgsConstructor
public class EmailSenderService implements  EmailSender{
    private final static Logger LOGGER = LoggerFactory
            .getLogger(EmailSenderService.class);

    private final JavaMailSenderImpl mailSender;
    private final EmailBuilder emailBuilder;



    public void sendVericationEmail(String to, String link) throws IOException, MessagingException {
        String subject= "Email Verification ";
        StringBuilder bb=new StringBuilder();
        bb= new StringBuilder(emailBuilder.buildEmailTemplate("beefree-2i6dohndq85.html"));
        bb.append(link);
        String body= String.valueOf(bb);

        sendEmail(to, subject, body);
        System.out.println("email-->"+ body);


    }
    public void changePasswdEmail(String to, String username) throws IOException, MessagingException {
        String subject= "Email Verification ";
        StringBuilder bb=new StringBuilder();
        bb= new StringBuilder(emailBuilder.buildEmailTemplate("resetPassword.html"));
        bb.append(username);
        String body= String.valueOf(bb);

        sendEmail(to, subject, body);
        System.out.println("email-->"+ body);


    }

    @Override
    public void sendEmail(String to, String subject, String body) throws IOException, MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMsghelper =
                new MimeMessageHelper(mimeMessage, "utf-8");
        mimeMsghelper.setText(body, true);
        mimeMsghelper.setTo(to);
        mimeMsghelper.setSubject(subject);
        mailSender.setJavaMailProperties(getMailProperties());
        mailSender.send(mimeMessage);
    }
    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        return properties;
    }
}
