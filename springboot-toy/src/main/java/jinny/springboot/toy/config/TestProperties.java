package jinny.springboot.toy.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestProperties {

    public static String value1;
    @Value("${test.value2}")
    public String value2;
    public static String value3;

    @Value("${test.value1}")
    public static void setValue1 (String value1) {
        value1 = value1;
    }

    public void setValue2 (String value2) {
        this.value2 = value2;
    }

    @Value("${test.value3}")
    public static void setValue3 (String value3) {
        value3 = value3;
    }
}
