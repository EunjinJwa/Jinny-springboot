package jinny.springboot.webapi.security;

import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

@Component
public class APIKeyGenerator {
    public String genBasicApiKey (ClientId clientId) {
        return KeyEncoder.base64Encode(ClientKey.getClientKeyToString(clientId));
    }

    public String genSecretKey(ClientId clientId) {
        switch (clientId) {
            case TEST:
                return generateRandomUUIDKey();
            default:
                return generateSecretKey();
        }
    }

    private String generateSecretKey () {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
            return Base64.getEncoder().encodeToString(keyGenerator.generateKey().getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateRandomUUIDKey() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
