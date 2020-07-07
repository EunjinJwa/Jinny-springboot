package com.jinny.java.springboot.multidb.config;

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

        private static final int MAX_POOL_SIZE = 5;
        private static final int CORE_POOL_SIZE = 5;
//        private static final int QUEUE_CAPACITY = 1;

        @Nullable
        @Override
        public Executor getAsyncExecutor() {
                ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
                threadPoolTaskExecutor.setCorePoolSize(CORE_POOL_SIZE);
                threadPoolTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
                //              threadPoolTaskExecutor.setQueueCapacity(QUEUE_CAPACITY);
                threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
                threadPoolTaskExecutor.setThreadNamePrefix("worker-pool");
                threadPoolTaskExecutor.initialize();
                return threadPoolTaskExecutor;
        }
}