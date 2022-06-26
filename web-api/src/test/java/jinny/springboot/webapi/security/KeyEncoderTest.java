package jinny.springboot.webapi.security;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class KeyEncoderTest {

    @Test
    void base64Encoding_TEST () {
        String key = "TEST:1477d7370c3946479e506f08268de4a5";
        String result = KeyEncoder.base64Encode(key);

        Assertions.assertThat(result).isEqualTo("VEVTVDoxNDc3ZDczNzBjMzk0NjQ3OWU1MDZmMDgyNjhkZTRhNQ==");
    }

    @Test
    void base64Decoding_TEST() {
        String encodingStr = "VEVTVDoxNDc3ZDczNzBjMzk0NjQ3OWU1MDZmMDgyNjhkZTRhNQ==";
        String result = KeyEncoder.base64Decode(encodingStr);

        Assertions.assertThat(result).isEqualTo("TEST:1477d7370c3946479e506f08268de4a5");
    }

    @Test
    void base64Decoding () {
        String key = "VEVTVDoxNDc3ZDczNzBjMzk0NjQ3OWU1MDZmMDgyNjhkZTRhNQss";
        System.out.println(KeyEncoder.base64Decode(key));
    }


}