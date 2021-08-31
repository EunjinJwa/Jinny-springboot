package springboot.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async
public class AsyncService {
    private static final Logger log = LoggerFactory.getLogger(AsyncService.class);

    public String sleepAsyncTest(Integer second) {
        for (int i = 0; i <= second; i++) {
            log.info("sleepTest...{}", i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Good";
    }


    public void sleepAsyncTest2(Integer second) {
        for (int i = 0; i <= second; i++) {
            log.info("sleepTest...{}", i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
