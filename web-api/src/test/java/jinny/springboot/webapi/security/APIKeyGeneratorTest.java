package jinny.springboot.webapi.security;

import org.junit.jupiter.api.Test;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

class APIKeyGeneratorTest {

    APIKeyGenerator apiKeyGenerator = new APIKeyGenerator();

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
    void secretKeyGeneratorTest() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            String encodedKey = Base64.getEncoder().encodeToString(keyGenerator.generateKey().getEncoded());
            System.out.println("secretKey : " + encodedKey);

            String decoded = KeyEncoder.base64Decode("QLFJWBHFp3Uv6c98L3PnAg==");
            System.out.println(decoded);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


}