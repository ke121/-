package com.tom.baiwei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.Thymeleaf;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Service
public class MailService {
    @Autowired
    JavaMailSender javaMailSender ;

    @Autowired
    TemplateEngine engine ;
    public void sendSimpleMail(){
        //创建一封邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("824280084@qq.com");
        simpleMailMessage.setTo("1319653801@qq.com");
        simpleMailMessage.setSentDate(new Date());
        simpleMailMessage.setSubject("这是一封测试邮件主题");
        simpleMailMessage.setText("这是测试邮件的内容");
        javaMailSender.send(simpleMailMessage);
    }

    public void sendHtmlMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setFrom("824280084@qq.com");
        helper.setTo("1319653801@qq.com");
        helper.setSentDate(new Date());
        helper.setSubject("这是一封测试邮件主题");

        Context context = new Context();
        context.setVariable("name","张三");
        context.setVariable("position","Java高级工程师");
        context.setVariable("salary", "25K");
        String process = engine.process("mail.html", context);
        helper.setText(process, true);
        javaMailSender.send(mimeMessage);
    }
}
