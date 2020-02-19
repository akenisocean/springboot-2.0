package com.ocean.springcloud.oceanmail.controller;

import com.ocean.springcloud.oceanmail.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: chao
 * @description: themeleaf测试
 * @create: 2020-01-07 12:39
 */
@Slf4j
@Controller
@RequestMapping("/themeleaf")
public class ThemeController {

//    @Resource
//    private TemplateEngine templateEngine;

    @Resource
    MailService mailService;

    @GetMapping("/tableTemplate")
    public void tableTemplate() throws MessagingException {
//        Context context = new Context();
//        context.setVariable("id","17763");
//        String tableTemplate = templateEngine.process("tableTemplate", context);


        ClassPathResource classPathResource = new ClassPathResource("html/tableTemplate.html");
        StringBuffer buffer = new StringBuffer();
        try (InputStream inputStream = classPathResource.getInputStream();
             BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));) {

            String line = "";
            while ((line = fileReader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            log.error("读取文件失败", e);
        }



        //邮件表格header
        String header = "<td>告警级别</td><td>告警源名称</td><td>类型</td><td>类型分类</td><td>主机名称</td><td>主机IP</td><td>事件ID</td>" +
                "<td>告警详情</td><td>告警时间</td><td>关键信息</td>";





        StringBuilder linesBuffer = new StringBuilder();
        // TODO 邮件内容
        linesBuffer.append("<tr><td>" + "myNamespace" + "</td><td>" + "myServiceName" + "</td><td>" + "myscaleResult" + "</td>" +
                "<td>" + "mReason" + "</td><td>" + "my4" + "</td></tr>");
        linesBuffer.append("<tr><td>" + "myNamespace2" + "</td><td>" + "myServiceName" + "</td><td>" + "myscaleResult" + "</td>" +
                "<td>" + "mReason" + "</td><td>" + "my5" + "</td></tr>");
        linesBuffer.append("<tr><td>" + "myNamespace" + "</td><td>" + "myServiceName" + "</td><td>" + "myscaleResult" + "</td>" +
                "<td>" + "mReason" + "</td><td>" + "my4" + "</td></tr>");
        linesBuffer.append("<tr><td>" + "myNamespace2" + "</td><td>" + "myServiceName" + "</td><td>" + "myscaleResult" + "</td>" +
                "<td>" + "mReason" + "</td><td>" + "my5" + "</td></tr>");
        linesBuffer.append("<tr><td>" + "myNamespace" + "</td><td>" + "myServiceName" + "</td><td>" + "myscaleResult" + "</td>" +
                "<td>" + "mReason" + "</td><td>" + "my4" + "</td></tr>");
        linesBuffer.append("<tr><td>" + "myNamespace2" + "</td><td>" + "myServiceName" + "</td><td>" + "myscaleResult" + "</td>" +
                "<td>" + "mReason" + "</td><td>" + "my5" + "</td></tr>");


      String headLine =   "";

        String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        //填充html模板中的五个参数
        String htmlText = MessageFormat.format(buffer.toString(), headLine, date, header, linesBuffer.toString());

        //改变表格样式
        htmlText = htmlText.replaceAll("<td>", "<td style=\"padding:6px 10px; line-height: 150%;\">");
       htmlText = htmlText.replaceAll("<tr>", "<tr style=\"border-bottom: 1px solid #eee; color:#666;\">");
        mailService.send2(htmlText);

    }
}
