package jinny.springboot.webapi.security;

public interface APIKeyService {

    String genAccessKey (ClientId clientId);

    ClientId getClientIdByAccessKey (String apiKey);
}
