package jinny.springboot.practice.security.apikey;

import org.junit.Test;

class APIKeyTest {

    private APIKeyGenerator apiKeyGenerator = new APIKeyGenerator();

    @Test
    void createAPIKey() {
        String key = apiKeyGenerator.genertateAPIKey("Client");
        System.out.println(key);
    }
}