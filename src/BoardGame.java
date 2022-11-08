// An abstract class that defines what a Board Game in general needs
public abstract class BoardGame implements Game{
    private Board board;

    public BoardGame() { }

    public abstract void playGame();
    public abstract boolean checkGameStatus();
    public abstract void showScore();
}
