package springboot.sample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springboot.sample.exception.InternalErrorException;
import springboot.sample.exception.MemberValidationException;

@RestController
public class TestController {

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


}
