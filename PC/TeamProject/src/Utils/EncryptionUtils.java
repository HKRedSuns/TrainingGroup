package Utils;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * 加密工具类
 */
public class EncryptionUtils {
    //钥匙方法
    public static Map<String, Key> gen(){
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        HashMap<String, Key> map = new HashMap<>();
        map.put("pub", publicKey);
        map.put("pri", privateKey);
        return map;
    }
    /**
     * 加密
     */
    public static String encode(String content, Key pubKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");

        cipher.init(Cipher.ENCRYPT_MODE, pubKey);

        byte[] bytes = Base64.getEncoder().encode(cipher.doFinal(content.getBytes(StandardCharsets.UTF_8)));

        return new String(bytes);
    }

    /**
     * 解密
     */
    public static String decode(String content, Key priKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");

        cipher.init(Cipher.DECRYPT_MODE, priKey);

        byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(content.getBytes(StandardCharsets.UTF_8)));

        return new String(bytes);
    }
}
