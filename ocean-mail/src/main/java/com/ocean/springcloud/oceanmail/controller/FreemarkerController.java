package com.ocean.springcloud.oceanmail.controller;

import com.ocean.springcloud.oceanmail.entity.EmailInhibition;
import com.ocean.springcloud.oceanmail.entity.EmailInhibitionParam;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.Model;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.*;

/**
 * @author: chao
 * @description:
 * @create: 2020-03-27 15:51
 */
@RestController
@RequestMapping("/freemarker")
public class FreemarkerController {
    @Autowired
    private JavaMailSender jms;

    @Autowired
    private Configuration configuration;


    @RequestMapping("/show")
    public String show(@RequestParam(value = "free", defaultValue = "hahaha") String free) {

        MimeMessage message = jms.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("jc164214878@163.com");
            helper.setTo("jc164214878@163.com");
            helper.setSubject("使用模板");

//            List<MessageInhibition> inhibitions = new ArrayList<>();

//            for (int x = 0; x < 3; x++) {
//                MessageInhibition messageInhibition = new MessageInhibition();
//                messageInhibition.setCause("cause"+x);
//                messageInhibition.setMessageCode("code"+x);
//                messageInhibition.setMessageStatus("status"+x);
//                inhibitions.add(messageInhibition);
//            }
//
//            MessageCode build = MessageCode.builder()
//                    .list(Arrays.asList("123", "234", "345"))
//                    .inhibitions(inhibitions)
//                    .build();

            EmailInhibition emailInhibtion = EmailInhibition.builder()
                    .sendTime("2029年10月14日 12:23:23")
                    .strategyName("jkstack策略")
                    .title("告警源:资源监控   业务级别：A类邮件，Windows    告警等级：严重Linux-生产  监控指标：CPU负载过高")
                    .build();

            List<EmailInhibitionParam> emailInhibitionList = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                TreeMap<String, List<String>> map = new TreeMap<>();
                map.put("哈哈",Arrays.asList("严重","A类邮件，Windows","Server"));
                map.put("哈哈2",Arrays.asList("严重","A类邮件，Windows","Server2"));
                map.put("哈哈3",Arrays.asList("严重","A类邮件，Windows","Server3"));
                EmailInhibitionParam build = EmailInhibitionParam.builder()
                        .tagName("资源标签：sever")
                        .tagTitles(Arrays.asList("告警级别", "业务级别", "主机名"))
                        .tagParams(map)
                        .build();
                emailInhibitionList.add(build);
            }
            emailInhibtion.setEmailInhibitionParamList(emailInhibitionList);

            Map<String, Object> model = new HashMap();
            model.put("emailInhibition", emailInhibtion);
            try {
                Template template = configuration.getTemplate("temp2.ftl");
                String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
                helper.setText(html, true);
            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (MessagingException e) {
            e.printStackTrace();
        }

        jms.send(message);


        return "freemarker";
    }

    public User initUser() {
        User user = new User();

        user.setId(24);
        user.setBoy(true);
        user.setName("wsz");
        user.setPrice(666666d);

        List<String> list = new ArrayList<String>();
        list.add("list1");
        list.add("list2");
        list.add("list3");
        user.setList(list);

        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        user.setSet(set);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("m1", "m1");
        map.put("m2", "m2");
        map.put("m3", "m3");
        user.setMap(map);

        return user;
    }


    @SneakyThrows
    @RequestMapping("/show2")
    public String show2(@RequestParam(value = "free", defaultValue = "hahaha") String free) {
        MimeMessage message = jms.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("jc164214878@163.com");
        helper.setTo("jc164214878@163.com");
        helper.setSubject("使用模板");
        List<EmailValueRange> emailValueRanges = new ArrayList<>();
        EmailValueRange build1 = EmailValueRange.builder().titleName("titleName").titleValue("titleValue").build();
        EmailValueRange build2 = EmailValueRange.builder().titleName("titleName").titleValue("titleValue").build();
        emailValueRanges.add(build2);
        emailValueRanges.add(build1);
        SingleEmailInhibition emailInhibtion = SingleEmailInhibition.builder()
                .title("laji")
                .valueRange(emailValueRanges).build();


        Map<String, Object> model = new HashMap(1);
        model.put("singleEmailInhibition", emailInhibtion);
        try {
            Template template = configuration.getTemplate("emailTemplate.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            helper.setText(html, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

}
