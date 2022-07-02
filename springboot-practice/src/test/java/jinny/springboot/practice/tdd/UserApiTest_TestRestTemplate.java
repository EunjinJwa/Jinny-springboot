package jinny.springboot.practice.tdd;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@RunWith(SpringRunner.class)
public class UserApiTest_TestRestTemplate {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void weakPwResponse() {
        String reqBody = "{\"id\":\"123\",\"pw\":\"111\"}";
        RequestEntity<String> request = RequestEntity.post(URI.create("/hello/bad-request"))
                .contentType(MediaType.APPLICATION_JSON)
                .body(reqBody);

        ResponseEntity<String> response = restTemplate.exchange(request, String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
    }
}
