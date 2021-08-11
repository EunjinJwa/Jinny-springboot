package com.jinny.java.springboot.singledb;


import com.jinny.java.springboot.singledb.config.ContextBean;
import com.jinny.java.springboot.singledb.model.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WorkerApplication {

    @Autowired
    private static ContextBean contextBean;

    public static void main(String[] args) {
        SpringApplication.run(WorkerApplication.class, args);
    }
}
