package com.ocean.springcloud.oceandemo.controller;

import com.ocean.springcloud.oceandemo.util.SwaggerUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.net.MalformedURLException;

/**
 * @author: chao
 * @description:
 * @create: 2020-04-28 21:01
 */

@RestController
@RequestMapping("/export")
@ApiIgnore
public class ExportController {
    @RequestMapping("/ascii")
    public String exportAscii() throws MalformedURLException {
        SwaggerUtils.generateAsciiDocs();
        return "success";
    }

    @RequestMapping("/asciiToFile")
    public String asciiToFile() throws MalformedURLException{
        SwaggerUtils.generateAsciiDocsToFile();
        return "success";
    }

    @RequestMapping("/markdown")
    public String exportMarkdown() throws MalformedURLException{
        SwaggerUtils.generateMarkdownDocs();
        return "success";
    }

    @RequestMapping("/markdownToFile")
    public String exportMarkdownToFile() throws MalformedURLException{
        SwaggerUtils.generateMarkdownDocsToFile();
        return "success";
    }

    @RequestMapping("/confluence")
    public String confluence() throws MalformedURLException{
        SwaggerUtils.generateConfluenceDocs();
        return "success";
    }

    @RequestMapping("/confluenceToFile")
    public String confluenceToFile() throws MalformedURLException{
        SwaggerUtils.generateConfluenceDocsToFile();
        return "success";
    }
}
