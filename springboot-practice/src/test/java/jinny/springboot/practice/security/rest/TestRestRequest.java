package jinny.springboot.practice.security.rest;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestRestRequest {

    RestTemplate restTemplate;

    @Test
    public void testRestTemplate () {
        String apiUrl = "localhost:1234/hello";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        List<String> params = Stream.of("test1", "test2", "test3").collect(Collectors.toList());

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("ppppp", params);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);
        System.out.println("body : " + request.getBody());

        HttpEntity<List<String>> request2 = new HttpEntity<>(params, headers);
        System.out.println("body1 : " + request2.getBody());

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl);

        try {
            restTemplate.postForEntity(builder.toUriString(), request, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
