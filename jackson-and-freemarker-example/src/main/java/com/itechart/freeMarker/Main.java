package com.itechart.freeMarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/freeMarker"));
        cfg.setDefaultEncoding("UTF-8");

        Map<String, String> map = new HashMap<>();
        map.put("user", "Alex");
        map.put("completeRegistrationLink", "https://example.com/complete-registration");
        Template temp = cfg.getTemplate("confirm-registration-email.ftl");
        StringWriter writer = new StringWriter();
        temp.process(map, writer);

        System.out.println(writer.toString());
    }
}
