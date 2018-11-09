package com.ocean.springcloud.oceanmail.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author 季超
 * @create 2018-11-09 13:13
 * @desc
 **/
@Service
public class MailService {

    @Value("${spring.mail.username}")
    private String from;

    @Resource
    private JavaMailSender javaMailSender;



    public void sayHello(){
        System.out.println("hello world!");
    }

    public void sendSimpleMail(String to,String subject,String content){
        //封装发送邮件的内容
        SimpleMailMessage mailMsg = new SimpleMailMessage();
        //设置发送给谁
        mailMsg.setTo(to);
        //设置发送邮件的标题
        mailMsg.setSubject(subject);
        //设置发送邮件的内容
        mailMsg.setText(content);
        //设置谁发送
        mailMsg.setFrom(from);
        //通过java提供好的JavaMailSender进行邮件的发送
        javaMailSender.send(mailMsg);
    }

    /**
     * 发送HTML类型的邮件
     * @param to 发送给谁
     * @param subject 发送的主题
     * @param content 发送的内容
     */
    public void sendHtmlMail(String to,String subject,String content) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(from);
        //true：使用html格式发送邮件
        helper.setText(content,true);
        javaMailSender.send(mimeMessage);
    }
    /**
     * 发送附件到指定邮箱
     * @param to 发送给谁
     * @param subject 发送的主题
     * @param content 发送的内容
     * @param filePath 发送附件的路径
     */
    public void sendAttachmentsMail(String to,String subject,String content,String filePath) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(from);
        helper.setText(content);
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = file.getFilename();
        helper.addAttachment(fileName,file);
        javaMailSender.send(mimeMessage);
    }

    /**
     * 发送图片邮件
     * @param to 发送给谁
     * @param subject 发送的主题
     * @param content 发送的内容
     * @param rscPath 邮件路径
     * @param rscId 邮件内容
     */
    public void sendInlineResourceMail(String to,String subject,String content,String rscPath,String rscId) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(from);
        helper.setText(content,true);
        FileSystemResource res = new FileSystemResource(new File(rscPath));
        helper.addInline(rscId,res);
        javaMailSender.send(mimeMessage);
    }
}
