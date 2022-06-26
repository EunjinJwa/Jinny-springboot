package jinny.springboot.webapi.security;

import org.junit.jupiter.api.Test;

class APIKeyGeneratorTest {


    @Test
    void apiKeyGeneratorTest() {
        String apiKey = new APIKeyGenerator(ClientId.TEST).genBasicApiKey();
        System.out.println(apiKey);
    }

    @Test
    void generateSecretKey_TEST() {
        String result = new APIKeyGenerator(ClientId.TEST).genSecretKey();
        System.out.println(result);
    }

    @Test
    void generateSecretKey_Default() {
        String result = new APIKeyGenerator(ClientId.WEB_FRONT).genSecretKey();
        System.out.println(result);
    }

}