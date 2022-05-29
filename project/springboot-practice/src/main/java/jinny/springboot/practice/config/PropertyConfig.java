package jinny.springboot.practice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("practice")
@Getter
@Setter
public class PropertyConfig {

    private PropertyHttpType http;

}

