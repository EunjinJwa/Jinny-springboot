package com.jinny.java.springboot.multidb.controller;

import com.jinny.java.springboot.multidb.service.CommonService;
import com.jinny.java.springboot.multidb.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @Autowired
    private CommonService commonService;

    @GetMapping(path="/async/{name}", produces = "application/json")
    public ResponseEntity<Object> asyncTest(@PathVariable("name") String name) {
        try{

            for (int i = 0; i < 10; i++) {
                testService.asyncTest(name + i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(path="/async2/{name}", produces = "application/json")
    public ResponseEntity<Object> asyncTest2(@PathVariable("name") String name) {
        try{

            commonService.asyncTest(name);


            double a = 5.3;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(path="/emoji/insert", produces = "application/json")
    public ResponseEntity<Object> insertEmoji(HttpServletRequest request) {
        try{

            request.getParameter("tourneyId");
            HashMap paramMap = new HashMap<>();
            paramMap.put("tourneyId", request.getParameter("tourneyId").toString());
            paramMap.put("name", "\uD83C\uDDF9\uD83C\uDDED");
            commonService.insertEmoji(paramMap);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(path="/emoji/select", produces = "application/json")
    public ResponseEntity<Object> selectEmoji(HttpServletRequest request) {
        try{

            request.getParameter("tourneyId");
            HashMap paramMap = new HashMap<>();
            paramMap.put("tourneyId", request.getParameter("tourneyId").toString());
            String name = commonService.selectEmoji(paramMap);
            System.out.println(name);
            paramMap.put("tourneyId", request.getParameter("tourneyId").toString() + "_in");
            paramMap.put("name", name);
            commonService.insertEmoji(paramMap);



        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
