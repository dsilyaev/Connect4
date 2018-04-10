package task1.connect4;

public class Connect4 {

    public static void main(String[] args) {
        Player[] players = {
                new Player(0, "X", 'X'),
                new Player(1, "O", 'O')
        };
        final int BOARD_HEIGHT = 8;
        final int BOARD_WIDTH = 8;

        GameBoard board = new GameBoard(BOARD_HEIGHT, BOARD_WIDTH);
        GameLogic game = new GameLogic(board);
        Console console = new Console("> ");

        console.printBoard(game.getBoard(), players);
        System.out.println();

        for (int i = 0; true; i++, i %= players.length) {
            Player player = players[i];

            System.out.println("Turn: " + player.getName());
            int column = console.readInteger();
            while (!game.playTurn(column - 1, player.getId())) {
                column = console.readInteger();
            }
            System.out.println();
            console.printBoard(game.getBoard(), players);
            System.out.println();

            if (game.isWon()) {
                System.out.println("The winner is " + player.getName() + ".");
                break;
            }
            else if (game.isDraw()) {
                System.out.println("It's a draw.");
                break;
            }
        }
    }
}
