package com.tom.baiwei;

import com.tom.baiwei.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaiweiApplicationTests {

    @Autowired
    MailService mailService ;
    @Test
    public void contextLoads() throws MessagingException {
        mailService.sendHtmlMail();
    }

}
