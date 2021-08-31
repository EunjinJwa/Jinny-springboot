package springboot.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private static final Logger log = LoggerFactory.getLogger(TestService.class);

    public void batchTest1() {
        log.info("start batchTest1");
        for (int i = 0 ; i < 10; i++) {
            try {
                log.info("... {}", i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        log.info("end batchTest1");
    }

    public void batchTest2(){
        log.info("run batchTest2");
    }

    public void batchTest3(){
        log.info("run batchTest3");
    }

    public void sleepVoidTest(int second) {
        for (int i = 0 ; i < second; i++) {
            try {
                log.info("... {}", i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("end sleeepTest");
    }

    public String sleepResponseTest(int second) {
        for (int i = 0 ; i < second; i++) {
            try {
                log.info("... {}", i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("end sleeepTest");
        return "Good! ";
    }
}
