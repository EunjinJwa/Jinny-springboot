package springboot.sample.scheduler;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.SchedulingException;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;
import springboot.sample.exception.CustomErrorCode;
import springboot.sample.exception.SchedulerException;
import springboot.sample.service.TestService1;
import springboot.sample.type.Constants.*;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.function.Consumer;

@Service
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    Gson gson = new Gson();

    private Map<SchedulerType, ScheduledFuture<?>> scheduledTasks = new ConcurrentHashMap<>();

    @Autowired
    private TaskScheduler taskScheduler;

    @Autowired
    private TestService1 testService1;

    public void startBatchTest(SchedulerType scheduleId) {
        ScheduledFuture<?> task = null;
        Consumer<String> consum;

        if (scheduledTasks.containsKey(scheduleId)) {
            log.info("이미 실행중인 scheduler입니다. {}", scheduleId);
            throw new SchedulerException(scheduleId.toString(), CustomErrorCode.ALREADY_RUNNING);
        } else {
            log.info("startBatchTest {}", scheduleId);
            switch (scheduleId) {
                case TEST1:
                    task = taskScheduler.scheduleAtFixedRate(testService1::batchTest1,2000);
                    break;
                case TEST2:
                    task = taskScheduler.scheduleAtFixedRate(testService1::batchTest2,2500);
                    break;
                case TEST3:
                    task = taskScheduler.scheduleAtFixedRate(testService1::batchTest3,2000);
                    break;
            }
            if (task != null) {
                scheduledTasks.put(scheduleId, task);
            } else {
                log.info("지원하지 않는 scheduler입니다. {}", scheduleId);
                throw new SchedulerException(scheduleId.toString(), CustomErrorCode.INVALID_REQUEST);
            }

        }
    }


    public void stopBatch(SchedulerType scheduleId) {
        if (scheduledTasks.containsKey(scheduleId)) {
            log.info(scheduleId+"를 종료합니다.");
            scheduledTasks.get(scheduleId).cancel(true);
            scheduledTasks.remove(scheduleId);
        } else {
            log.info("실행되지 않는 scheduler입니다. {}", scheduleId);
            throw new SchedulerException(scheduleId.toString(), CustomErrorCode.NOT_RUNNING);
        }

    }


    public String getScheduledTasks() {
        return gson.toJson(scheduledTasks);
    }
}
