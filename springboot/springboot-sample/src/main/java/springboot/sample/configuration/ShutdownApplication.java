//package springboot.sample.configuration;
//import org.apache.catalina.connector.Connector;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextClosedEvent;
//
//import java.util.concurrent.Executor;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//public class ShutdownApplication implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {
//
//    private static final Logger log = LoggerFactory.getLogger(ShutdownApplication.class);
//
//    private static final int TIMEOUT = 30;
//
//    private volatile Connector connector;
//
//    @Override
//    public void customize(Connector connector) {
//        this.connector = connector;
//    }
//
//    @Override
//    public void onApplicationEvent(ContextClosedEvent event) {
//        this.connector.pause();
//        Executor executor = this.connector.getProtocolHandler().getExecutor();
//        if (executor instanceof ThreadPoolExecutor) {
//            try {
//                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
//                log.info("* * * Application Shutdown. * * * ");
//                log.info("threadPoolExecutor.getActiveCount() : {}", threadPoolExecutor.getActiveCount());
//                log.info("threadPoolExecutor.getTaskCount() : {}",threadPoolExecutor.getTaskCount());
//
//                /**
//                 * 진행중인 스레드는 대기를 타고 종료를 시키나, 스케쥴러는 적용 안됨.
//                 */
//                threadPoolExecutor.shutdown();
//                if (!threadPoolExecutor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
//                    log.warn("* * * Tomcat thread pool did not shut down gracefully within "
//                            + TIMEOUT + " seconds. Proceeding with forceful shutdown");
//
//                    threadPoolExecutor.shutdownNow();
//
//                    if (!threadPoolExecutor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
//                        log.error("* * * Tomcat thread pool did not terminate");
//                    }
//                }
//            } catch (InterruptedException ex) {
//                Thread.currentThread().interrupt();
//            }
//        }
//    }
//}
