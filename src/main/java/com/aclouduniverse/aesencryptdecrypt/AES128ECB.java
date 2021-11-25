package com.aclouduniverse.aesencryptdecrypt;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Hex;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/**
 * Author Lalit Kumar
 * AES128ECB MYSQL COMPATIBLE AES ENCRYPTION / DECRYPTION IN JAVA
 */
public class AES128ECB {
    public static SecretKeySpec generateMySQLAESKey(final String key, final String encoding) {
        try {
            final byte[] finalKey = new byte[16];
            int i = 0;
            for(byte b : key.getBytes(encoding))
                finalKey[i++%16] ^= b;
            return new SecretKeySpec(finalKey, "AES");
        } catch(UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String... args) throws Exception {
        // Decrypt
        final Cipher decryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        decryptCipher.init(Cipher.DECRYPT_MODE, generateMySQLAESKey("MySecretKey", "UTF-8"));
        System.out.println(new String(decryptCipher.doFinal(Hex.decodeHex("af0cc3b6fe1cbc9d86df570a40e7e8b1".toCharArray()))));
        // Encrypt
        final Cipher encryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        encryptCipher.init(Cipher.ENCRYPT_MODE, generateMySQLAESKey("MySecretKey", "UTF-8"));
        System.out.println(String.format("Select aes_decrypt(unhex('%s'), 'MySecretKey');", new String(Hex.encodeHex(encryptCipher.doFinal("Lalit Kumar".getBytes("UTF-8"))))));
    }
}
