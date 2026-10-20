
import java.math.BigInteger;
import java.util.Scanner;

public class DiffieHellman {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Diffie-Hellman Key Exchange =====");

        // Public parameters
        BigInteger p = BigInteger.valueOf(23);
        BigInteger g = BigInteger.valueOf(5);

        System.out.println("Public Prime (p)     : " + p);
        System.out.println("Public Generator (g)  : " + g);

        // Input private keys
        System.out.print("\nEnter Alice's private key: ");
        BigInteger a = sc.nextBigInteger();

        System.out.print("Enter Bob's private key: ");
        BigInteger b = sc.nextBigInteger();

        // Validate private keys
        if (a.signum() <= 0 || b.signum() <= 0) {
            System.out.println("Private keys must be positive numbers.");
            sc.close();
            return;
        }

        // Alice calculates her public key
        BigInteger A = g.modPow(a, p);

        // Bob calculates his public key
        BigInteger B = g.modPow(b, p);

        System.out.println("\n===== Public Key Exchange =====");
        System.out.println("Alice's Public Key : " + A);
        System.out.println("Bob's Public Key   : " + B);

        // Calculate shared secrets
        BigInteger secretAlice = B.modPow(a, p);
        BigInteger secretBob = A.modPow(b, p);

        System.out.println("\n===== Shared Secret =====");
        System.out.println("Alice's Shared Secret : " + secretAlice);
        System.out.println("Bob's Shared Secret   : " + secretBob);

        // Verify shared secrets
        if (secretAlice.equals(secretBob)) {
            System.out.println("\nKey Exchange Successful!");
            System.out.println(
                "Both parties have established the same shared secret."
            );
        } else {
            System.out.println("\nKey Exchange Failed!");
        }

        sc.close();
    }
}
