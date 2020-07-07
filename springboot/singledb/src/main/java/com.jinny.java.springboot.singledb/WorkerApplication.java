package com.jinny.java.springboot.singledb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkerApplication.class, args);
    }
}

//@Configuration
//class LocalConfiguration {
//
//    @Value("${spring.phoenix.url}")
//    private String phoenixUrl;
//
//    @Bean
//    public Connection connection() {
//
//        Connection con = null;
//        try {
//            con = DriverManager.getConnection(phoenixUrl);
//
//        } catch (Exception e ){
//            e.printStackTrace();
//        }
//
//        return con;
//
//    }
//
//
// }