package com.aclouduniverse.aesencryptdecrypt;

/**
 * Author Lalit Kumar
 * AES256 ENCRYPTION / DECRYPTION Example IN JAVA
 */
public class AES256Example {
    public static void main(String[] args) {
        String originalString = "TEST-2";

        String encryptedString = AES256.encrypt(originalString);
        String decryptedString = AES256.decrypt(encryptedString);

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }
}
