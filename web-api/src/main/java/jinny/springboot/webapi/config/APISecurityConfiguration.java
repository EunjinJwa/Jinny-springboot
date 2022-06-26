package jinny.springboot.webapi.config;

import jinny.springboot.webapi.security.APIKeyService;
import jinny.springboot.webapi.security.ClientId;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@RequiredArgsConstructor
public class APISecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final String principalRequestHeader = "Authorization";

    private final APIKeyService apiKeyService;

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        APIKeyAuthFilter filter = new APIKeyAuthFilter(principalRequestHeader);
        filter.setAuthenticationManager(authentication -> {
            String principal = (String) authentication.getPrincipal();  // header 값
            ClientId clientId = apiKeyService.getClientIdByAccessKey(principal);
            if (clientId == ClientId.NONE) {
                throw new BadCredentialsException("The API key was not found or not invalid value.");
            }
            authentication.setAuthenticated(true);
            return authentication;
        });

        http.cors().disable()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(filter)
                .authorizeRequests()
                .antMatchers("/index")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().disable();
    }

}
