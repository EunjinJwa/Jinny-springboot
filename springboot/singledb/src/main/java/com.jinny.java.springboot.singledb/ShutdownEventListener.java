//package com.jinny.java.springboot.singledb;
//
//import org.apache.catalina.connector.Connector;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextClosedEvent;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.ThreadPoolExecutor;
//
//
//@Component
//public class ShutdownEventListener implements ApplicationListener<ContextClosedEvent> {
//
//    private static final Logger log = LoggerFactory.getLogger(ShutdownEventListener.class);
//
//    private static final int TIMEOUT = 30;
//
//
//    @Override
//    public void onApplicationEvent(ContextClosedEvent event) {
//        System.out.println("call ShutdownEventListener !! ");
//
//
//        try {
//
//            if(!Thread.currentThread().isInterrupted()) {
//                System.out.println("stop wait --- ");
//                Thread.sleep(30000);
//            }
//
//                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
//
//
//                threadPoolExecutor.shutdown();
//                if (!threadPoolExecutor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
//                    log.warn("Tomcat thread pool did not shut down gracefully within "
//                            + TIMEOUT + " seconds. Proceeding with forceful shutdown");
//
//                    threadPoolExecutor.shutdownNow();
//
//                    if (!threadPoolExecutor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
//                        log.error("Tomcat thread pool did not terminate");
//                    }
//                }
//            } catch (InterruptedException ex) {
//                Thread.currentThread().interrupt();
//            }
//
//    }
//
//}
//
//
