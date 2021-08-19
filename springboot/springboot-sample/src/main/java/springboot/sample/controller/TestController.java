package springboot.sample.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springboot.sample.exception.InternalErrorException;
import springboot.sample.exception.MemberValidationException;

@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping(value = "/test")
    public ResponseEntity<Object> callTest() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


    @GetMapping(value = "/test/exception")
    public ResponseEntity<Object> exceptionTest() {

        try {
            String data = "";
            data = null;
            System.out.println(data.toString());
        } catch (Exception e) {
            throw new InternalErrorException("fail : " + e.getMessage());
        }

    return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping(value = "/test/validation/{type}")
    public ResponseEntity<Object> validationTest(@PathVariable Integer type) {

        if (type == 1) {
            // 이미 사용중인 정보입니다.
            throw new MemberValidationException("kassy");
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @ApiOperation(value = "sleep 스레드 생성", notes = "지정한 초 만큼 sleep 스레드를 생성합니다. ")
    @GetMapping(value = "/test/sleep/{second}")
    public ResponseEntity<Object> sleepTest(@PathVariable Integer second) {

        if (second > 0) {
            for (int i = 0; i <= second; i++) {
                log.info("sleepTest...{}", i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }




}
