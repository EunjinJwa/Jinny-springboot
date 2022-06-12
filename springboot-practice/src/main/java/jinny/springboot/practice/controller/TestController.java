package jinny.springboot.practice.controller;

import jinny.springboot.practice.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping(path = "/test")
    public String test() {
        return "call test!!";
    }

    @GetMapping(path = "/v1/signin")
    public String createToken(@RequestParam String name) {
        return jwtTokenProvider.createToken(name, Arrays.asList("USER"));
    }
}
