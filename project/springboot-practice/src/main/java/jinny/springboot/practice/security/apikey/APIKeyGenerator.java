package jinny.springboot.practice.security.apikey;

import java.util.Base64;
import java.util.UUID;

public class APIKeyGenerator {

    public String genertateAPIKey(String userKey) {
        String secretKey = UUID.randomUUID().toString().replace("-","");
        return Base64.getEncoder().encodeToString(userKey.concat(secretKey).getBytes());
    }

}
