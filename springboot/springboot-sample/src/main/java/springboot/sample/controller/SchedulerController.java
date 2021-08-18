package springboot.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.sample.scheduler.ScheduledTasks;
import springboot.sample.type.Constants.*;

@RestController
public class SchedulerController {

    @Autowired
    private ScheduledTasks scheduledTasks;

    @PostMapping(value = "/batch/start/{schedulerType}")
    public ResponseEntity<Object> startScheduler (@PathVariable SchedulerType schedulerType) {
        scheduledTasks.startBatchTest(schedulerType);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping(value = "/batch/stop/{schedulerType}")
    public ResponseEntity<Object> stopScheduler (@PathVariable SchedulerType schedulerType) {
        scheduledTasks.stopBatch(schedulerType);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping(value = "/batch")
    public ResponseEntity<Object> getScheduledTasks (){
        String result = scheduledTasks.getScheduledTasks();
        return new ResponseEntity<>(result, HttpStatus.OK);

    }


}
