package jinny.springboot.practice.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    @Value("${practice.http.secretkey}")
    private String secretKey;
    private long tokenValidMillisecond = 60 * 60 * 1000L;   // 1단위로 토큰 만료 설정
    private final UserDetailsService userDetailsService;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    // JWT 토큰 생성
    public String createToken(String user, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(user);
        claims.put("roles", roles);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidMillisecond))     // set Expire Time
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // JWT 토큰 생성
    public String createTokenTest(String user, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(user);
        claims.put("roles", roles);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidMillisecond))     // set Expire Time
                .signWith(SignatureAlgorithm.PS256, secretKey)
                .compact();
    }

    // Request의 Header에서 token 파싱
    public String resolveToken(HttpServletRequest req) {
        return req.getHeader("Authorization");
    }

    /**
     * Jwt 토큰의 유효성 + 만료일자 확인
     * @param jwtToken
     * @return
     */
    public boolean validationToken(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            System.out.println("validation] claims.getBody().getExpiration() : " + claims.getBody().getExpiration());
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUser(token));
        System.out.println("userDetails name: " + userDetails.getUsername());
        System.out.println("userDetails auth: " + userDetails.getAuthorities());
        return new UsernamePasswordAuthenticationToken(null, "", userDetails.getAuthorities());
    }

    public String getUser(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }





}
