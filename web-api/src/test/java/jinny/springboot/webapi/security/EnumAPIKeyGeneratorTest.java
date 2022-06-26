package jinny.springboot.webapi.security;

import org.junit.jupiter.api.Test;

class EnumAPIKeyGeneratorTest {

    private APIKeyGenerator apiKeyGenerator = new EnumAPIKeyGenerator();

    @Test
    void apiKeyGeneratorTest() {
        String apiKey = apiKeyGenerator.genBasicApiKey(ClientId.TEST);
        System.out.println(apiKey);
    }

    @Test
    void generateSecretKey_TEST() {
        String result = apiKeyGenerator.genSecretKey(ClientId.TEST);
        System.out.println(result);
    }

    @Test
    void generateSecretKey_Default() {
        String result = apiKeyGenerator.genSecretKey(ClientId.WEB_FRONT);
        System.out.println(result);
    }

}