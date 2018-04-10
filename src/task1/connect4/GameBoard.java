package task1.connect4;

public class GameBoard {
    public static final int MIN_WIDTH = 4;
    public static final int MIN_HEIGHT = 4;
    private final int[][] gameBoard;
    private final int height;
    private final int width;
    private int pieceCount;

    public GameBoard(int height, int width) {
        if (width < MIN_WIDTH || height < MIN_HEIGHT) {
            throw new IllegalArgumentException();
        }
        this.gameBoard = new int[height][width];
        this.height = height;
        this.width = width;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gameBoard[i][j] = -1;
            }
        }
    }

    private boolean checkArrayBounds(int row, int column) {
        return (row >= 0 && row < height) && (column >= 0 && column < width);
    }

    public void setValue(int row, int column, int playerId){
        if (!checkArrayBounds(row, column)) {
            throw new IllegalArgumentException();
        }
        gameBoard[row][column] = playerId;
        pieceCount++;
    }

    public int getValue(int row, int column) {
        if (!checkArrayBounds(row, column)) {
            throw new IllegalArgumentException();
        }
        return gameBoard[row][column];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getSize() {
        return height * width;
    }

    public int getPieceCount() {
        return pieceCount;
    }
}
