package jinny.springboot.webapi.security;

import java.util.Arrays;

public enum ClientKey {

    _TEST(ClientId.TEST, "1477d7370c3946479e506f08268de4a5"),
    _WEB_FRONT(ClientId.WEB_FRONT, "6d51bcb94fe94db6b43b9b0af98c3eb7"),
    _EXTERNAL_SERVICE(ClientId.EXTERNAL_SERVICE, "0658c816cb2e437a87dcbcfe8766a957");

    private ClientId clientId;
    private String secretKey;

    ClientKey (ClientId clientId, String secretKey) {
        this.clientId = clientId;
        this.secretKey = secretKey;
    }

    public ClientId getClientId () {
        return this.clientId;
    }
    public String getClientKeyToString () {
        return this.clientId.toString().concat(":").concat(this.secretKey);
    }

    public static ClientKey getClientKey (ClientId clientId) {
        return Arrays.stream(ClientKey.values()).filter(c -> c.clientId.equals(clientId)).findFirst().get();
    }

}
