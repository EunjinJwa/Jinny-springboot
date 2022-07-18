package jinny.springboot.toy.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class TestProperties2 {

    @Value("${test.value1}")
    public String value1;
    @Value("${test.value2}")
    public String value2;

}
