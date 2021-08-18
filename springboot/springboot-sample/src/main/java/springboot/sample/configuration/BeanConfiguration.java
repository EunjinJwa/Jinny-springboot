package springboot.sample.configuration;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ShutdownApplication shutdownApplication() {
        return new ShutdownApplication();
    }

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory(final ShutdownApplication shutdownApplication) {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(shutdownApplication);
        return factory;
    }

}
