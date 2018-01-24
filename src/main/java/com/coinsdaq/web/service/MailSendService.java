package com.coinsdaq.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "spring.mail")
@Service("mailSendService")
public class MailSendService {

    private final Logger log = LoggerFactory.getLogger(MailSendService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.mailFrom}")
    private String mailFrom;

    private Map<String ,String> mailSubject;

    public Map<String, String> getMailSubject() {
        return mailSubject;
    }
    public void setMailSubject(HashMap<String,String> mailSubject){
        this.mailSubject = mailSubject;
    }

    public boolean sendMail(String mailTo){
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(mailTo);
            helper.setText("<b>환영합니다<b>",true);
            helper.setFrom(mailFrom);


        }catch (MessagingException me){
            log.info("FAIL MAIL SEND TO {}",mailTo);
            return false;
        }
        mailSender.send(message);
        return true;
    }




}
