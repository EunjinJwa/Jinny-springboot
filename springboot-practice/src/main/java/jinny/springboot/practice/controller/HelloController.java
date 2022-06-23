package jinny.springboot.practice.controller;

import jinny.springboot.practice.async.HelloAsyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloAsyncService helloAsyncService;
    @GetMapping(path = "/hello")
    public String hello () {
        return "Hello !";
    }

    @GetMapping(value = "/hello/sleep")
    public String sleep() throws InterruptedException {
        for (int k = 0; k < 5; k++) {
            System.out.println("start [ "+k+" ] ==============");
            for (int i = 0; i < 10; i++) {
                helloAsyncService.sleep(i);
            }
            System.out.println("end [ "+k+" ] ==============");
        }


        return "end!";
    }
}
