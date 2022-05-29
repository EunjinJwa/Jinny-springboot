package jinny.springboot.practice.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
//@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

//    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()      // rest api 이므로 기본설정 사용 안함. '기본설정'은 비인증시 로그인폼 화면으로 리다이렉트 된다.
                .csrf().disable()       // rest api 이므로 csft 보안이 필요없으므로 disable 처리.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt token으로 인증하므로 세션은 필요없음.
                .and()
                    .authorizeRequests()    // 다음 request에 대한 사용권한 체크
                    .antMatchers("/*/signin", "/*/signup").permitAll()      // 가입 및 인증 주소는 누구나 접근 가능
                    .antMatchers(HttpMethod.GET, "/hello/**").permitAll()     // hello/ 로 시작하는 GET 요청 리소스는 누구나 접근 가능
                    .anyRequest().hasRole("USER")   // 그외 나머지 요청은 모두 인증된 회원만 접근 가능
                .and()
                    .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);    // jwt token 필터릴 id/password 인증 필터 전에 넣는다.
    }

    /**
     * ignore check swagger resource
     * @param web
     */
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html", "/webjars/**", "/swagger/**");
    }

}
