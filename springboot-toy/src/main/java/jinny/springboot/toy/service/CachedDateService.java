package jinny.springboot.toy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CachedDateService {

    @CacheEvict(value = "testDataLoead", allEntries = true)
    public void testDateSachEvict() {
        System.out.println("run testDateSachEvict");
    }

    @Cacheable(value = "testDataLoead")
    @Async
    public String getCachedTestData(int num) {
        return genTestData(num);
    }


    public String genTestData(int num) {
        System.out.println("run genTestData : " + num);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s = "Current Time : " + LocalDateTime.now();
        return s;
    }
}
