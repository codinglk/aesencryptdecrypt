# aesencryptdecrypt
AES Encryption / Decryption in Java

AES128CBCInitVector.java - You can use this file for MYSQL COMPATIBLE AES128CBC ENCRYPTION / DECRYPTION IN JAVA

You can encrypt the string in Java by calling encrypt() method which is available in AES128CBCInitVector.java and you can decrypt the encrypted string in MYSQL using the same secret key and init vector. You also can encrypt string in MYSQL and decrypt in Java.

MySQL has an aes_encrypt/aes_decrypt pair of functions (Encryption and Compression Functions) that enable encryption and decryption of data using the official AES algorithm.

MYSQL Commands for AES-128-CBC:

mysql> SET block_encryption_mode = 'aes-256-cbc';

mysql> SET @key_str = 'Same-Key-Mentioned-In-File';

mysql> SET @init_vector = 'Same-Vector-Value-Mentioned-In-File'

mysql> SELECT AES_DECRYPT(unhex('ENCRYPTED-STRING'),@key_str, @init_vector)

mysql> SELECT hex(AES_ENCRYPT('VALUE-TO-BE-ENCRYPTED',@key_str, @init_vector))


AES128ECB.java - You can use this file for MYSQL COMPATIBLE AES128ECB ENCRYPTION / DECRYPTION IN JAVA

MYSQL Commands for AES-128-ECB: Use the above commands mentioned for CBC and you do not need to use the init vector for ECB.

For MYSQL COMPATIBLE AES128ECB ENCRYPTION / DECRYPTION IN JAVA, you can have a look https://info.michael-simons.eu/2011/07/18/mysql-compatible-aes-encryption-decryption-in-java/

AES256.java - You can use this file for AES256 ENCRYPTION / DECRYPTION IN JAVA. This code is not compatible for MYSQL.

Thank You!
