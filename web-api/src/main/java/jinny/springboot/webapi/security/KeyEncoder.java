package jinny.springboot.webapi.security;

import java.util.Base64;

public class KeyEncoder {

    public static String base64Encode (String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    public static String base64Decode (String encodedStr) {
        return new String(Base64.getDecoder().decode(encodedStr));
    }
}
