package com.aclouduniverse.aesencryptdecrypt;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;


/**
 * Author Lalit Kumar
 * AES128CBC MYSQL COMPATIBLE AES ENCRYPTION / DECRYPTION IN JAVA
 */
public class AES128CBCInitVector {
    private static final String key = "MySecretKeyMySecretKey";
    private static final String initVector = "MyInitVectorValu";
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

    public static IvParameterSpec generateIv() {
        //byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] iv = initVector.getBytes();
        // new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public static void main(String... args) throws Exception {

        System.out.println("Original Str - Lalit Kumar");
        String encryptedStr = encrypt("Lalit Kumar");
        System.out.println("encryptedStr - "+ encryptedStr);
        String decryptedStr = decrypt(encryptedStr);
        System.out.println("decryptedStr - "+ decryptedStr);

    }

    public static String encrypt(String value) {
        try{
            // Encrypt
            final Cipher encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            encryptCipher.init(Cipher.ENCRYPT_MODE, generateMySQLAESKey(key, "UTF-8"), generateIv());
            //  System.out.println(String.format("Decrypted Value - '%s'", new String(Hex.encodeHex(encryptCipher.doFinal(value.getBytes("UTF-8"))))));
            return new String(Hex.encodeHex(encryptCipher.doFinal(value.getBytes("UTF-8"))));
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String encrypted) {
        try{
            // Decrypt
            final Cipher decryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            decryptCipher.init(Cipher.DECRYPT_MODE, generateMySQLAESKey(key, "UTF-8"), generateIv());
            // System.out.println(new String(decryptCipher.doFinal(Hex.decodeHex(encrypted.toCharArray()))));
            return new String(decryptCipher.doFinal(Hex.decodeHex(encrypted.toCharArray())));
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
