package task1.connect4;

import java.util.Scanner;

public class Console {
    private final String prompt;

    public Console(String prompt) {
        this.prompt = prompt;
    }

    public int readInteger() {
        Scanner scanner = new Scanner(System.in);
        boolean inputOk = false;
        int input = 0;
        while (!inputOk) {
            System.out.print(prompt);
            String rawInput = scanner.nextLine();
            try {
                input = Integer.parseInt(rawInput);
                inputOk = true;
            }
            catch (NumberFormatException ex) {}
        }
        return input;
    }

    public void printBoard(GameBoard board, Player[] players) {
        int height = board.getHeight();
        int width = board.getWidth();
        printIndexes(width);
        printBorder(width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int cellValue = board.getValue(i, j);
                if (cellValue < 0) {
                    System.out.print('.');
                }
                else {
                    System.out.print(players[cellValue].getGamePiece());
                }
                if (j < width - 1) {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
        printBorder(width);
        printIndexes(width);
    }

    private void printIndexes(int width) {
        for (int i = 0; i < width; i++) {
            System.out.print(i + 1);
            if (i < width - 1) {
                System.out.print(' ');
            }
        }
        System.out.println();
    }

    private void printBorder(int width) {
        for (int i = 0; i < width; i++) {
            System.out.print('-');
            if (i < width - 1) {
                System.out.print('-');
            }
        }
        System.out.println();
    }
}
