package task1.connect4;

public class GameLogic {
    public static final int WIN_LENGTH = 4;
    private final GameBoard board;
    // stores the index of the next free row in each column
    private final int[] rowIndexes;
    private boolean isGameWon;

    public GameLogic(GameBoard board) {
        this.board = board;

        rowIndexes = new int[board.getWidth()];
        for (int i = 0; i < board.getWidth(); i++) {
            rowIndexes[i] = board.getHeight() - 1;
        }
    }

    public boolean playTurn(int column, int playerId) {
        if (column < 0 || column >= board.getWidth()) {
            return false;
        }
        // check if there is a free slot in the column
        int row = rowIndexes[column];
        if (row < 0) {
            return false;
        }
        board.setValue(row, column, playerId);
        rowIndexes[column]--;
        isGameWon = checkVictoryCondition(row, column, playerId);
        return true;
    }

    public boolean isWon() {
        return isGameWon;
    }

    public boolean isDraw() {
        return board.getPieceCount() == board.getSize();
    }

    public GameBoard getBoard() {
        return board;
    }


    private boolean checkVictoryCondition(int row, int column, int playerId) {
        return checkVertical(row, column, playerId)
                || checkHorizontal(row, column, playerId)
                || checkDiagonalSlash(row, column, playerId)
                || checkDiagonalBackslash(row, column, playerId);
    }

    private boolean checkVertical(int row, int column, int playerId) {
        int count = 1;
        for (int i = row + 1; i < board.getHeight()
                && board.getValue(i, column) == playerId; i++) {
            count++;
        }
        return count >= WIN_LENGTH;
    }

    private boolean checkHorizontal(int row, int column, int playerId) {
        int countLeft = 0;
        int countRight = 0;
        for (int i = column - 1; i >= 0
                && board.getValue(row, i) == playerId; i--) {
            countLeft++;
        }
        for (int i = column + 1; i < board.getWidth()
                && board.getValue(row, i) == playerId; i++) {
            countRight++;
        }
        return (countLeft + 1 + countRight) >= WIN_LENGTH;
    }

    private boolean checkDiagonalSlash(int row, int column, int playerId) {
        // southwest and northeast
        int countSW = 0;
        int countNE = 0;

        for (int i = row + 1, j = column - 1; i < board.getHeight() && j >= 0
                && board.getValue(i, j) == playerId; i++, j--) {
            countSW++;
        }
        for (int i = row - 1, j = column + 1; i >= 0 && j < board.getWidth()
                && board.getValue(i, j) == playerId; i--, j++) {
            countNE++;
        }
        return (countSW + 1 + countNE) >= WIN_LENGTH;
    }

    private boolean checkDiagonalBackslash(int row, int column, int playerId) {
        // northwest and southeast
        int countNW = 0;
        int countSE = 0;

        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0
                && board.getValue(i, j) == playerId; i--, j--) {
            countNW++;
        }
        for (int i = row + 1, j = column + 1; i < board.getHeight() && j < board.getWidth()
                && board.getValue(i, j) == playerId; i++, j++) {
            countSE++;
        }
        return (countNW + 1 + countSE) >= WIN_LENGTH;
    }

    /*
        private int findRow(int column){
        int row = height;
        while (row >= 0 && gameBoard[row][column] != -1) {
            row--;
        }
        return row;
    }
    */
}
