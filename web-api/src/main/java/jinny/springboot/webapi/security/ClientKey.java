package jinny.springboot.webapi.security;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum ClientKey {

    _TEST(ClientId.TEST, "1477d7370c3946479e506f08268de4a5"),
    _ADMIN(ClientId.ADMIN, "Uh28dAo8rIGbDq3Xmh5E5w=="),
    _WEB_FRONT(ClientId.WEB_FRONT, "6d51bcb94fe94db6b43b9b0af98c3eb7"),
    _EXTERNAL_SERVICE(ClientId.EXTERNAL_SERVICE, "0658c816cb2e437a87dcbcfe8766a957");

    private ClientId clientId;
    private String accessKey;

    ClientKey (ClientId clientId, String accessKey) {
        this.clientId = clientId;
        this.accessKey = accessKey;
    }

    public ClientId getClientId () {
        return this.clientId;
    }

    public static ClientId getClientIdByAsccessKey (String accessKey) {
        try {
            return Arrays.stream(ClientKey.values()).filter(k -> k.accessKey.equals(accessKey)).findFirst().get().getClientId();
        } catch (NoSuchElementException e) {
            return ClientId.NONE;
        }
    }

    public static ClientKey getClientKey (ClientId clientId) {
        return Arrays.stream(ClientKey.values()).filter(c -> c.clientId.equals(clientId)).findFirst().get();
    }

}
