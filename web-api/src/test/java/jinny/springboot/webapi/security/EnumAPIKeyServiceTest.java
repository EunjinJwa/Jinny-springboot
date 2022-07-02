package jinny.springboot.webapi.security;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EnumAPIKeyServiceTest {

    private APIKeyService apiKeyService = new EnumAPIKeyService();
    @Test
    void generateSecretKey_TEST() {
        String result = apiKeyService.genAccessKey(ClientId.TEST);
        System.out.println(result);
    }

    @Test
    void generateSecretKey_Default() {
        String result = apiKeyService.genAccessKey(ClientId.WEB_FRONT);
        System.out.println(result);
    }

    @Test
    void getClientIdByAccessKey() {
        String apiKey = "1477d7370c3946479e506f08268de4a5";
        ClientId clientId = apiKeyService.getClientIdByAccessKey(apiKey);

        Assertions.assertThat(clientId).isEqualTo(ClientId.TEST);
    }

}