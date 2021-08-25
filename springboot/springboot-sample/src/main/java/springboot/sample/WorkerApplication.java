package springboot.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WorkerApplication extends SpringBootServletInitializer {

    /**
     * springboot 외장 톰캣 사용시 SpringBootServletInitializer 를 extend 받아서 사용해야 함
     * @param application
     * @return
     */
    @Override protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WorkerApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WorkerApplication.class);
        application.addListeners(new ApplicationPidFileWriter());   // pid file 생성
        application.run(args);
    }
}
