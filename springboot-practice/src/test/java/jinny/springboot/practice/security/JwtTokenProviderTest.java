package jinny.springboot.practice.security;

import jinny.springboot.practice.CustomUserDetailService;
import jinny.springboot.practice.security.jwt.JwtTokenProvider;
import org.junit.Test;

import java.util.Arrays;
import java.util.Base64;

class JwtTokenProviderTest {

    JwtTokenProvider jwtTokenProvider = new JwtTokenProvider(new CustomUserDetailService());

    @Test
    public void createToken() {
        String token = jwtTokenProvider.createToken("Kassy", Arrays.asList("ROLE_USER"));
        System.out.println(token);
        String testToken = jwtTokenProvider.createToken("Kassy", Arrays.asList("ROLE_USER"));
        System.out.println(testToken);
    }

    @Test
    public void test() {
        String secretKey = "secretKey@#$";
        String encodingSecretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        System.out.println(encodingSecretKey);

    }
}