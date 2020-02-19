package com.ocean.springcloud.oceanmail.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Objects;

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


    public void sendSimpleMail(String to, String subject, String content) {
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
     *
     * @param to      发送给谁
     * @param subject 发送的主题
     * @param content 发送的内容
     */
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(from);
        //true：使用html格式发送邮件
        helper.setText(content, true);
        javaMailSender.send(mimeMessage);
    }

    /**
     * 发送附件到指定邮箱
     *
     * @param to       发送给谁
     * @param subject  发送的主题
     * @param content  发送的内容
     * @param filePath 发送附件的路径
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(from);
        helper.setText(content);
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = file.getFilename();
        helper.addAttachment(fileName, file);
        javaMailSender.send(mimeMessage);
    }

    /**
     * 发送图片邮件
     *
     * @param to      发送给谁
     * @param subject 发送的主题
     * @param content 发送的内容
     * @param rscPath 邮件路径
     * @param rscId   邮件内容
     */
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(from);
        helper.setText(content, true);
        FileSystemResource res = new FileSystemResource(new File(rscPath));
        helper.addInline(rscId, res);
        javaMailSender.send(mimeMessage);
    }

    public void send2(String content) throws MessagingException {
        //创建message
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        StringBuilder content=new StringBuilder("<html><head></head><body><h3>你好</h3><tr>服务完成</tr>");
//        content.append("<table border='5' style='border:solid 1px #E8F2F9;font-size=10px;'>");
//        content.append("<tr><th>Call No</th><td>"+"今天是个好日子"+"</td></tr>");
//        content.append("<tr><th>公司名称</th><td>column2</td></tr>");
//        content.append("<tr><th>分公司</th><td>column2</td></tr>");
//        content.append("<tr><th>地址</th><td>column2</td></tr>");
//        content.append("<tr><th>联系人</th><td>column2</td></tr>");
//        content.append("<tr><th>联系电话</th><td>column2</td></tr>");
//        content.append("<tr><th>用户信息</th><td>column2</td></tr>");
//        content.append("<tr><th>用户联系方式</th><td>column2</td></tr>");
//        content.append("<tr><th>用户Email</th><td>Sherry.Chen@mkcorp.com</td></tr>");
//        content.append("<tr><th>用户报障时间</th><td>column2</td></tr>");
//        content.append("<tr><th>服务响应时间</th><td>column2</td></tr>");
//        content.append("<tr><th>上门服务时间（年/月/日/时）</th><td>column2</td></tr>");
//        content.append("<tr><th>服务完成时间（年/月/日/时）</th><td>column2</td></tr>");
//        content.append("<tr><th>故障描述</th><td>投影仪颜色暗，清晰度比较差，上门协助</td></tr>");
//        content.append("<tr><th>解决方案 （需详细描述）</th><td>column2</td></tr>");
//        content.append("<tr><th>服务上门工程师</th><td>15265255388周华  </td></tr>");
//
//        content.append("</table>");
//        content.append("</body></html>");
        helper.setTo("164214878@qq.com");
        helper.setSubject("表格邮件");
        helper.setText(content,true);
        String alarmIconName = "html/jingkun.png";
        ClassPathResource img = new ClassPathResource(alarmIconName);
        if (Objects.nonNull(img)) {
            helper.addInline("icon-alarm", img);
        }
        helper.setFrom(from);
        javaMailSender.send(message);
    }
}
