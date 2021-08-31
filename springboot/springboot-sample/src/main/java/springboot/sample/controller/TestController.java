package springboot.sample.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springboot.sample.exception.InternalErrorException;
import springboot.sample.exception.InvalidParamException;
import springboot.sample.exception.MemberValidationException;
import springboot.sample.service.AsyncService;
import springboot.sample.service.TestService;

@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private TestService testService;

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

    @ApiOperation(value = "[Sync]sleep void 스레드 생성", notes = "지정한 초 만큼 sleep 스레드를 생성합니다. ")
    @GetMapping(value = "/test/sleep/void/{second}")
    public ResponseEntity<Object> sleepVoidTest(@PathVariable Integer second) {

        if (second > 0) {
           testService.sleepVoidTest(second);
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @ApiOperation(value = "[Sync]sleep response 스레드 생성", notes = "지정한 초 만큼 sleep 스레드를 생성합니다. ")
    @GetMapping(value = "/test/sleep/response/{second}")
    public ResponseEntity<Object> sleepResponseTest(@PathVariable Integer second) {

        String result = null;
        if (second > 0) {
            result = testService.sleepResponseTest(second);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @ApiOperation(value = "[ASync]sleep 비동기 응답 스레드 ", notes = "지정한 초 만큼 sleep 스레드를 생성합니다. (비동)")
    @GetMapping(value = "/test/sleep/async/{second}")
    public ResponseEntity<Object> sleepAsyncTest(@PathVariable Integer second) {

        String result = null;

        if (second > 0) {
            result = asyncService.sleepAsyncTest(second);
            log.info("async 보낸 후 처리중 . . . ");
        } else {
            throw new InvalidParamException("second need to be more than 0");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 비동기 로직 실행시, 비동기 로직이 종료되지 않더라도 응답이 바로 처리됨
     * @param second
     * @return
     */
    @ApiOperation(value = "[ASync]sleep 비동기 void 스레드 ", notes = "지정한 초 만큼 sleep 스레드를 생성합니다. (비동)")
    @GetMapping(value = "/test/sleep/async2/{second}")
    public ResponseEntity<Object> sleepAsyncTest2(@PathVariable Integer second) {

        if (second > 0) {
            asyncService.sleepAsyncTest2(second);
            log.info("async 보낸 후 처리중 . . . ");
        } else {
            throw new InvalidParamException("second need to be more than 0");
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }




}
