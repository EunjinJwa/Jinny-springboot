package jinny.springboot.webapi.security;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

public class EnumAPIKeyGenerator implements APIKeyGenerator{

    @Override
    public String genBasicApiKey (ClientId clientId) {
        ClientKey clientKey = ClientKey.getClientKey(clientId);
        return KeyEncoder.base64Encode(clientKey.getClientKeyToString());
    }

    @Override
    public String genSecretKey(ClientId clientId) {
        ClientKey clientKey = ClientKey.getClientKey(clientId);
        switch (clientKey.getClientId()) {
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
