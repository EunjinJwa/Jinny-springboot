package springboot.sample.controller;

import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "start scheduler api", notes = "스케쥴러를 실행합니다.")
    @PostMapping(value = "/batch/start/{schedulerType}")
    public ResponseEntity<Object> startScheduler (@PathVariable SchedulerType schedulerType) {
        scheduledTasks.startBatchTest(schedulerType);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @ApiOperation(value = "stop scheduler api", notes = "스케쥴러를 종료합니다.")
    @PostMapping(value = "/batch/stop/{schedulerType}")
    public ResponseEntity<Object> stopScheduler (@PathVariable SchedulerType schedulerType) {
        scheduledTasks.stopBatch(schedulerType);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @ApiOperation(value = "get running scheduler", notes = "실행중인 스케쥴러를 확인합니다.")
    @GetMapping(value = "/batch")
    public ResponseEntity<Object> getScheduledTasks (){
        String result = scheduledTasks.getScheduledTasks();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
