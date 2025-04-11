import java.util.Scanner;

public class Test {

    private static int[] board = new int[9];
    private static int moves = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        initBoard();

        System.out.println("Willkommen zum 8-Puzzle Spiel!");

        while (!isGameOver()) {
            printBoard();

            System.out.print("Wähle eine Zahl (1-8), um sie zu verschieben: ");
            int move = scanner.nextInt();
            move(move);
            if (isGameOver()) {
                printBoard();
                System.out.println("Herzlichen Glückwunsch! Du hast das Spiel in " + moves + " Zügen gewonnen!");
                break;
            }
        }

        scanner.close();
    }
    public static void printBoard() {
        System.out.println("Aktuelles Spielfeld:");
        for (int i = 0; i < 9; i++) {
            if (board[i] == 0) {
                System.out.print("   ");
            } else {
                System.out.printf("%2d ", board[i]);
            }
            if (i == 2 || i == 5 || i == 8) {
                System.out.println();
            }
        }
        System.out.println("Züge: " + moves);
    }

    public static void initBoard() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 0};

        for (int i = 0; i < 9; i++) {
            int j = (int)(Math.random() * 9);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        for (int i = 0; i < 9; i++) {
            board[i] = nums[i];
        }
    }

    public static void move(int number) {
        int index = -1;

        for (int i = 0; i < 9; i++) {
            if (board[i] == number) {
                index = i;
                break;
            }
        }

        int emptyIndex = -1;
        for (int i = 0; i < 9; i++) {
            if (board[i] == 0) {
                emptyIndex = i;
                break;
            }
        }

        if (index == emptyIndex - 1 || index == emptyIndex + 1 || index == emptyIndex - 3 || index == emptyIndex + 3) {
            board[emptyIndex] = number;
            board[index] = 0;
            moves++;
        } else {
            System.out.println("Ungültiger Zug! Versuche es noch einmal.");
        }
    }

    public static boolean isGameOver() {
        for (int i = 0; i < 8; i++) {
            if (board[i] != i + 1) {
                return false;
            }
        }
        return true;
    }


}
