package jinny.springboot.practice.security;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.SignatureDSA;
import org.junit.jupiter.api.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

public class SecurityEncodingTest {

    @Test
    public void base64Encoding() {
        String str = "31328f87da5d46ed99fcc4617f3925c0";
        String encodingStr = Base64.getEncoder().encodeToString(str.getBytes());
        System.out.println(encodingStr);
    }

    @Test
    public void base64Decoding() {
        String endocingStr = "MzEzMjhmODdkYTVkNDZlZDk5ZmNjNDYxN2YzOTI1YzA=";
        String decodingStr = new String(Base64.getDecoder().decode(endocingStr));
        System.out.println(decodingStr);
    }

    @Test
    public void genUUID() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-",""));
    }

    @Test
    public void sha256Encoding() {
        String secretKey = "kassy";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(secretKey.getBytes());

            System.out.println(bytesToHex(digest.digest()));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * Random한 암호화 키 생성
     * ex: e61111a5bd60f164394056d145cb5a20
     */
    @Test
    public void test() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();
            byte[] encoded = secretKey.getEncoded();
            String result = DatatypeConverter.printHexBinary(encoded).toLowerCase();
            System.out.println(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b: bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
