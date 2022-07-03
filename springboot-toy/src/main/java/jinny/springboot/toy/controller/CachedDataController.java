package jinny.springboot.toy.controller;

import jinny.springboot.toy.service.CachedDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CachedDataController {

    private final CachedDateService cachedDateService;

    @GetMapping(value = "/cached/delete")
    public void getCachedDate() {
        cachedDateService.testDateSachEvict();
    }
}
