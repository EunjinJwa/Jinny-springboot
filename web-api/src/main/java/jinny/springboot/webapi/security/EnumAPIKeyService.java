package jinny.springboot.webapi.security;

import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

@Service
public class EnumAPIKeyService implements APIKeyService {

    @Override
    public String genAccessKey (ClientId clientId) {
        switch (clientId) {
            case TEST:
                return generateRandomUUIDKey();
            default:
                return generateSecretKey();
        }
    }

    @Override
    public ClientId getClientIdByAccessKey (String apiKey) {
        return ClientKey.getClientIdByAsccessKey(apiKey);
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
