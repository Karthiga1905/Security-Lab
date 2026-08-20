import java.util.Scanner;

public class CaesarCipher {

    static String encrypt(String text, int key) {
        String result = "";

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + key) % 26 + base);
            }
            result += ch;
        }

        return result;
    }

    static String decrypt(String text, int key) {
        return encrypt(text, 26 - key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter plaintext: ");
        String text = sc.nextLine();

        System.out.print("Enter key: ");
        int key = sc.nextInt();

        String cipher = encrypt(text, key);
        String plain = decrypt(cipher, key);

        System.out.println("Encrypted text: " + cipher);
        System.out.println("Decrypted text: " + plain);
    }
}
