# aesencryptdecrypt
AES Encryption / Decryption in Java

AES128CBCInitVector.java - You can use this file for MYSQL COMPATIBLE AES128CBC ENCRYPTION / DECRYPTION IN JAVA

AES128ECB.java - You can use this file for MYSQL COMPATIBLE AES128ECB ENCRYPTION / DECRYPTION IN JAVA

You can encrypt the string in Java and you can decrypt the encrypted string in MYSQL using the same secret key and init vector and vice versa.

MySQL has an aes_encrypt/aes_decrypt pair of functions (Encryption and Compression Functions) that enable encryption and decryption of data using the official AES algorithm.

The functions are easy to use (select AES_ENCRYPT(‘text’,’password’)) and the result is easy to store (insert into secrets values HEX(AES_ENCRYPT(‘text’,’password’))) as hex values.

I used this technique for a while but i wanted to have a more database agnostic version of this encryption and tried to build the same methods with java.

Although it was relatively easy to find the exact cipher mode (which is AES/ECB/PKCS5Padding), i had a real hard time figuring out how the key is calculated from the given password (the key must be 16bytes long, per default MySql uses AES-128). It turns out that the MySQL algorithm just or’s the bytes of a given passphrase against the previous bytes if the password is longer than 16 chars and just leaves them 0 when the password is shorter than 16 chars. So you can generate a secret key spec in Java for an aes_encrypt/decrypt compatible cipher like so mentioned in file.

MYSQL Commands for AES-128-CBC:

mysql> SET block_encryption_mode = 'aes-256-cbc';
mysql> SET @key_str = 'Same-Key-Mentioned-In-File';
mysql> SET @init_vector = 'Same-Vector-Value-Mentioned-In-File'
mysql> SELECT AES_DECRYPT(unhex('ENCRYPTED-STRING'),@key_str, @init_vector)
mysql> SELECT hex(AES_ENCRYPT('VALUE-TO-BE-ENCRYPTED',@key_str, @init_vector))

MYSQL Commands for AES-128-ECB: Use the above commands and you do not need to use the init vector for ECB.


AES256.java - You can use this file for AES256 ENCRYPTION / DECRYPTION IN JAVA. This code is not compatible for MYSQL.



Thank You!
