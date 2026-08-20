import java.util.*;

public class VigenereCipher {

    static String encrypt(String text, String key) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "");
        key = key.toUpperCase().replaceAll("[^A-Z]", "");

        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int p = text.charAt(i) - 'A';
            int k = key.charAt(i % key.length()) - 'A';

            int c = (p + k) % 26;

            cipher.append((char) (c + 'A'));
        }

        return cipher.toString();
    }

    static String decrypt(String cipher, String key) {
        StringBuilder plain = new StringBuilder();

        for (int i = 0; i < cipher.length(); i++) {
            int c = cipher.charAt(i) - 'A';
            int k = key.charAt(i % key.length()) - 'A';

            int p = (c - k + 26) % 26;

            plain.append((char) (p + 'A'));
        }

        return plain.toString();
    }

    public static void main(String[] args) {

        String plaintext = "TOBEORNOTTOBETHATISTHEQUESTION";
        String key = "RELATIONS";

        String ciphertext = encrypt(plaintext, key);

        System.out.println("Plaintext  : " + plaintext);
        System.out.println("Key        : " + key);
        System.out.println("Ciphertext : " + ciphertext);

        System.out.println("Decrypted  : " + decrypt(ciphertext, key));
    }
}
