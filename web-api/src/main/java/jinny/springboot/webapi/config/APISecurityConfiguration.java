package jinny.springboot.webapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class APISecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final String principalRequestHeader = "Authorization";

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        APIKeyAuthFilter keyFilter = new APIKeyAuthFilter(principalRequestHeader);
    }
}
