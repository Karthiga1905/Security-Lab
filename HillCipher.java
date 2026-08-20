import java.util.Scanner;

class HillCipher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 2 x 2 key matrix
        int[][] key = {
            {3, 3},
            {2, 5}
        };

        // Inverse of key matrix modulo 26
        int[][] inverse = {
            {15, 17},
            {20, 9}
        };

        System.out.print("Enter plaintext: ");
        String text = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "");

        if (text.length() == 0) {
            System.out.println("Error: Please enter at least one letter.");
            sc.close();
            return;
        }

        // If length is odd, add X
        if (text.length() % 2 != 0) {
            text += "X";
        }

        // Encryption
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {

            int p1 = text.charAt(i) - 'A';
            int p2 = text.charAt(i + 1) - 'A';

            int c1 = (key[0][0] * p1 + key[0][1] * p2) % 26;
            int c2 = (key[1][0] * p1 + key[1][1] * p2) % 26;

            encrypted.append((char) (c1 + 'A'));
            encrypted.append((char) (c2 + 'A'));
        }

        System.out.println("Encrypted Text: " + encrypted);

        // Decryption
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < encrypted.length(); i += 2) {

            int c1 = encrypted.charAt(i) - 'A';
            int c2 = encrypted.charAt(i + 1) - 'A';

            int p1 = (inverse[0][0] * c1 +
                      inverse[0][1] * c2) % 26;

            int p2 = (inverse[1][0] * c1 +
                      inverse[1][1] * c2) % 26;

            decrypted.append((char) (p1 + 'A'));
            decrypted.append((char) (p2 + 'A'));
        }

        System.out.println("Decrypted Text: " + decrypted);

        sc.close();
    }
}

