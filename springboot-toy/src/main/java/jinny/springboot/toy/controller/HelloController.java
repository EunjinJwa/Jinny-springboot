package jinny.springboot.toy.controller;

import jinny.springboot.toy.service.CachedDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final CachedDateService cachedDateService;

    @GetMapping
    public ResponseEntity<String> hello() {
        String result = cachedDateService.getCachedTestData(1);
        cachedDateService.getCachedTestData(2);
        cachedDateService.getCachedTestData(3);
        cachedDateService.getCachedTestData(4);
        cachedDateService.getCachedTestData(5);
        cachedDateService.getCachedTestData(6);
        cachedDateService.getCachedTestData(7);
        cachedDateService.getCachedTestData(8);
        cachedDateService.getCachedTestData(9);
        cachedDateService.getCachedTestData(10);
        cachedDateService.getCachedTestData(11);
        cachedDateService.getCachedTestData(12);
        cachedDateService.getCachedTestData(13);
        cachedDateService.getCachedTestData(14);
        cachedDateService.getCachedTestData(15);

        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}
