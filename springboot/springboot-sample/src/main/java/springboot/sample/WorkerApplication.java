package springboot.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WorkerApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WorkerApplication.class);
        application.addListeners(new ApplicationPidFileWriter());   // pid file 생성
        application.run(args);
    }
}