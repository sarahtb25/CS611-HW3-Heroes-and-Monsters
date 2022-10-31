public abstract class BoardGame implements Game{
    private Board board;

    public BoardGame(int numberOfRows, int numberOfColumns) {
        board = new Board(numberOfRows, numberOfColumns);
    }

    public BoardGame(int numberOfRowsAndColumns) {
        board = new Board(numberOfRowsAndColumns);
    }

    public abstract boolean checkGameStatus();
    public abstract void showScore();
}
