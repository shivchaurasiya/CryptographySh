
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class PasswordHashing {

    static String hash(String text) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] result = md.digest(text.getBytes(StandardCharsets.UTF_8));

        StringBuilder hex = new StringBuilder();
        for (byte b : result) {
            hex.append(String.format("%02x", b & 0xff));
        }
        return hex.toString();
    }

    static String toHex(byte[] data) {
        StringBuilder hex = new StringBuilder();
        for (byte b : data) {
            hex.append(String.format("%02x", b & 0xff));
        }
        return hex.toString();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        // Hash without salt
        String hashWithoutSalt = hash(password);

        // Generate a random salt
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);

        // Hash password with salt
        String hashWithSalt = hash(
                toHex(salt) + password
        );

        System.out.println("\n===== Without Salting =====");
        System.out.println("Password Hash: " + hashWithoutSalt);

        System.out.println("\n===== With Salting =====");
        System.out.println("Salt: " + toHex(salt));
        System.out.println("Salted Hash: " + hashWithSalt);

        System.out.println("\n===== Security Comparison =====");
        System.out.println("Same password gives same unsalted hash.");
        System.out.println("Random salt makes the salted hash different.");
        System.out.println("Salting improves resistance to rainbow-table attacks.");

        sc.close();
    }
}
