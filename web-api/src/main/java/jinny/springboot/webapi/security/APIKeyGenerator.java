package jinny.springboot.webapi.security;

public interface APIKeyGenerator {

    String genBasicApiKey(ClientId clientId);

    String genSecretKey (ClientId clientId);

    ClientId getClientIdByApiKey (String apiKey);
}
