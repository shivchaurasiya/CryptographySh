
import java.math.BigInteger;
import java.util.Scanner;

public class RSA {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: Choose two prime numbers
        BigInteger p = BigInteger.valueOf(61);
        BigInteger q = BigInteger.valueOf(53);

        // Step 2: Calculate n = p * q
        BigInteger n = p.multiply(q);

        // Step 3: Calculate phi(n)
        BigInteger phi = p.subtract(BigInteger.ONE)
                .multiply(q.subtract(BigInteger.ONE));

        // Step 4: Choose public exponent e
        BigInteger e = BigInteger.valueOf(17);

        // Step 5: Calculate private exponent d
        BigInteger d = e.modInverse(phi);

        // Display RSA keys
        System.out.println("===== RSA Key Generation =====");
        System.out.println("p = " + p);
        System.out.println("q = " + q);
        System.out.println("n = " + n);
        System.out.println("phi(n) = " + phi);

        System.out.println("\nPublic Key  = (" + e + ", " + n + ")");
        System.out.println("Private Key = (" + d + ", " + n + ")");

        // Input numerical message
        System.out.print("\nEnter a numerical message (less than "
                + n + "): ");
        BigInteger message = sc.nextBigInteger();

        // Validate message
        if (message.signum() < 0 || message.compareTo(n) >= 0) {
            System.out.println("Error: Message must be between 0 and "
                    + (n.subtract(BigInteger.ONE)) + ".");
            sc.close();
            return;
        }

        // Step 6: Encryption
        BigInteger ciphertext = message.modPow(e, n);

        // Step 7: Decryption
        BigInteger decryptedMessage = ciphertext.modPow(d, n);

        // Display results
        System.out.println("\n===== RSA Encryption =====");
        System.out.println("Original Message  : " + message);
        System.out.println("Encrypted Message : " + ciphertext);
        System.out.println("Decrypted Message : " + decryptedMessage);

        System.out.println("\nRSA Successful: "
                + message.equals(decryptedMessage));

        sc.close();
    }
}
