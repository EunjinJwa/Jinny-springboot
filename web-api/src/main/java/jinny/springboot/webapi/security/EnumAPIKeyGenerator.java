package jinny.springboot.webapi.security;

import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

@Service
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

    @Override
    public ClientId getClientIdByApiKey (String apiKey) {
        try {
            return ClientId.valueOf(KeyEncoder.base64Decode(apiKey).split(":")[0]);
        } catch (IllegalArgumentException e) {
            return ClientId.NONE;
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
