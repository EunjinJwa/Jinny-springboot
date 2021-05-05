package com.jinny.java.springboot.singledb.config;

import com.jinny.java.springboot.singledb.model.AuthToken;
import org.springframework.stereotype.Component;

@Component
public class ContextBean {

    private AuthToken authToken;

    public ContextBean() {
        System.out.println("<<ContextBean>>");
    }

    public void createTocken(){
        System.out.println("createTocken");
        authToken = new AuthToken("Test Token","Test Token Type", 10000,"trust");
    }

    public void createTocken2(){
        System.out.println("createTocken2");
        authToken = new AuthToken("Test Token22","Test Token Type", 10000,"trust");
    }
    public AuthToken getToken(){
        return authToken;
    }

}
