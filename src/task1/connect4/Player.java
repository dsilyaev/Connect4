package task1.connect4;

public class Player {
    private final int id;
    private final String name;
    private final char gamePiece;

    public Player(int id, String name, char gamePiece) {
        if (id < 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.name = name;
        this.gamePiece = gamePiece;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getGamePiece() {
        return gamePiece;
    }
}
