package jinny.springboot.webapi.security;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

public class APIKeyGenerator {

    private ClientKey clientKey;

    public APIKeyGenerator (ClientId clientId) {
        this.clientKey = ClientKey.getClientKey(clientId);
    }

    public String genBasicApiKey () {
        return KeyEncoder.base64Encode(clientKey.getClientKeyToString());
    }

    public String genSecretKey() {
        switch (this.clientKey.getClientId()) {
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
