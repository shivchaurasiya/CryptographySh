
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Scanner;

public class AESHash {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text message: ");
        String message = sc.nextLine();

        // Generate AES secret key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey key = keyGen.generateKey();

        // AES Encryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encrypted = cipher.doFinal(
                message.getBytes(StandardCharsets.UTF_8));

        String encryptedText = Base64.getEncoder()
                .encodeToString(encrypted);

        // SHA-256 Hashing
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(
                message.getBytes(StandardCharsets.UTF_8));

        StringBuilder hashText = new StringBuilder();
        for (byte b : hash) {
            hashText.append(String.format("%02x", b & 0xff));
        }

        // AES Decryption
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(encrypted);

        String decryptedText = new String(
                decrypted, StandardCharsets.UTF_8);

        System.out.println("\nEncrypted Message: " + encryptedText);
        System.out.println("SHA-256 Hash: " + hashText);
        System.out.println("Decrypted Message: " + decryptedText);
        System.out.println("Message Recovered: "
                + message.equals(decryptedText));

        sc.close();
    }
}
