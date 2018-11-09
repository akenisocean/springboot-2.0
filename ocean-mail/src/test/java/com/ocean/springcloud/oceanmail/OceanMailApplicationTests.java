package com.ocean.springcloud.oceanmail;

import com.ocean.springcloud.oceanmail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfigurationAttributes;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OceanMailApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Resource
	private MailService mailService;

	@Test
	public void sendSimpleMialTest(){
		mailService.sendSimpleMail("akenisocean164214878@gmail.com","这是我的第一份邮件",
				"springboot发送的第一份邮件");
	}


	@Test
	public void sendHtmlMailTest() throws MessagingException {
		String content = "<!DOCTYPE html>\n" +
				"<!--STATUS OK--><html> <head><meta http-equiv=content-type content=text/html;" +
				"charset=utf-8><meta http-equiv=X-UA-Compatible content=IE=Edge><meta content=always" +
				" name=referrer><link rel=stylesheet type=text/css " +
				"href=http://s1.bdstatic.com/r/www/cache/bdorz/baidu.min.css>" +
				"<title>百度一下，你就知道</title></head> <body link=#0000cc> <" +
				"div id=wrapper> <div id=" +
				"head> <div class=head_wrapper> <div class=s_form> <div class=s_form_wrapper>" +
				" <div id=lg> <img hidefocus=true src=//www.baidu.com/img/bd_logo1.png width=270 " +
				"height=129> </div> <form id=form name=f action=//www.baidu.com/s class=fm> <input" +
				" type=hidden name=bdorz_come value=1> <input type=hidden name=ie value=utf-8> " +
				"<input type=hidden name=f value=8> <input type=hidden name=rsv_bp value=1> <input" +
				" type=hidden name=rsv_idx value=1> <input type=hidden name=tn value=baidu><span " +
				"class=\"bg s_ipt_wr\"><input id=kw name=wd class=s_ipt value maxlength=255" +
				" autocomplete=off autofocus></span><span class=\"bg s_btn_wr\"><input type=submit id=su value=百度一下" +
				" class=\"bg s_btn\"></span> </form> </div> </div> <div id=u1>" +
				" <a href=http://news.baidu.com name=tj_trnews class=mnav>新闻</a>" +
				" <a href=http://www.hao123.com name=tj_trhao123 class=mnav>hao123</a> " +
				"<a href=http://map.baidu.com name=tj_trmap class=mnav>地图</a> <a href=http://v.baidu.com name=tj_trvideo class=mnav>视频</a> <a href=http://tieba.baidu.com name=tj_trtieba class=mnav>贴吧</a> <noscript> <a href=http://www.baidu.com/bdorz/login.gif?login&amp;tpl=mn&amp;u=http%3A%2F%2Fwww.baidu.com%2f%3fbdorz_come%3d1 name=tj_login class=lb>登录</a> </noscript> <script>document.write('<a href=\"http://www.baidu.com/bdorz/login.gif?login&tpl=mn&u='+ encodeURIComponent(window.location.href+ (window.location.search === \"\" ? \"?\" : \"&\")+ \"bdorz_come=1\")+ '\" name=\"tj_login\" class=\"lb\">登录</a>');</script> <a href=//www.baidu.com/more/ name=tj_briicon class=bri style=\"display: block;\">更多产品</a> </div> </div> </div> <div id=ftCon> <div id=ftConw> <p id=lh> <a href=http://home.baidu.com>关于百度</a> <a href=http://ir.baidu.com>About Baidu</a> </p> <p id=cp>&copy;2017&nbsp;Baidu&nbsp;<a href=http://www.baidu.com/duty/>使用百度前必读</a>&nbsp; <a href=http://jianyi.baidu.com/ class=cp-feedback>意见反馈</a>&nbsp;京ICP证030173号&nbsp; <img src=//www.baidu.com/img/gs.gif> </p> </div> </div> </div> </body> </html>\n";
		mailService.sendHtmlMail("akenisocean164214878@gmail.com","这是一封html邮件"
		,content);
	}



	@Test
	public void sendAttachmentMailTest() throws MessagingException {
		String filePath = "C:\\Users\\Administrator\\Desktop\\hash路由history路由.zip";
		mailService.sendAttachmentsMail("akenisocean164214878@gmail.com","这是一封带附件的邮件","你值得拥有",filePath);

	}

	@Test
	public void sednInlineResourceMailTest()throws MessagingException{
		String imgPath = "C:\\Users\\Administrator\\Desktop\\消息发送模式-顺序发送.png";
		String rscId = "hahaoo1";
		String content = "<html><body> 这是又图片的邮件:<img src=\'cid:"+rscId+"\'></img></body></html>";
        mailService.sendInlineResourceMail("akenisocean164214878@gmail.com","这是一个图片邮件",content,imgPath,rscId);
	}


	@Resource
	private TemplateEngine templateEngine;

	@Test
	public void testTemplateMialTest() throws MessagingException {
		Context context = new Context();
		context.setVariable("id","006");
		String emailContent = templateEngine.process("emailTemplate",context);

        mailService.sendHtmlMail("akenisocean164214878@gmail.com","这是一个邮件模板",emailContent);
	}

}
