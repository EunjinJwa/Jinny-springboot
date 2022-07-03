package jinny.springboot.toy.scheduler;

import jinny.springboot.toy.service.CachedDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@RequiredArgsConstructor
public class SchedulerRunner {

    private final CachedDateService cachedDateService;

    @Scheduled(cron = "0 0 0 * * *")
    public void testScheduler() {
        cachedDateService.testDateSachEvict();
    }
}
