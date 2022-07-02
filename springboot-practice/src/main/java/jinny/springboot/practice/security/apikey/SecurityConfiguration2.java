package jinny.springboot.practice.security.apikey;

import jinny.springboot.practice.config.PropertyConfig;
import jinny.springboot.practice.config.PropertyHttpType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Configuration
public class SecurityConfiguration2 extends WebSecurityConfigurerAdapter {

    @Value("${practice.http.auth-token-header.name}")
    private String principalRequestHeader;

//    @Value("${practice.http.auth-token}")
    private Set<String> principalRequestValues;

    private final PropertyConfig propertyConfig;

    protected void configure(HttpSecurity http) throws Exception {
        APIKeyAuthFilter filter = new APIKeyAuthFilter(principalRequestHeader);
        filter.setAuthenticationManager(authentication -> {
            String principal = (String) authentication.getPrincipal();
            System.out.println(propertyConfig.getHttp());

            if(!propertyConfig.getHttp().getAuthToken().contains(principal)) {
                throw new BadCredentialsException("The API key was not found or not the expected value.");
            }

            authentication.setAuthenticated(true);
            return authentication;
        });

        http.cors().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(filter)
                .authorizeRequests()
                .anyRequest().permitAll()
//                .authenticated()
                .and()
                .formLogin().disable();

    }
}
