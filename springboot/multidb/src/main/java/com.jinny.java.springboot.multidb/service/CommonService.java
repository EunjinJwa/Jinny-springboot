package com.jinny.java.springboot.multidb.service;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service
public class CommonService {

    @Autowired
    private TestService testService;

    public void asyncTest(String name) throws Exception {

        for (int i = 0; i < 10; i++) {
            testService.asyncTest(name + " >> " + i);

        }

    }
}
