public class RowColumnarTransposition {

    public static void main(String[] args) {
        String message = "DELIVER GOODS AT NOON";
        message = message.replace(" ", "");
        int columns = 3;
        int rows = (int) Math.ceil((double) message.length() / columns);
        char[][] matrix = new char[rows][columns];
        int index = 0;
        int row = 0;
        while (row < rows) {
            int col = 0;
            while (col < columns) {
                if (index < message.length()) {
                    matrix[row][col] = message.charAt(index);
                    index++;
                } else {
                    matrix[row][col] = ' ';
                }
                col++;
            }
            row++;
        }
        System.out.println("Matrix:");
        row = 0;
        while (row < rows) {
            int col = 0;
            while (col < columns) {
                System.out.print(matrix[row][col] + " ");
                col++;
            }
            System.out.println();
            row++;
        }
        String cipherText = "";
        int col = 0;
        while (col < columns) {
            row = 0;
            while (row < rows) {
                if (matrix[row][col] != ' ') {
                    cipherText = cipherText + matrix[row][col];
                }
                row++;
            }
            col++;
        }
        System.out.println("Plain text  : " + message);
        System.out.println("Cipher text : " + cipherText);
    }
}
