package springboot.sample.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class AsyncThreadConfiguration implements AsyncConfigurer {

//    @Value("${thread.max-pool-size}")
    private int MAX_POOL_SIZE=20;
//    @Value("${thread.core-pool-size}")
    private int CORE_POOL_SIZE=5;
//    @Value("${thread.queue-capacity}")
    private int QUEUE_CAPACITY=5;

    @Nullable
    @Override
    @Bean(name = "batchExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        threadPoolTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        threadPoolTaskExecutor.setQueueCapacity(QUEUE_CAPACITY);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.setThreadNamePrefix("asyncthread-pool");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}