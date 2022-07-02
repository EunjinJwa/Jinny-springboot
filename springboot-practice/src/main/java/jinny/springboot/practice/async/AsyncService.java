package jinny.springboot.practice.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async("asyncExecute")
public class AsyncService {

    public void sleep(int index) throws InterruptedException {
        for (int i = 0; i < 15; i++) {
            System.out.println("sleep : ["+ index + "] " + i);
            Thread.sleep(1000);
        }
    }

}
