package jinny.springboot.webapi.security;

import org.assertj.core.api.Assertions;
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

    @Test
    void decodeApiKey() {
        String apiKey = "VEVTVDoxNDc3ZDczNzBjMzk0NjQ3OWU1MDZmMDgyNjhkZTRhNQ==";
        ClientId clientId = apiKeyGenerator.getClientIdByApiKey(apiKey);

        Assertions.assertThat(clientId).isEqualTo(ClientId.TEST);
    }

    @Test
    void decodeApiKeyTest() {
        String apiKey = "UlJSUlI6MTQ3N2Q3MzcwYzM5NDY0NzllNTA2ZjA4MjY4ZGU0YTU=";
        ClientId clientId = apiKeyGenerator.getClientIdByApiKey(apiKey);

        Assertions.assertThat(clientId).isEqualTo(ClientId.NONE);
    }



}