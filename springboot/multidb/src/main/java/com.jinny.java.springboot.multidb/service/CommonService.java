package com.jinny.java.springboot.multidb.service;

import com.jinny.java.springboot.multidb.mapper.denma.DenmaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CommonService {

    @Autowired
    private TestService testService;

    @Autowired
    private DenmaMapper denmaMapper;

    public void asyncTest(String name) throws Exception {

        for (int i = 0; i < 10; i++) {
            testService.asyncTest(name + " >> " + i);

        }

    }

    public void insertEmoji(HashMap paramMap) {
        denmaMapper.insertEmoji(paramMap);
    }

    public String selectEmoji(HashMap paramMap) {
        return denmaMapper.selectEmoji(paramMap);
    }
}
