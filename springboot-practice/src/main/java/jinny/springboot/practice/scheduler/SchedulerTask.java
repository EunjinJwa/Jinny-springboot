package jinny.springboot.practice.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerTask.class);

    @Scheduled(fixedDelay = 5000)
    public void job1() throws InterruptedException {
        LOGGER.info("run job 1");
        Thread.sleep(20000);
    }

    @Scheduled(fixedDelay = 5000)
    public void job2() throws InterruptedException {
        LOGGER.info("run job 2");
        Thread.sleep(3000);
    }

}
